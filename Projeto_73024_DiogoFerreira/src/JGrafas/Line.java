package JGrafas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.iscte.guitoo.Location;
import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.PolylineFigure;

public class Line implements PolylineFigure {	
	
	private Point location;
	private List<Point> points;
	
	public Line(Point aP, Point bP) {
		this.location = Point.ORIGIN;
		
		points = new ArrayList<Point>(2);
		points.add(aP);
		points.add(bP);
	}
	
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public List<? extends Location> getPoints() {
		return Collections.unmodifiableList(points);
	}
	


}
