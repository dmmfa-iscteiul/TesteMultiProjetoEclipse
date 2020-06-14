package JGrafas;

import pt.iscte.guitoo.Point;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.StaticText;


public class Linhas extends Grafico {	
	
	private int DIAMETER=10;
	private int WIDTH = 50;
	
	public Linhas(int x, int y, int escala, ConjuntoDados tuplos, EsquemaCores scheme) {
		super(x, y, escala, tuplos, scheme);
		
		addPosition(escala);
		
		addLine(escala);
		
		addEixoY(escala);
		
	}
	
	
	@Override
	public void addPosition(int escala) {

		for(int i=0; i < tuplos.getLista().size(); i++) {
			StandardColor color = scheme.getFillColor(tuplos.getLista().get(i));
			
			Circulos circle = new Circulos(DIAMETER,color);
			circle.setLocation(50+WIDTH*i, -tuplos.getLista().get(i).getFreq() + 200);
			
			children.add(circle);
			children.add(new StaticText(tuplos.getLista().get(i).getLabel(), 50+WIDTH*i, WIDTH+200));
		}
	}
	
	public void addLine(int escala) {
	
		for(int i=1; i < tuplos.getLista().size()+1; i++) {
			
			if(i==tuplos.getLista().size())
				return;
			else {
				Point a = new Point(WIDTH*i, -tuplos.getLista().get(i-1).getFreq()+200);
				Point b = new Point(50+WIDTH*i, -tuplos.getLista().get(i).getFreq()+200);
				
				Line l = new Line(a,b);
				children.add(l);
			}
		}		
	}
	
	public void addEixoY(int escala) {
		
		Barras eixo = new Barras(1, -roundTo10(tuplos.sortToGetMaxFreq())*2*escala, StandardColor.BLACK);
		eixo.setLocation(20, WIDTH+200);
		children.add(eixo);
		
		for(int i=0; i < 10+tuplos.sortToGetMaxFreq(); i+=10) {
			
			String valor = Integer.toString(i);
			StaticText ordenada = new StaticText(valor, 10, 250-i*2);
			children.add(ordenada);
		}
	}

	@Override
	public void move(int x, int y) {
		location = location.sum(x, y);
	}
	
}
