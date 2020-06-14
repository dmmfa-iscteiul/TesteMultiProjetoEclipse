package JGrafas;

import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.StaticText;


public class Dispersao extends Grafico {


	private int DIAMETER=10;
	private int WIDTH=20;
	
	public Dispersao(int x, int y, int escala, ConjuntoDados tuplos, EsquemaCores scheme) {
		super(x, y, escala, tuplos, scheme);
		
		addPosition(escala);
		
		addEixoX(escala);
		addEixoY(escala);
		
	}
	

	@Override
	public void addPosition(int escala) {

		for(int i=0; i < tuplos.getLista().size(); i++) {
			Tuplos t = tuplos.getLista().get(i);
			StandardColor color = scheme.getFillColor(t);
			int a = Integer.parseInt(t.getLabel());
		
			Circulos circle = new Circulos(DIAMETER,color);
			circle.setLocation((a+10)*escala,(250-t.getFreq()*escala));
		
			circle.getFillColor();
		
			children.add(circle);
		}
	}
	
	public void addEixoY(int escala) {
		
		Barras eixo = new Barras(1, -roundTo10(tuplos.sortToGetMaxFreq() * escala), StandardColor.BLACK);
		eixo.setLocation(0, 250);
		children.add(eixo);
		
		for(int i=0; i < tuplos.sortToGetMaxFreq(); i+=10) {
			String valor = Integer.toString(i);
			StaticText ordenada = new StaticText(valor, -20,250-i*3);
			children.add(ordenada);
		}
	}
	
	public void addEixoX(int escala) {
		Barras eixo = new Barras(roundTo10(tuplos.sortToGetMaxLabel())*escala,1, StandardColor.BLACK);
		eixo.setLocation(0, 250);
		children.add(eixo);
		
		for(int i=0; i < tuplos.sortToGetMaxLabel(); i+=10) {
			String valor = Integer.toString(i);
			StaticText abcissa = new StaticText(valor, i*3, 270);
			children.add(abcissa);			
		}	
	}
	

	@Override
	public void move(int x, int y) {
		location = location.sum(x, y);
	}

	public int getWIDTH() {
		return WIDTH;
	}

}
