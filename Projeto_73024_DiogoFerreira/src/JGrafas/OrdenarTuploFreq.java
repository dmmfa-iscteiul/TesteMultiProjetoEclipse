package JGrafas;

import java.util.Comparator;

public class OrdenarTuploFreq implements Comparator<Tuplos> {

	public int compare(Tuplos a, Tuplos b) {
		return b.getFreq() - a.getFreq();
	}

}
