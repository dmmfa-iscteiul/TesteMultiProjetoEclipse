package JGrafas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.iscte.guitoo.CompositeFigure;
import pt.iscte.guitoo.Figure;
import pt.iscte.guitoo.Location;
import pt.iscte.guitoo.Point;


public abstract class Grafico implements CompositeFigure {

	protected Point location;
	protected List<Figure> children;
	protected ConjuntoDados tuplos;
	protected EsquemaCores scheme;

	
	//Construtor
	public Grafico(int x, int y, int escala, ConjuntoDados tuplos, EsquemaCores scheme) {
		
		this.tuplos = tuplos;
		location = new Point(x,y);
		children = new ArrayList<>();
		this.scheme = scheme;
	}
	
	//Metodos Abstratos para todos os graficos
	public abstract void addPosition(int escala);
	public abstract void move (int x, int y);
	public abstract void addEixoY(int escala);
	
	
	//Outros metodos
	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public List<? extends Figure> getChildFigures() {
		return Collections.unmodifiableList(children);
	}
	
	public int roundTo10(int a) {
		while(a%10 != 0)
			a++;
	
		return a;
	}
}
