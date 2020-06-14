package JGrafas;

public class FiltroC implements FiltroDados {

	@Override
	public boolean isValid(Tuplos t) {
		int valor = Integer.parseInt(t.getLabel());
		
		if(valor >=13)
			return true;
		else
			return false;
	}
}
