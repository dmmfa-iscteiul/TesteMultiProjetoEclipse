package JGrafas;

import pt.iscte.guitoo.StandardColor;

public class EsquemaVermelhoVerdeY implements EsquemaCores {

	@Override
	public StandardColor getFillColor(Tuplos t) {
		
		if(t.getFreq() > 50)
			return StandardColor.GREEN;
		else
			return StandardColor.RED;
	}
}
