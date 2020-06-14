package JGrafas;

import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.EllipseFigure;
import pt.iscte.guitoo.Location;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.StandardColor;

public class Circulos implements EllipseFigure {

	private Point location;
	private Color color;
	private int WIDTH;
	private int HEIGHT;
	
	
	
	public Circulos(int diameter, StandardColor color) {
		
		this.color = color;
		location = Point.ORIGIN;
		this.WIDTH=diameter;
		this.HEIGHT=diameter;
		
	}
	
	
	@Override
	public Location getLocation() {
		return location;
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


	@Override
	public int getHeight() {
		return HEIGHT;
	}


	@Override
	public int getWidth() {
		return WIDTH;
	}
	
	public void setLocation(int x, int y) {
		this.location = new Point(x,y);
	}
	

}
