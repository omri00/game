package XO;

import javax.swing.*;
import java.awt.event.*;

public class Calculations implements ActionListener {
	private int[][] items;

	private boolean xTurn = true;

	private int turn = 0;

	private GameLuah gameLuah;

	public Calculations(GameLuah gameLuah) {
		this.gameLuah = gameLuah;
		items = new int[3][3];

	}

	public void actionPerformed(ActionEvent ev) {
		JButton currentButton;
		currentButton = (JButton) ev.getSource();
		String ij = currentButton.getActionCommand();
		int i = ij.charAt(0) - '0';
		int j = ij.charAt(2) - '0';
		if (items[i][j] == 0) {
			turn++;
			if (xTurn) {
				items[i][j] = 1;
				currentButton.setText("X");
				gameLuah.setMessage("O's Turn");
				if (checkWin(1)) {
					gameLuah.setMessage("X won");
					fill();
				}
			} else {
				items[i][j] = 2;
				currentButton.setText("O");
				gameLuah.setMessage("X's Turn");
				if (checkWin(2)) {
					gameLuah.setMessage("O won");
					fill();
				}
			}
			xTurn = !xTurn;
			if (turn == 9) {
				gameLuah.setMessage("DRAW");
			}
		}
		// change the text/item of button
		// invoke the calculation functions
		gameLuah.repaint();
	}

	public boolean checkWin(int playerNum) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[i].length; j++) {
				if (items[i][j] != playerNum)
					break;
				if (j == items[i].length - 1)
					return true;
			}

		}

		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[i].length; j++) {
				if (items[j][i] != playerNum)
					break;
				if (j == items[i].length - 1)
					return true;
			}

		}

		for (int i = 0; i < items.length; i++) {
			if (items[i][i] != playerNum)
				break;
			if (i == items[i].length - 1)
				return true;
		}

		for (int i = 0; i < items.length; i++) {
			if (items[items.length - i - 1][i] != playerNum)
				break;
			if (i == items[i].length - 1)
				return true;
		}
		return false;
	}

	private void fill() {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[i].length; j++) {
				items[j][i] = 9;
			}
		}
	}

}
