package JGrafas;


public class FiltroNegativas implements FiltroDados {
	
	@Override
	public boolean isValid(Tuplos t) {	
		int valor = Integer.parseInt(t.getLabel());
		
		if(valor >=10)
			return true;
		else
			return false;
	
	}
}
