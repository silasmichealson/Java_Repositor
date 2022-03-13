# MIDI_player 开发流程及问题归纳

2022/3/11 10:16:08 
## 开发框架
- Swing GUI
- 网络连接
- 将数据传输到I/O设备
- JavaSound的API


### 第一部分 JavaSound API
#### 1. 异常理解
在MusicTest1.java文件编译时出现报错  
【报错】:  
>$ javac MusicTest1.java  
MusicTest1.java:5: 错误: 未报告的异常错误  
MidiUnavailableException; 必须对其进行捕获或声明以便抛  
Sequencer sequencer = MidiSystem.getSequencer();   
1 个错误  

【解决方法】:此处是Java编译器要我们知道调用的方法有风险,使用API帮助文档查看此函数  

> public static Sequencer getSequencer()
> throws MidiUnavailableException获取默认设备Sequencer ，连接到默认设备。   
> 返回的Sequencer实例连接到默认的Synthesizer ，如getSynthesizer()所示 。   
> 如果没有Synthesizer可用，或默认Synthesizer无法打开，则sequencer连接到默认值Receiver ，由getReceiver()返回。   
> 连接是通过检索取得Transmitter从实例Sequencer并设置其Receiver 。 关闭并重新打开音序器将恢复与默认设备的连接。   
> 此方法相当于调用getSequencer(true) 。 
> 
> 如果系统属性javax.sound.midi.Sequencer已被定义或在文件“sound.properties”中定义，则用于标识默认的音序器。 详情请参考class description 。 

> 结果   
> 默认音序器，连接到默认接收器   
> 异常   
> MidiUnavailableException -如果序不可由于资源限制，或者没有 Receiver可通过任何安装 MidiDevice ，或无定序器安装在系统中。   
> 另请参见： 
> getSequencer(boolean) ， getSynthesizer() ， getReceiver() 

    try{
     //危险动作
    }catch(Exception ex){
    //尝试恢复
    }

  
在MusicTest1.java文件编译时出现报错    
【报错】 javac的时候 中文注释报错  
【解决方法】 第一 chcp 65001  
第二 javac -encoding UTF-8 xxx.java  

#### 2. MIDI理解
查看 MIDI文件夹/MiniMiniMusicApp.Java注释

> midi文件有音乐的信息,但不具备声音本身,类似乐谱 -> midi装置知道如何读取midi文件并加以播放-> 喇叭发声

/*
 * @Descripttion: 
 * @version: 
 * @Author: silas
 * @Date: 2022-03-11 20:01:45
 * @LastEditors: silas
 * @LastEditTime: 2022-03-11 20:23:27
 */
import javax.sound.midi.*;//将midi的包import进去

//midi文件有音乐的信息,但不具备声音本身,类似乐谱 -> midi装置知道如何读取midi文件并加以播放
//-> 喇叭发声

	public class MiniMiniMusicApp {

    public static void main(String[] args)
    {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play()
    {
        try{
            //获得一个 sequencer 播放装置
            Sequencer player = MidiSystem.getSequencer();
            //MidiUnavailableException ex 此处getsequencer的异常时
            player.open();//打开播放装置

            //创建要播放的东西
            Sequence seq = new Sequence(Sequence.PPQ, 4);//参数意义未知
            
            //带有乐曲信息的记录
            Track track = seq.createTrack();

            //乐曲的音乐符等信息
            ShortMessage a = new ShortMessage();//Massage描述做什么.MidiEvent描述什么时候做
            a.setMessage(144, 1, 44, 100);//发出44分音符
            MidiEvent noteon = new MidiEvent(a, 1);//在第一拍启动a这个massage
            track.add(noteon);

            /*
            setMassage(144,1,44,100)
            参数1 类型 144表示开启 128表示关闭
            参数2 频道 1是吉他 2是Bass 
            参数3 音符 0~127 的是不同音高
            参数4 音道 多大声音0~100
            */

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteoff = new MidiEvent(b, 16);
            track.add(noteoff);

            player.setSequence(seq);//将sequence送到sequencer上
            player.start();

        }catch(Exception ex){//此处用ex 父类来检测所有异常
            ex.printStackTrace();
        }
    }
    
	}

配合的有几个Mini播放器的实现



