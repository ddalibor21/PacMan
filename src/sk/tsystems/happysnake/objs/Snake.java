package sk.tsystems.happysnake.objs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Snake {
	private List<Point> points;
	private Point head;
	private int size;

	public Snake() {
		super();
		points = new LinkedList<>();
		size = 2;
		head = new Point(100, 100);
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		for (Point p : points) {
			g.fillOval(p.x, p.y, 10, 10);
		}

		g.setColor(Color.GREEN);
		g.fillOval(head.x, head.y, 10, 10);
	}

	public void move(Point pt) {
		if (points.size() > size)
			points.remove(0);

		points.add(pt);
		head = pt;
	}

	public Point getHead() {
		return head;
	}

	public void eat(Bubble b) {
		size++;
	}

}
