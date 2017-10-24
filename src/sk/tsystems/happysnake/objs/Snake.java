package sk.tsystems.happysnake.objs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.List;

import sk.tsystems.happysnake.gamepanel.Direction;

public class Snake {
	private List<Point> points;
	private List<Bubble> bubles;
	private Ellipse2D.Double head;
	private Direction direction = Direction.DOWN;

	public Snake() {
		super();
		points = new LinkedList<>();
		bubles = new LinkedList<>();
		head = new Ellipse2D.Double(100, 100, Bubble.SIZE+10, Bubble.SIZE+10);
	}

	public void draw(Graphics2D g) {
		int index = points.size()-1;
		Point last = getHead();
		Point p = last;

		outer:
		for (Bubble b: bubles) {
			while (last.distance(p)<Bubble.SIZE*0.90) {
				if(index<0)
					break outer;
				
				p= points.get(index--);
			}
			last = p;
			
			b.x = p.getX();
			b.y = p.getY();
			g.setColor(b.getColor());
			g.fill(b);
		}

		g.setColor(Color.GREEN);
		g.fill(head);
	}

	public void move(Point pt) {
		while (points.size() > bubles.size()*10)
			points.remove(0);

		points.add(pt);
		head.x = pt.x;
		head.y = pt.y;
	}

	public Point getHead() {
		return new Point((int)Math.floor(head.x),(int) Math.floor(head.y));
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
	
	public Ellipse2D getHead2() {
		return head;
	}


}
