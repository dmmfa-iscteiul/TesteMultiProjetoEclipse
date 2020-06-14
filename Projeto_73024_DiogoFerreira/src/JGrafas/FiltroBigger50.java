package JGrafas;

public class FiltroBigger50 implements FiltroDados {

	@Override
	public boolean isValid(Tuplos t) {
		
		if(t.getFreq() >= 50)
			return true;
		else
			return false;
	}
}
