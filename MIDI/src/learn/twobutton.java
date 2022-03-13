/**
 * 
 */
package learn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author wenlo
 *
 */
public class twobutton {

	/**
	 * @param args
	 */
	
	JFrame frame;
	JLabel lable;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		twobutton twobn = new twobutton();
		twobn.go();
	}
	
	public void go() {
		frame = new JFrame();//创建窗口
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//在window关闭的时候结束程序
		
		JButton button = new JButton("change colors");//创建按钮
		button.addActionListener(new colorlisterner());//为按钮添加监听器 即对此按钮操作时会被检测到
		
		JButton labButton = new JButton("change lable");
		labButton.addActionListener(new lablelistener());
		
		lable = new JLabel("i am a lable");
		MyDrawPanel drawPanel = new MyDrawPanel();//创建自己的绘图程序
		
		frame.getContentPane().add(BorderLayout.SOUTH,button);//将创建好的按钮添加到窗口
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);//将创建的函数添加到窗口
		frame.getContentPane().add(BorderLayout.EAST,labButton);
		frame.getContentPane().add(BorderLayout.WEST,lable);
		//窗口
		//		north
		//west  center  east
		//		south
		
		frame.setSize(500,500);//设置窗口大小
		frame.setVisible(true);//显示窗口哦
	}
	
//	public void actionPerformed(ActionEvent event) {
//		//实现interface上的方法 按钮会以actionevent对象作为参数来调用此方法
//		frame.repaint();//当点击按钮则新绘制窗口
//	} 
// 	方法一 :
//	此处由于两个按钮 ,如果都声明一样的方法  (如下) 则编译器无法分辨 哪个 所以不行的
//	public void actionPerformed(ActionEvent event){ fram.repaint()};
//	public void actionPerformed(ActionEvent event){lable.settext("new test)};
	
//	方法二:对两个按钮注册同一个监听接口 辨别来自哪个 ok但是不是面向对象的思想
//	public void actionPerformed(ActionEvent event) {
//	//实现interface上的方法 按钮会以actionevent对象作为参数来调用此方法
//	if(enent.getsource() == coloButton) frame.repaint()//当点击按钮则新绘制窗口
//  else lable.setText("new");
//	} 
	
	
//	方法上:创建不同的actionlistener
//	class colorbuttonlistener implements ActionListener
//	{ public void actionPerformed(ActionEvent event) {}}
//	class lablebuttonlistener implements ActionListener
//	{ public void actionPerformed(ActionEvent event) {}}
//这些类无法取到所需的变量
	
	//解决方法 : 内部类
	class colorlisterner implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			frame.repaint();
		}
	}
	class lablelistener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			lable.setText("ouch");
		}
	}
}

class MyDrawPanel extends JPanel	//此方法会在重新绘制frame的时候被调用
{
	public void  paintComponent(Graphics g)//实际是一个Graphic 2d对象
	{
		Graphics2D graphics2d = (Graphics2D) g;//将类型转换为2d
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		int red = (int)(Math.random()*255);
		
		Color startColor = new Color(red,green,blue);
		
		green = (int)(Math.random()*255);
		blue = (int)(Math.random()*255);
		red = (int)(Math.random()*255);
		Color endColor = new Color(red,green,blue);
		
		GradientPaint gradientPaint=new GradientPaint(70, 70, startColor, 150,150,endColor);
		//70,70 起点 开始颜色 150,150终点 最后颜色
		graphics2d.setPaint(gradientPaint);
		//将虚拟的笔刷换渐层 
		graphics2d.fillOval(70, 70, 100, 100);
		//用目前的笔刷填满椭圆形的区域
	}
}

