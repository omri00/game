package Sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class MovableObject {

	private double x, y;
	private int state;

	private Image[] picts = new Image[5];

	public MovableObject(int x, int y, String pic) {
		this.x = x;
		this.y = y;
		state = 0;
		ImageIcon ic = new ImageIcon("imgs/" + pic + ".png");
		int imageHight = ic.getIconHeight();
		int w = ic.getIconWidth();
		BufferedImage bimg = new BufferedImage(w, imageHight, BufferedImage.TYPE_INT_ARGB);
		Graphics gr = bimg.getGraphics();
		gr.drawImage(ic.getImage(), 0, 0, null);
		int py = 0, h = imageHight / picts.length;
		for (int i = 0; i < picts.length; i++) {
			picts[i] = bimg.getSubimage(0, py, w, h);
			py += h;
		}
	}

	public int getState() {
		return state;
	}

	public void oneCycle() {
		state++;
		if (state == picts.length)
			state = 0;
	}
	
	public void move(int x,int y) {
		this.x += x;
		this.y += y;
	}

	public double getX() {
		return x;
	}

	public void setPlace(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public void draw(Graphics g) {
		g.drawImage(picts[state], (int) x, (int) y, Color.gray, null);

	}

}
