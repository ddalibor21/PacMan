package sk.tsystems.happysnake.gamepanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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
	private Snake snake;
	private Snake snake2;

	private boolean gameOver = false;
	private Timer tmr;
	
	private int ticks = 0;

	public GamePanel() {
		snake = new Snake(Color.RED);
		snake2 = new Snake(Color.BLUE);
		snake2.move(new Point(800, 600));

		setDoubleBuffered(isEnabled());

		setBackground(Color.WHITE);

		Bubble.SCR_H = gd.getDisplayMode().getHeight();
		Bubble.SCR_W = gd.getDisplayMode().getWidth();
		addBubbles(10);

		setFocusable(true);

		tmr = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final int moveSize = 7;
				snake.step(moveSize, getWidth(), getHeight());
				snake2.step(moveSize, getWidth(), getHeight());

				repaint();

				if (ticks++ % 2000 == 0) {
					addBubbles(10);
				}

			}
		});
		tmr.start();

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					snake.prev();
					// snake.setDirection(snake.getDirection().prev());
					break;

				case KeyEvent.VK_RIGHT:
					snake.next();
					// snake.setDirection(snake.getDirection().next());
					break;

				case KeyEvent.VK_ESCAPE:
					System.exit(0);

				}

				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					snake2.prev();
					// snake2.setDirection(snake2.getDirection().prev());
					break;

				case KeyEvent.VK_D:
					snake2.next();
					// snake2.setDirection(snake2.getDirection().next());
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

			if (bubble2.intersects(snake.getHead2().getBounds2D())) {
				snake.eat(bubble2);
				bi.remove();
				continue;
			}

			if (bubble2.intersects(snake2.getHead2().getBounds2D())) {
				snake2.eat(bubble2);
				bi.remove();
				continue;
			}

			g2.setColor(bubble2.getColor());
			g2.fill(bubble2);
		}

		snake.draw(g2);
		snake2.draw(g2);

		
		g2.setFont(new Font("Verdana", Font.BOLD, 15));
		g2.setColor(snake.getColor());
		String pl1 = String.format("SNAKE 1 : %d", snake.getScore());
		g2.drawString(pl1, 5, 15);

		g2.setColor(snake2.getColor());

		String pl2 = String.format("SNAKE 2 : %d", snake2.getScore());

		g2.drawString(pl2, getWidth() - g2.getFontMetrics().stringWidth(pl2)-5, 15);

		
		gameOver |= snake.isCrashed(snake2); 
		if(gameOver) {
			tmr.stop();
			g2.setFont(new Font("verdana", Font.BOLD, 48));
			g2.setColor(Color.RED);
			centerText(g2, getHeight()/2, "GAME OVER");
			
			if(snake.getScore()>snake2.getScore()) 
				centerText(g2,getHeight()/2 + 50, "WINS "+pl1);
			else
				centerText(g2,getHeight()/2 + 50, "WINS "+pl2);
		}		
	}
	
	private void centerText(Graphics2D g2, int h, String txt) {
		int x = (getWidth() - g2.getFontMetrics().stringWidth(txt))/2;
		g2.drawString(txt, x, h);
	}

}
