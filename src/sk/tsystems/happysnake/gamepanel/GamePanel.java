package sk.tsystems.happysnake.gamepanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	public GamePanel() {
		setDoubleBuffered(isEnabled());

		setBackground(Color.WHITE);

	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

	}

}
