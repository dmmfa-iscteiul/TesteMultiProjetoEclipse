package JGrafas;

import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.StaticText;

public class Histograma extends Grafico {

	private int WIDTH = 30;
	
	public Histograma(int x, int y, int escala, ConjuntoDados tuplos,EsquemaCores scheme) {
		super(x, y, escala, tuplos,scheme);
		
		addPosition(escala);
		
		addEixoY(escala);
	}

	@Override
	public void addPosition(int escala) {
		
		for(int i=0; i < tuplos.getLista().size(); i++) {
		
			Tuplos t = tuplos.getLista().get(i);
			StandardColor color = scheme.getFillColor(t);
			
			Barras barra = new Barras(WIDTH*escala,-t.getFreq()*escala, color);
			barra.move(i*WIDTH*escala + 10, 0);
			barra.getFillColor();
			
			super.children.add(barra);
			super.children.add(new StaticText(t.getLabel(), escala*(i*WIDTH + WIDTH /2 )+10, WIDTH +110));
		}

	}
	
	public void addEixoY (int escala) {
		
		Barras eixo = new Barras(1, -roundTo10(tuplos.sortToGetMaxFreq())*escala, StandardColor.BLACK);
		children.add(eixo);
		
		int origem = 0;
		int ordenadas = roundTo10(tuplos.sortToGetMaxFreq());
	
		while(origem <= roundTo10(tuplos.sortToGetMaxFreq())) {
			String valor = Integer.toString(origem);
			children.add(new StaticText(valor, -20, ordenadas));
			
			origem += 10;
			ordenadas -= 10;

		}	
	}

	@Override
	public void move(int x, int y) {
		super.location = super.location.sum(x,y);
	}
	
}
