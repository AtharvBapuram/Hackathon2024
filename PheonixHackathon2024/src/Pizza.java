import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Pizza extends JPanel{
	
	private int x;
	private int y;
	private int xPlayerCenter;
	private int yPlayerCenter;
	private boolean faceRight;
	private boolean walking;
	private ImageIcon image = new ImageIcon("PizzaFaceRight.png");

	
	public Pizza() {
		x = 0;
		y = 0;
		xPlayerCenter = this.x + 32;
		yPlayerCenter = this.y + 32;
		faceRight = true;
	}
	
	public Pizza(int x, int y) {
		this.x = x;
		this.y = y;
		xPlayerCenter = this.x + 32;
		yPlayerCenter = this.y + 32;
		faceRight = true;
		walking = false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, 100, 100, null);
		walking = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getXPlayerCenter() {
		return xPlayerCenter;
	}
	
	public int getYPlayerCenter() {
		return yPlayerCenter;
	}
	
	public void setX(int x) {
		this.x = x;
		xPlayerCenter = x + 32;
	}
	
	public void setY(int y) {
		this.y = y;
		yPlayerCenter = y + 32;
	}
	
	public void setWalking(boolean walking) {
		this.walking = walking;
	}
	
	public void direction(int xMouse) {
		if (xMouse > xPlayerCenter) {
			if (walking) {
				image = new ImageIcon("PizzaWalkRight.gif");
			} else {
				image = new ImageIcon("PizzaFaceRight.png");
			}
			faceRight = true;
		} else {
			if (walking) {
				image = new ImageIcon("{PizzaWalkLeft.gif");
			} else {
				image = new ImageIcon("PizzaFaceLeft.png");
			}
			faceRight = false;
		}
	}
	
	public void walking() {
		if (faceRight && walking) {
			image = new ImageIcon("PizzaWalkRight.gif");
		} else if (!faceRight && walking) {
			image = new ImageIcon("PizzaWalkLeft.gif");
		}
	}
}