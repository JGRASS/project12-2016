package groblje.sistemskeoperacije;

import groblje.Grob;
import groblje.Groblje;

public class SOOslobodiRezervaciju {

	public static void izvrsi(String sifra, Grob[][] grobovi) {
		if (sifra == null || sifra.equals("")) {
			throw new RuntimeException("Greska!");
		}

		boolean izvrseno = false;

		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {
				if (grobovi[i][j].getSifra().equals(sifra)) {
					if (grobovi[i][j].isRezervisano()) {
						grobovi[i][j].setRezervisano(false);
						grobovi[i][j].setRezervisao(null);
						Groblje.setBrojSlobodnih(Groblje.getBrojSlobodnih()+1);
						izvrseno = true;
					} else {
						throw new RuntimeException("Grob " + sifra + " nije rezervisan!");
					}
				}
			}
		}

		if (!(izvrseno)) {
			throw new RuntimeException("Grob sa sifrom " + sifra + " ne postoji!");
		}

	}
}
