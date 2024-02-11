import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Celery {
	private int hp;
	private int x;
	private int y;
	private int xPlayerCenter;
	private int yPlayerCenter;
	private boolean faceRight;
	private int xSpeed;
	private int ySpeed;
	private final int gravity = 2;
	private final int radius = 10;
	private ImageIcon image = new ImageIcon("Halo-Pixel-Pal-3.png");

	public Celery(int x, int y) {
		hp = 100;
		this.x = x;
		this.y = y;
		xPlayerCenter = this.x + 64;
		yPlayerCenter = this.y + 64;
		faceRight = true;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage(), x, y, 100, 100, null);
	}

	public void move(int width, int height) {
		ySpeed += gravity;
		y = y + ySpeed;
		if (y <= radius) {
			y = radius;
			ySpeed = 1;
		}
		if (x + xSpeed > radius && x + xSpeed < width - radius) {
			x += xSpeed;
		}

		if (y > height - radius) {
			y = height - radius;
			ySpeed = 0;
		}
	}

	public void jump(int power, int height) {
		if (y >= height - 20) {
			ySpeed -= power;
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public double getySpeed() {
		return ySpeed;
	}

	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	public double getGravity() {
		return gravity;
	}

	public double getRadius() {
		return radius;
	}

}
