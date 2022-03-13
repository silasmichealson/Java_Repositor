/**
 * 
 */
package learn;

import javax.sound.midi.*;

/**
 * @author wenlo
 *
 */
public class MiniMusicPlayer2 implements ControllerEventListener {//需要监听controlerEVent

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MiniMusicPlayer2 miniMusicPlayer2 = new MiniMusicPlayer2();
		miniMusicPlayer2.go();
	}
	
	public void go() {
	
		try {
			
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIwant = {127};
			sequencer.addControllerEventListener(this, eventsIwant);
			//向sequence注册事件,注册方法取用监听者与代表想监听的事件的int组
			
			Sequence sequence = new Sequence(Sequence.PPQ, 4);
			Track track =sequence.createTrack();
			
			for(int i=5;i<60;i+=4)
			{
				track.add(makEvent2(144, 1, i, 100, i));
				track.add(makEvent2(176, 1, 127, 0, i));
				//插入时间编号为127的自定义controllerEvent(176)不作任何事只是报告影评被播放,他的tick 和note on是同时进行
				
				track.add(makEvent2(128, 1, i, 100, i+2));
			}
			
			sequencer.setSequence(sequence);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void controlChange(ShortMessage event) {
		System.out.println("la");
	}

	public static MidiEvent makEvent2(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage aMessage = new ShortMessage();
			aMessage.setMessage(comd, chan, one, two);
			event = new MidiEvent(aMessage, tick);
		} catch (Exception e) {
		}
		return event;
	}

}
