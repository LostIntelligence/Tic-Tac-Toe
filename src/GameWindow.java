import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameWindow implements ActionListener {
	JFrame board;
	Logic lg = new Logic();
	JPanel pan;
	Image cross;
	Image circle;
	JButton btns[][];

	public void show() {
		board = new JFrame();
		pan = new JPanel();
		btns = new JButton[3][3];
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				btns[row][column] = new JButton();
				btns[row][column].setName(Integer.toString(row * 10 + column));
				btns[row][column].addActionListener(this);
				btns[row][column].setContentAreaFilled(false);
				pan.add(btns[row][column]);
			}
		}

		board.setSize(900, 900);
		pan.setBackground(Color.DARK_GRAY);
		pan.setLayout(new GridLayout(3, 3, 0, 0));
		board.getContentPane().add(pan);
		board.setResizable(false);
		board.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String btn = ((Component) e.getSource()).getName();
		lg.doMove(btn);
		setImages();
		lg.checkWin();
	}

	public void setImages() {
		int[][] chessArray = lg.getArray();
		ScaleImage();
		for (int row = 0; row < 3; row++) {
			for (int colum = 0; colum < 3; colum++) {
				int currentvalue = chessArray[row][colum];
				switch (currentvalue) {
					case 1:
						btns[row][colum].setIcon(new ImageIcon(cross));
						break;
					case 2:
						btns[row][colum].setIcon(new ImageIcon(circle));
						break;
					default:
						btns[row][colum].setIcon(null);
				}
			}
		}
	}

	public void ScaleImage() {

		try {
			circle = ImageIO.read(new File("circle.png")).getScaledInstance(300, 300, Image.SCALE_DEFAULT);
			cross = ImageIO.read(new File("cross.png")).getScaledInstance(300, 300, Image.SCALE_DEFAULT);

		} catch (Exception e) {
			System.err.println("Image size Failed");
			System.exit(404);
		}
	}
}
