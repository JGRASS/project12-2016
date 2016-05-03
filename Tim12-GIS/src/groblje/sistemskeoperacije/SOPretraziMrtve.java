package groblje.sistemskeoperacije;

import java.util.LinkedList;

import groblje.Grob;

public class SOPretraziMrtve {

	public static LinkedList<Grob> izvrsi(String imePrezime, Grob[][] grobovi) {
		if (imePrezime == null || imePrezime.equals("")) {
			throw new RuntimeException("Greska!");
		}
		LinkedList<Grob> pretrazeni = new LinkedList<Grob>();
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {
				if (grobovi[i][j].getImePrezime() != null) {
					if (grobovi[i][j].getImePrezime().equals(imePrezime)) {
						pretrazeni.add(grobovi[i][j]);
					}
				}
			}
		}
		return pretrazeni;

	}
}
