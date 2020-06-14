package JGrafas;

public class FiltroSmaller20 implements FiltroDados {

	@Override
	public boolean isValid(Tuplos t) {
	int valor = Integer.parseInt(t.getLabel());
		
		if(valor > 20)
			return true;
		else
			return false;
	}
}
