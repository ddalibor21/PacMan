package sk.tsystems.happysnake.objs;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Bubble extends Ellipse2D.Double {
	private static final long serialVersionUID = -370534684811157194L;

	public static int SCR_W;
	public static int SCR_H;
	private static int SIZE = 15;

	private static final Random RND = new Random();

	private static double nV(int max) {
		return RND.nextInt(max);
	}

	private static int nIB() {
		return RND.nextInt(255);
	}

	private Color color;
	private long appeared;
	private boolean consumed;

	/**
	 * Creates new bubble on random screen position
	 * 
	 * @param pt
	 */
	public Bubble() {
		super(nV(SCR_W), nV(SCR_H), SIZE, SIZE);
		appeared = System.currentTimeMillis();
		color = new Color(nIB(), nIB(), nIB());
	}

	public Color getColor() {
		return color;
	}

	public boolean isConsumed() {
		return consumed;
	}
}
