/**
 * 
 */
package learn;
import javax.swing.*;
import java.awt.*;
/**
 * @author wenlo
 *
 */
public class SimpleAnimation {

	/**
	 * @param args
	 */
	int x = 70;int y = 70;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SimpleAnimation guiAnimation = new SimpleAnimation();
		guiAnimation.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel_an deDrawPanel = new MyDrawPanel_an();
		
		frame.getContentPane().add(deDrawPanel);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		for(int i =0 ;i <130;i++)
		{
			x++;y++;
			
			deDrawPanel.repaint();
			
			try {
				Thread.sleep(50);//�����ӳ� �̻߳�һ������
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}
	
	class MyDrawPanel_an extends JPanel	//�ڲ�����ʵ�ִ��ε��ƶ�
	{
		public void paintComponent(Graphics g) {
			//�滭�����кۼ�
			//g.setColor(Color.orange);
			//g.fillOval(x, y, 40, 40);
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());//ÿ�λ�֮ǰ����ˢ����Ϊ��ɫ
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
		}
	}

}
