package Ball;
import java.awt.*;
import javax.swing.*;

class Ball extends JPanel implements Runnable {
	private int y;

	private int speed;

	public Ball() {
		y = 200;
		speed = 0;
		setBackground(Color.blue);
	}

	public void run() {
		while (true) {
			speed += 10;
			y += speed;
			if (y > 650)
				speed = -11*10;
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Sleep Error");
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillOval(850, y, 100, 100);
	}

	public Dimension getPreferredSize() {
		return new Dimension(300, 300);
	}

	public static void main(String[] args) {
		Ball oval = new Ball();
		JFrame frame = new JFrame("***");
		frame.add(BorderLayout.CENTER, oval);
		frame.setBounds(0, 0, 2000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread t = new Thread(oval, "ov"); // run עצם מכיל שיטה
		t.start(); // run מריצים שיטה
	}

}
