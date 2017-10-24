package sk.tsystems.happysnake.run;

import javax.swing.JFrame;

import sk.tsystems.happysnake.gamepanel.GamePanel;

public class Run extends JFrame {

	public Run() {
		
		/* set fullScrean */
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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
