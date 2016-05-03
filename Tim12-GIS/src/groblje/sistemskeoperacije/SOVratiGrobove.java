package groblje.sistemskeoperacije;

import java.util.LinkedList;

import groblje.Grob;

public class SOVratiGrobove {

public static LinkedList<Grob> izvrsi(Grob[][] grobovi) {
		
		LinkedList<Grob> lista = new LinkedList<Grob>();
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {
				lista.add(grobovi[i][j]);
			}

		}
		return lista;
	}
}
