/**
 * 
 */
package learn;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author wenlo
 *
 */
public class SimpleGui1b implements ActionListener{
	JButton button;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SimpleGui1b gui = new SimpleGui1b();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("click me");
		
		button.addActionListener(this);//��butttonע��
		
		frame.getContentPane().add(BorderLayout.CENTER,button);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		button.setText("i have been clicked");//ʵ��interface�ϵķ��� ��ť����actionevent������Ϊ���������ô˷���
		
	}

}
