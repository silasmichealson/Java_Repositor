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
		// TODO �Զ����ɵķ������
		twobutton twobn = new twobutton();
		twobn.go();
	}
	
	public void go() {
		frame = new JFrame();//��������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��window�رյ�ʱ���������
		
		JButton button = new JButton("change colors");//������ť
		button.addActionListener(new colorlisterner());//Ϊ��ť��Ӽ����� ���Դ˰�ť����ʱ�ᱻ��⵽
		
		JButton labButton = new JButton("change lable");
		labButton.addActionListener(new lablelistener());
		
		lable = new JLabel("i am a lable");
		MyDrawPanel drawPanel = new MyDrawPanel();//�����Լ��Ļ�ͼ����
		
		frame.getContentPane().add(BorderLayout.SOUTH,button);//�������õİ�ť��ӵ�����
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);//�������ĺ�����ӵ�����
		frame.getContentPane().add(BorderLayout.EAST,labButton);
		frame.getContentPane().add(BorderLayout.WEST,lable);
		//����
		//		north
		//west  center  east
		//		south
		
		frame.setSize(500,500);//���ô��ڴ�С
		frame.setVisible(true);//��ʾ����Ŷ
	}
	
//	public void actionPerformed(ActionEvent event) {
//		//ʵ��interface�ϵķ��� ��ť����actionevent������Ϊ���������ô˷���
//		frame.repaint();//�������ť���»��ƴ���
//	} 
// 	����һ :
//	�˴�����������ť ,���������һ���ķ���  (����) ��������޷��ֱ� �ĸ� ���Բ��е�
//	public void actionPerformed(ActionEvent event){ fram.repaint()};
//	public void actionPerformed(ActionEvent event){lable.settext("new test)};
	
//	������:��������ťע��ͬһ�������ӿ� ��������ĸ� ok���ǲ�����������˼��
//	public void actionPerformed(ActionEvent event) {
//	//ʵ��interface�ϵķ��� ��ť����actionevent������Ϊ���������ô˷���
//	if(enent.getsource() == coloButton) frame.repaint()//�������ť���»��ƴ���
//  else lable.setText("new");
//	} 
	
	
//	������:������ͬ��actionlistener
//	class colorbuttonlistener implements ActionListener
//	{ public void actionPerformed(ActionEvent event) {}}
//	class lablebuttonlistener implements ActionListener
//	{ public void actionPerformed(ActionEvent event) {}}
//��Щ���޷�ȡ������ı���
	
	//������� : �ڲ���
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

class MyDrawPanel extends JPanel	//�˷����������»���frame��ʱ�򱻵���
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

