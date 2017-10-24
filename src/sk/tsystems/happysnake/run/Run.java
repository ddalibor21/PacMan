package sk.tsystems.happysnake.run;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import sk.tsystems.happysnake.gamepanel.GamePanel;

public class Run extends JFrame {

	private static final long serialVersionUID = -8019686176140894756L;

	public Run() {
		/* set fullScrean */
		// setExtendedState(JFrame.MAXIMIZED_BOTH);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				setContentPane(new GamePanel());
			}
		});
		
		

	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Run().setVisible(true);
			}
		});

	}

}
