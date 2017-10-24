package sk.tsystems.happysnake.gamepanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import sk.tsystems.happysnake.objs.Bubble;
import sk.tsystems.happysnake.objs.Snake;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -5068342865808331392L;
	private List<Bubble> listOfBubbles = new ArrayList<>();
	private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private Snake snake = new Snake();

	private int ticks = 0;

	public GamePanel() {
		setDoubleBuffered(isEnabled());

		setBackground(Color.WHITE);

		Bubble.SCR_H = gd.getDisplayMode().getHeight();
		Bubble.SCR_W = gd.getDisplayMode().getWidth();
		addBubbles(15);

		setFocusable(true);

		new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();

				if (ticks++ % 1000 == 0) {
					addBubbles(10);
				}

			}
		}).start();

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				Point pRight = new Point(snake.getHead().x - 5, snake.getHead().y);
				Point pLeft = new Point(snake.getHead().x + 5, snake.getHead().y);
				Point pUp = new Point(snake.getHead().x, snake.getHead().y - 5);
				Point pDown = new Point(snake.getHead().x, snake.getHead().y + 5);

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					snake.move(pRight);
					break;

				case KeyEvent.VK_RIGHT:
					snake.move(pLeft);
					break;

				case KeyEvent.VK_UP:
					snake.move(pUp);
					break;

				case KeyEvent.VK_DOWN:
					snake.move(pDown);
					break;

				case KeyEvent.VK_ESCAPE:
					System.exit(0);

				}

			}

		});

	}

	private void addBubbles(int lim) {
		for (int i = 0; i < lim; i++) {
			listOfBubbles.add(new Bubble());
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());

		Iterator<Bubble> bi = listOfBubbles.iterator();
		while (bi.hasNext()) {
			Bubble bubble2 = bi.next();

			if (bubble2.contains(snake.getHead())) {
				snake.eat(bubble2);
				bi.remove();
				continue;
			}

			g2.setColor(bubble2.getColor());
			g2.fill(bubble2);
		}

		snake.draw(g2);

	}

}
