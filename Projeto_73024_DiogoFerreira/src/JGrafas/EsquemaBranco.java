package JGrafas;

import pt.iscte.guitoo.StandardColor;

public class EsquemaBranco implements EsquemaCores {

	@Override
	public StandardColor getFillColor(Tuplos t) {
		return StandardColor.WHITE;
	}

}
