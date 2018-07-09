package XO;

import java.awt.*;
import javax.swing.*;

public class GameLuah extends JPanel {

	private JButton[][] buttons;

	private Calculations calculations;

	private Font font;

	private String message;

	public GameLuah() {
		super();
		calculations = new Calculations(this);
		message = "X's turn";
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
		this.setLayout(new GridLayout(4, 3));
		this.setSize(2000, 300);

		buttons = new JButton[3][3];
		for (int i = 0; i < buttons.length; i++)
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				this.add(buttons[i][j]);
				buttons[i][j].setLocation(i * 10, j * 10);
				buttons[i][j].addActionListener(calculations);
				buttons[i][j].setActionCommand(i + "," + j);
			}

	}

	public void setMessage(String s) {
		message = s;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(00, 150, 00));
		g.setFont(font);
		g.drawString(message, 750, 600);

	}

	public Dimension getPreferredSize() {
		return new Dimension(1000, 200);
	}

}
