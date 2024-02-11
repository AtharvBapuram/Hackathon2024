import java.awt.Color;
import java.awt.Graphics;

public class Blueberry {
	private int hp;
	private double x;
	private double y;
	private double xSpeed;
	private double ySpeed;
	private final double gravity = 2;
	private final double radius = 10;

	public Blueberry(double X, double Y) {

		hp = 100;
		x = X;
		y = Y;

	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval((int) (x - radius), (int) (y - radius), (int) radius * 2, (int) radius * 2);
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
