package Sprites;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

class Board extends JPanel implements Runnable {

	private boolean shoot = false;
	private boolean fired = false;

	private MovableObject oldMan = new MovableObject(100, 330,"oldman");
	
	private MovableObject energyball = new MovableObject(100, 350,"energyball");

	private boolean ovdeg;

	public Board() {

		addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					shoot = true;
			}
		});

		JFrame frame = new JFrame("Sprites");
		frame.setBounds(10, 10, 900, 500);
		frame.add(this, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.gray);
		frame.setVisible(true);
		Thread t = new Thread(this, "ov");
		t.start();
	}

	public void run() {

		double time = 100;

		ovdeg = true;
		while (ovdeg) {
			if (shoot) {
				oldMan.oneCycle();
				if(oldMan.getState() == 0) {
					shoot = false;
				}
				if(oldMan.getState() == 3 && !fired) {
					energyball.setPlace(120, 340);
					fired = true;
				}
			}
			if(fired) {
				energyball.move(50, 0);
				if(energyball.getState()<2)
					energyball.oneCycle();
				if(energyball.getState() == 4) {
					fired = false;
				}
				if(energyball.getX() > 550)
					energyball.oneCycle();
			}
			repaint();
			try {
				Thread.sleep((int) time);
			} catch (InterruptedException e) {
				System.out.println("Sleep Error");
			}

		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawRect(40, 40, 660, 400);
		oldMan.draw(g);
		if(fired)
			energyball.draw(g);
	}

	public static void main(String[] args) {
		Board board = new Board();

	}
}