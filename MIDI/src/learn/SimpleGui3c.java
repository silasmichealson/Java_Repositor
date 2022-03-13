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
public class SimpleGui3c implements ActionListener{

	/**
	 * @param args
	 */
	
	JFrame frame;
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		SimpleGui3c gui3c = new SimpleGui3c();
		gui3c.go();
	}
	
	public void go() {
		frame = new JFrame();//创建窗口
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//在window关闭的时候结束程序
		
		JButton button = new JButton("change colors");//创建按钮
		button.addActionListener(this);//为按钮添加监听器 即对此按钮操作时会被检测到
		
		MyDrawPanel1 drawPanel = new MyDrawPanel1();//创建自己的绘图程序
		
		frame.getContentPane().add(BorderLayout.SOUTH,button);//将创建好的按钮添加到窗口
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);//将创建的函数添加到窗口
		//窗口
		//		north
		//west  center  east
		//		south
		
		frame.setSize(300,300);//设置窗口大小
		frame.setVisible(true);//显示窗口哦
	}
	
	public void actionPerformed(ActionEvent event) {
		//实现interface上的方法 按钮会以actionevent对象作为参数来调用此方法
		frame.repaint();//当点击按钮则新绘制窗口
	}

}

class MyDrawPanel1 extends JPanel	//此方法会在重新绘制frame的时候被调用
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

