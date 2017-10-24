package sk.tsystems.happysnake.objs;

import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Bubble extends Ellipse2D.Double {
	private static final long serialVersionUID = -370534684811157194L;

	public static int WIDTH;
	public static int HEIGHT;
	private static int SIZE = 15;

	private static final Random RND = new Random();

	/**
	 * Creates new bubble on random screen position
	 * 
	 * @param pt
	 */
	public Bubble() {
		super(nV(WIDTH), nV(HEIGHT), SIZE, SIZE);
	}

	private static double nV(int max) {
		return RND.nextInt(max);
	}

}
