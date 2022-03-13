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
		// TODO �Զ����ɵķ������
		SimpleGui3c gui3c = new SimpleGui3c();
		gui3c.go();
	}
	
	public void go() {
		frame = new JFrame();//��������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��window�رյ�ʱ���������
		
		JButton button = new JButton("change colors");//������ť
		button.addActionListener(this);//Ϊ��ť��Ӽ����� ���Դ˰�ť����ʱ�ᱻ��⵽
		
		MyDrawPanel1 drawPanel = new MyDrawPanel1();//�����Լ��Ļ�ͼ����
		
		frame.getContentPane().add(BorderLayout.SOUTH,button);//�������õİ�ť��ӵ�����
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);//�������ĺ�����ӵ�����
		//����
		//		north
		//west  center  east
		//		south
		
		frame.setSize(300,300);//���ô��ڴ�С
		frame.setVisible(true);//��ʾ����Ŷ
	}
	
	public void actionPerformed(ActionEvent event) {
		//ʵ��interface�ϵķ��� ��ť����actionevent������Ϊ���������ô˷���
		frame.repaint();//�������ť���»��ƴ���
	}

}

class MyDrawPanel1 extends JPanel	//�˷����������»���frame��ʱ�򱻵���
{
	public void  paintComponent(Graphics g)//ʵ����һ��Graphic 2d����
	{
		Graphics2D graphics2d = (Graphics2D) g;//������ת��Ϊ2d
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		int red = (int)(Math.random()*255);
		
		Color startColor = new Color(red,green,blue);
		
		green = (int)(Math.random()*255);
		blue = (int)(Math.random()*255);
		red = (int)(Math.random()*255);
		Color endColor = new Color(red,green,blue);
		
		GradientPaint gradientPaint=new GradientPaint(70, 70, startColor, 150,150,endColor);
		//70,70 ��� ��ʼ��ɫ 150,150�յ� �����ɫ
		graphics2d.setPaint(gradientPaint);
		//������ı�ˢ������
		graphics2d.fillOval(70, 70, 100, 100);
		//��Ŀǰ�ı�ˢ������Բ�ε�����
	}
}

