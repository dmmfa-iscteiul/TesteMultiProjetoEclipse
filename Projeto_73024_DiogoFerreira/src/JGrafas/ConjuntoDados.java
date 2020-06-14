package JGrafas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConjuntoDados {

	List<Tuplos> tuplos = new ArrayList<Tuplos>();
	private Scanner s;
	
	public ConjuntoDados(String filename, List<FiltroDados> lista_filtros) {
		
		try {
			s = new Scanner(new File(filename));		//Deste modo para corrigir o Problema Resource Leak 
			
			while(s.hasNextLine()) {
				String line = s.nextLine();
				String info[] = line.split(",");
				
				String label = info[0];
				int freq = Integer.parseInt(info[1]);							
				Tuplos t = new Tuplos(label, freq);		
				
				boolean isValid = true;
				for(FiltroDados f : lista_filtros) {
					if(!f.isValid(t)) {
						isValid = false;
					}
				}
			
				if(isValid)
					tuplos.add(t);
			}
			s.close();
			
		}
	
		catch(FileNotFoundException e) {
			System.out.println("Erro na abertura do ficheiro");
		}
	}
	
	public List<Tuplos> getLista(){
		return tuplos;
	}
	
	public Tuplos getTuplo(int i) {
		return tuplos.get(i);
	}
	
	public int sortToGetMaxFreq() {
		tuplos.sort(new OrdenarTuploFreq());
		
		return tuplos.get(0).getFreq();
	}
	
	public int sortToGetMinFreq() {
		int cont = 0;
		for(int i = 0; i < tuplos.size(); i++)
			cont++;
		
		tuplos.sort(new OrdenarTuploFreq());
		return tuplos.get(cont-1).getFreq();
	}
	
	public int sortToGetMaxLabel() {
		tuplos.sort(new OrdenarTuploLabel());
		int l = Integer.parseInt(tuplos.get(0).getLabel());
		return l;
	}
	
	
}
