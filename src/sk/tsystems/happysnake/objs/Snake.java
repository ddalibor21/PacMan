package sk.tsystems.happysnake.objs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import sk.tsystems.happysnake.gamepanel.Direction;

public class Snake {
	private List<Point> points;
	private List<Bubble> bubles;
	private Point head;
	private Direction direction = Direction.DOWN;

	public Snake() {
		super();
		points = new LinkedList<>();
		bubles = new LinkedList<>();
		head = new Point(100, 100);

	}

	public void draw(Graphics2D g) {
		int index = 0;
		for (Point p : points) {
			if(index>=bubles.size())
				break;
			
			Bubble b = bubles.get(index++);
			b.x = p.getX();
			b.y = p.getY();
			g.setColor(b.getColor());
			g.fill(b);
		}

		g.setColor(Color.GREEN);
		g.fillOval(head.x, head.y, 10, 10);
	}

	public void move(Point pt) {
		while (points.size() > bubles.size())
			points.remove(0);

		points.add(pt);
		head = pt;
	}

	public Point getHead() {
		return head;
	}

	public void eat(Bubble b) {
		bubles.add(b);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
