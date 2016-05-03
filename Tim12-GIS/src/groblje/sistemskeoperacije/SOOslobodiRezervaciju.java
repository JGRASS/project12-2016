package groblje.sistemskeoperacije;

import groblje.Grob;

public class SOOslobodiRezervaciju {

	public static int izvrsi(String sifra, Grob[][] grobovi, int brojSlobodnih) {
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
						brojSlobodnih++;
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

		return brojSlobodnih;
	}
}
