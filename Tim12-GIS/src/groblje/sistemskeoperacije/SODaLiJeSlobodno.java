package groblje.sistemskeoperacije;

import groblje.Grob;

public class SODaLiJeSlobodno {

	public static boolean izvrsi(String sifra, Grob[][] grobovi) {
		if (sifra == null || sifra.equals("")) {
			throw new RuntimeException("Greska!");
		}
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {

				if (grobovi[i][j].getSifra().equals(sifra)) {
					return grobovi[i][j].isRezervisano();
				}

			}
		}
		throw new RuntimeException("Ne postoji grobno mesto sa unetom sifrom.");
	}
}
