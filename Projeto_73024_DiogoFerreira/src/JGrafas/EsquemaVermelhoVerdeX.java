package JGrafas;

import pt.iscte.guitoo.StandardColor;

public class EsquemaVermelhoVerdeX implements EsquemaCores {	
	
	@Override
	public StandardColor getFillColor(Tuplos t) {
		
		int valor = Integer.parseInt(t.getLabel());
		
		if(valor < 50)
			return StandardColor.RED;
		else
			return StandardColor.GREEN;
		
	}

}
