package it.polito.tdp.parole.model;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Parole {
	private List<String> listaParole;
		
	public Parole() {
		listaParole=new LinkedList<String> ();
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		List<String> lista=new LinkedList<String>(listaParole);
		Collections.sort(lista, String.CASE_INSENSITIVE_ORDER); //sort senza nessun comparatore mette in ordine alfabetico 
		return lista;                                           //String.Case_insensitive_order mette in ordine indipendentemente 
		                                                        // dalla prima lettera è maiuscola o minuscola
	}
	
	public void reset() {
		listaParole.clear();
	}
	
	public void deleteParola(String p) {
		listaParole.remove(p);
	}
	 
}
