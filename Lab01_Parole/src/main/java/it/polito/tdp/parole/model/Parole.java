package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	LinkedList<String> parola;
		
	public Parole() {
		parola = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		parola.add(p);
	}
	
	public List<String> getElenco() {
		
		LinkedList<String> sordinata = new LinkedList<String>(parola);
		Collections.sort(sordinata,new OrdinamentoParolePerAlfabeto());
		
		return sordinata;
	}
	
	public void reset() {
		parola.clear();
	}
	
	public void cancella(String p) {
		parola.remove(p);
	}

}
