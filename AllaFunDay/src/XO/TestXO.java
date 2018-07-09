package XO;

import java.awt.*;
import javax.swing.*;

public class TestXO {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Game XO");
		frame.setSize(2000, 1000);
		GameLuah gameLuah = new GameLuah();
		frame.getContentPane().add(gameLuah);
		gameLuah.setBackground(Color.blue);
		frame.add(gameLuah, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}