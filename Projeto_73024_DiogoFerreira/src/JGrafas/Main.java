package JGrafas;

import java.util.ArrayList;
import java.util.List;

import pt.iscte.guitoo.Action;
import pt.iscte.guitoo.Flag;
import pt.iscte.guitoo.Option;
import pt.iscte.guitoo.Window;

public class Main {
	
	private Window app;
	private Flag negativa;
	private Flag c;
	private Flag bigger50;
	private Flag smaller20;
	private int WIDTH = 900;
	private int HEIGHT = 400;
	private List<FiltroDados> lista_filtros = new ArrayList<FiltroDados>();
	private EsquemaCores scheme;
	private Option<EsquemaCores> colorOption;
//	private Option<NomeEsquemaCores> colorOption;
	
	public Main() {
		
		app = new Window("JGrafas", WIDTH, HEIGHT, true);
//		app.addLabel(() -> app.getCanvasWidth() + "x" + app.getCanvasHeight());
		
		negativa = app.addFlag("Negativas", false);
		c = app.addFlag("C", false);
		bigger50 = app.addFlag("Y < 50", false);
		smaller20 = app.addFlag("X < 20", false);
		
		app.addAction("Histograma", new GHist());
		app.addAction("Linhas", new GLinhas());
		app.addAction("Dispersao", new GDisp());
		
		colorOption = app.addOption("Cores",new EsquemaBranco(), new EsquemaVermelhoVerdeX(),new EsquemaVermelhoVerdeY(),new EsquemaAmareloBranco());
//		colorOption = app.addOption("Cores", NomeEsquemaCores.ESQUEMA_BRANCO, NomeEsquemaCores.ESQUEMA_VERMELHO_VERDE_X, NomeEsquemaCores.ESQUEMA_VERMELHO_VERDE_Y, NomeEsquemaCores.ESQUEMA_AMARELO_BRANCO);
	}
	
	
	
	//Grafico Histograma
	class GHist extends Action{
		private Histograma h;
		
		public GHist() {
			addParameter("Ficheiro", () -> "", (a) -> !a.isEmpty());
			addParameter("Escala", () -> "1", (a) -> !a.isEmpty());
		}
		
		
		
		@Override
		public void execute(String[] args) {
			
			if(negativa.isSelected())
				lista_filtros.add(new FiltroNegativas());
			
			if(c.isSelected())
				lista_filtros.add(new FiltroC());
			
			if(bigger50.isSelected())
				lista_filtros.add(new FiltroBigger50());
			
			if(smaller20.isSelected())
				lista_filtros.add(new FiltroSmaller20());
			
			scheme = colorOption.getSelected();
			
			ConjuntoDados tuplos = new ConjuntoDados(args[0], lista_filtros);
			int escala = Integer.parseInt(args[1]);
			
			app.clear();
			h = new Histograma(50,100, escala, tuplos, scheme);
			app.addFigure(h);
			lista_filtros.clear();
			
		}
		
	}
	
	//Grafico de Dispersao
	class GDisp extends Action{
		private Dispersao d;
		
		public GDisp() {
			addParameter("Ficheiro", () -> "", (a) -> !a.isEmpty());
			addParameter("Escala", () -> "3", (a) -> ! a.isEmpty());
		}

		@Override
		protected void execute(String[] args) {
			
			if(negativa.isSelected())
				lista_filtros.add(new FiltroNegativas());
			
			if(c.isSelected())
				lista_filtros.add(new FiltroC());
			
			if(bigger50.isSelected())
				lista_filtros.add(new FiltroBigger50());
			
			if(smaller20.isSelected())
				lista_filtros.add(new FiltroSmaller20());
			
			scheme = colorOption.getSelected();
			
			ConjuntoDados tuplos = new ConjuntoDados(args[0],lista_filtros);
			int escala = Integer.parseInt(args[1]);
			
			app.clear();
			d = new Dispersao(50,100, escala, tuplos,scheme);
			app.addFigure(d);
			lista_filtros.clear();
			
		}
		
	}
	
	
	
	
	class GLinhas extends Action{
		private Linhas l;
		
		public GLinhas() {
			addParameter("Ficheiro", () -> "", (a) -> !a.isEmpty());
			addParameter("Escala", () -> "1", (a) -> !a.isEmpty());
		}

		@Override
		protected void execute(String[] args) {
			
			if(negativa.isSelected())
				lista_filtros.add(new FiltroNegativas());
			
			if(c.isSelected())
				lista_filtros.add(new FiltroC());
			
			if(bigger50.isSelected())
				lista_filtros.add(new FiltroBigger50());
			
			if(smaller20.isSelected())
				lista_filtros.add(new FiltroSmaller20());
			
			scheme = colorOption.getSelected();
			
			ConjuntoDados tuplos = new ConjuntoDados(args[0],lista_filtros);
			int escala = Integer.parseInt(args[1]);
			
			app.clear();
			l = new Linhas(0,0, escala, tuplos,scheme);
			app.addFigure(l);
			
			lista_filtros.clear();
		}
		
	}
	
	public List<FiltroDados> getListaFiltros(){
		return lista_filtros;
	}
	
	public EsquemaCores getEsquema() {
		return scheme;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
	public void run() {
		app.open();
	}
	
}
