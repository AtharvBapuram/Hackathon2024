//Atharv Bapuram

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;



@SuppressWarnings("serial")
//TODO: Change the name of the class from AnimationShell to the name of your class
public class FoodFight extends JPanel {

	//TODO: set the initial width and height of your image
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	//required global variables
	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private Pizza p1;
	//private Weapon1 weapon1;
	//private Ball[] balls = new Ball[2];
	//TODO: change this to whatever object(s) you are animating

	//Constructor required by BufferedImage
	public FoodFight() {
		//set up Buffered Image and Graphics objects
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		

		p1 = new Pizza(0, 0);
		
		//weapon1 = new Weapon1(0, 0);
		/*for (int i = 0; i < balls.length; i++) {
			balls[i] = new Ball((int) 1000, 1000, 10, new Color(0, 0, 255));
			balls[i].setRandomSpeed(0);
		}*/

		//set up and start the Timer
		timer = new Timer(10, new TimerListener());
		timer.start();
		
		addMouseListener(new Mouse());
		addMouseWheelListener(new MouseWheel());
		addKeyListener(new Keyboard());
		setFocusable(true);
		addMouseMotionListener(new MouseMotion());


	}
	
	private class Keyboard implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				p1.setY(p1.getY() - 5);
				//weapon1.setY(weapon1.getY() - 5);
				p1.setWalking(true);
				p1.walking();
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				p1.setY(p1.getY() + 5);
				//weapon1.setY(weapon1.getY() + 5);
				p1.setWalking(true);
				p1.walking();
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				p1.setX(p1.getX() - 5);
				//weapon1.setX(weapon1.getX() - 5);
				p1.setWalking(true);
				p1.walking();
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				p1.setX(p1.getX() + 5);
				//weapon1.setX(weapon1.getX() + 5);
				p1.setWalking(true);
				p1.walking();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_D) { 
				p1.setWalking(false);
			}
			if (e.getKeyCode() == KeyEvent.VK_A) { 
				p1.setWalking(false);
			}
			if (e.getKeyCode() == KeyEvent.VK_S) { 
				p1.setWalking(false);
			}
			if (e.getKeyCode() == KeyEvent.VK_W) { 
				p1.setWalking(false);
			}
			
		}
		
	}
	
	private class MouseWheel implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if (e.getWheelRotation() == -1) {
			} else if (e.getWheelRotation() == 1) {
			}
		}
		
	}
	
	private class Mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			/*if (e.getButton() == 1) {
				balls[0].setX(p1.getXPlayerCenter() + 16 - weapon1.pDistanceX());
				balls[0].setY(p1.getYPlayerCenter() + weapon1.pDistanceY(weapon1.getY(), p1.getYPlayerCenter()));
			}
			if (e.getButton() == 3) {
			}*/
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	
	
	private class MouseMotion implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			
		}

		public void mouseMoved(MouseEvent e) {
			p1.direction(e.getX());
			//weapon1.rotatedImage(p1.getXPlayerCenter(), e.getX(), p1.getYPlayerCenter(), e.getY());
		}
	}

	
	//TimerListener class that is called repeatedly by the timer
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			//weapon1.draw(g);
			p1.draw(g);
			/*for(int i = 0; i < balls.length; i++) {
				balls[i].draw(g);
			}*/
			
			repaint(); //leave this alone, it MUST  be the last thing in this method
		}
		
	}

	//do not modify this
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
	public Color randomColor() {
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		Color randomColor = new Color(r, g, b);
		return randomColor;
	}
		//main method with standard graphics code
	public static void main(String[] args) {
		JFrame frame = new JFrame("Game Tester");
		frame.setSize(WIDTH + 18, HEIGHT + 47);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new FoodFight()); //TODO: Change this to the name of your class!
		frame.setVisible(true);
	}

}
