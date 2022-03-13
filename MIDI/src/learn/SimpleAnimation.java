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
		// TODO 自动生成的方法存根
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
				Thread.sleep(50);//加上延迟 线程会一下跑完
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}
	
	class MyDrawPanel_an extends JPanel	//内部类来实现传参的移动
	{
		public void paintComponent(Graphics g) {
			//绘画出来有痕迹
			//g.setColor(Color.orange);
			//g.fillOval(x, y, 40, 40);
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());//每次画之前重新刷画板为白色
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
		}
	}

}
