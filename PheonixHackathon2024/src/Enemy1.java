import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Enemy1{

	private int x;
	private int y;
	private int xEnemyCenter;
	private int yEnemyCenter;
	private int xSpeed;
	private int ySpeed;
	private boolean faceRight;
	private boolean faceDown;
	private boolean attacking = false;
	private boolean dead = false;
	private int dim = 128;
	private int hp = 400;
	private int time = 10;
	private ImageIcon image = new ImageIcon("ZealotIdleLeft.png");
	private ImageIcon eFaceRight;
	private ImageIcon eFaceLeft;
	private ImageIcon eWalkLeft;
	private ImageIcon eWalkRight;
	private final int gravity = 2;

	public Enemy1(int x, int y, String character) {
		this.x = x;
		this.y = y;
		if(character.equals("pizza")) {
			dim = 64;
			eFaceLeft = new ImageIcon("PizzaFaceLeft.png");
			eFaceRight = new ImageIcon("PizzaFaceRight.png");
			eWalkLeft = new ImageIcon("PizzaWalkLeft.gif");
			eWalkRight = new ImageIcon("PizzaWalkRight.gif");
		}
		if(character.equals("celery")) {
			eFaceLeft = new ImageIcon("CeleryFaceRight.png");
			eFaceRight = new ImageIcon("CeleryFaceRight.png");
			eWalkLeft = new ImageIcon("CeleryWalkRight.gif");
			eWalkRight = new ImageIcon("CeleryWalkRight.gif");
		}
		if(character.equals("berry")) {
			eFaceLeft = new ImageIcon("BerryFaceLeft.png");
			eFaceRight = new ImageIcon("BerryFaceRight.png");
			eWalkLeft = new ImageIcon("BerryWalkLeft.gif");
			eWalkRight = new ImageIcon("BerryWalkRight.gif");
		}
		image = eFaceLeft;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, 200, 200, null);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getXEnemyCenter() {
		return xEnemyCenter;
	}
	
	public int getYEnemyCenter() {
		return yEnemyCenter;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public boolean getDead() {
		return dead;
	}
	
	public void setX(int x) {
		this.x = x;
		xEnemyCenter = x + 64;
		if(dim == 64) {
			xEnemyCenter = x + 32;
		}
	}
	
	public void setY(int y) {
		this.y = y;
		yEnemyCenter = y + 64;
		if(dim == 64) {
			yEnemyCenter = y + 32;
		}
	}
	
	public void setSpeed(int Speed) {
		xSpeed = Speed;
		ySpeed = Speed;
	}
	
	public boolean yRange(int yPlayerCenter) {
		if ((yPlayerCenter - yEnemyCenter) < 50 && (yPlayerCenter - yEnemyCenter) > -50) {
			return true;
		} else {
			return false;
		}
	}
	
	/*public boolean hitDetection(Projectile[] projectiles) {
		for (int i = 0; i < projectiles.length; i++) {
			if (projectiles[i].getXCenter() < (xZealotCenter + 64) && projectiles[i].getXCenter() > (xZealotCenter - 64)) {
				if (projectiles[i].getYCenter() < (yZealotCenter + 64) && projectiles[i].getYCenter() > (yZealotCenter - 64)) {
					hp -= 50;
					if (hp <= 0) {
						dead = true;
						return true;
					}
				}
			}
		}
		return false;
	}*/
	
	public void direction(int xPlayerCenter, int yPlayerCenter) {
		if (yPlayerCenter > yEnemyCenter) {
			faceDown = true;
		} else {
			faceDown = false;
		}
		if (xPlayerCenter > xEnemyCenter) {
			if ((xPlayerCenter - xEnemyCenter) < 50 && yRange(yPlayerCenter)) {
				//image = new ImageIcon("ZealotSwingRight.gif");
				attacking = true;
			} else {
				image = new ImageIcon("eWalkRight.gif");
				attacking = false;
			}
			faceRight = true;
		} else {
			if ((xEnemyCenter - xPlayerCenter) < 50 && yRange(yPlayerCenter)) {
				//image = new ImageIcon("ZealotSwingLeft.gif");
				attacking = true;
			} else {
				image = new ImageIcon("eWalkLeft.gif");
				attacking = false;
			}
			faceRight = false;
		}
	}
	
	public int damageDealt() {
		time += 10;
		if(attacking) {
			if((time)%500 == 0) {
				return 50;
			}
		}
		return 0;
	}
	
	public void move(int height) {
		if(!dead) {
			if (faceRight) {
				setX(getX() + xSpeed);
				if (faceDown) {
					setY(getY() + ySpeed);	
				} else {
					setY(getY() - ySpeed);
				}
			} else {
				setX(getX() - xSpeed);
				if (faceDown) {
					setY(getY() + ySpeed);	
				} else {
					setY(getY() - ySpeed);
				}
			}
			setySpeed(getySpeed()+gravity);
			if (getY()<=height-50) {
				ySpeed=0;
			}
		} else {
			int num = (int) (Math.random() * 3);
			if(num == 0) {
				setX(1000);
				setY(50);
			} else if (num == 1) {
				setX(50);
				setY(1000);
			} else if (num == 2) {
				setX(1000);
				setY(1000);
			}
		}
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
}
