package sk.tsystems.happysnake.run;

import javax.swing.JFrame;

import sk.tsystems.happysnake.gamepanel.GamePanel;

public class Run extends JFrame {

	public Run() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		setContentPane(new GamePanel());
		
		/* set fullScrean */
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);

	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Run().setVisible(true);
			}
		});

	}

}
