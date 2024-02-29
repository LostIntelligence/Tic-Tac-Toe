import java.util.Arrays;

import javax.swing.JOptionPane;

public class Logic {
	boolean gamewin = false;
	int input;
	int winner = 0;
	int[][] gameLogic = {
			{ 0, 0, 0 },
			{ 0, 0, 0 },
			{ 0, 0, 0 }
	};
	boolean firstplayer = true;

	public int[][] getArray() {
		return gameLogic;
	}

	public void doMove(String btn) {
		input = Integer.parseInt(btn);
		int chosenRow = input / 10;
		int chosenColumn = input % 10;

		if (gameLogic[chosenRow][chosenColumn] == 0) {
			if (firstplayer == true) {
				gameLogic[chosenRow][chosenColumn] = 1;
				firstplayer = false;

			} else if (firstplayer == false) {
				gameLogic[chosenRow][chosenColumn] = 2;
				firstplayer = true;

			}
		}
		System.out.println(Arrays.deepToString(gameLogic).replace("], ", "]\n"));
	}

	public void checkWin() {
		for (int i = 0; i < 3; i++) {

			if (gameLogic[i][0] == 1 && gameLogic[i][1] == 1 && gameLogic[i][2] == 1) {
				gamewin = true;
				winner = 1;
				break;
			}

			if (gameLogic[i][0] == 2 && gameLogic[i][1] == 2 && gameLogic[i][2] == 2) {
				gamewin = true;
				winner = 2;
				break;
			}

			if (gameLogic[0][i] == 1 && gameLogic[1][i] == 1 && gameLogic[2][i] == 1) {
				gamewin = true;
				winner = 1;
				break;
			}

			if (gameLogic[0][i] == 2 && gameLogic[1][i] == 2 && gameLogic[2][i] == 2) {
				gamewin = true;
				winner = 2;
				break;
			}
			if (gameLogic[0][0] == 2 && gameLogic[1][1] == 2 && gameLogic[2][2] == 2) {
				gamewin = true;
				winner = 2;
				break;
			}
			if (gameLogic[0][0] == 1 && gameLogic[1][1] == 1 && gameLogic[2][2] == 1) {
				gamewin = true;
				winner = 1;
				break;
			}
			if (gameLogic[0][2] == 2 && gameLogic[1][1] == 2 && gameLogic[2][0] == 2) {
				gamewin = true;
				winner = 2;
				break;
			}
			if (gameLogic[0][2] == 1 && gameLogic[1][1] == 1 && gameLogic[2][0] == 1) {
				gamewin = true;
				winner = 1;
				break;
			}
		}
		if (gamewin == true) {
			JOptionPane.showConfirmDialog(null, "The Winner is Player " + winner, "Game End",
					JOptionPane.CLOSED_OPTION);
			System.exit(0);
		}
	}
}
