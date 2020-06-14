package JGrafas;

import java.util.Comparator;

public class OrdenarTuploLabel implements Comparator<Tuplos> {

	@Override
	public int compare(Tuplos a, Tuplos b) {
		int aL = Integer.parseInt(a.getLabel());
		int bL = Integer.parseInt(b.getLabel());
		
		return bL - aL;
	}





}
