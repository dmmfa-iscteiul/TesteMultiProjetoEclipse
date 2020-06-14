package JGrafas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.Location;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.PolylineFigure;
import pt.iscte.guitoo.StandardColor;

public class Barras implements PolylineFigure {

	private Point location;
	private Color color;
	private List<Point> points;
	
	public Barras(int width, int height, StandardColor color) {
		location = new Point(0,120);
		this.color = color;
		
		points = new ArrayList<>(4);
		points.add(Point.ORIGIN);
		points.add(new Point(width, 0));
		points.add(new Point(width,height));
		points.add((new Point(0,height)));
		
	}
	
	
	@Override
	public Location getLocation() {
		return location;
	}

	
	@Override
	public List<? extends Location> getPoints() {
		return Collections.unmodifiableList(points);
	}
	
	
	public Color getColorBarra() {
		return color;
	}
	

	@Override
	public Color getFillColor() {
		return color;
	}
	
	
	public void move(int x, int y) {
		location = location.sum(x, y);
	}
	
	public void setLocation(int x, int y) {
		this.location = new Point(x,y);
	}
	
}
