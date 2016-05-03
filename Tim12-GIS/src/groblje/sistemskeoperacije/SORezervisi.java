package groblje.sistemskeoperacije;

import groblje.Grob;

public class SORezervisi {

	public static int izvrsi(String sifra, String rezervisao, Grob[][] grobovi, int brojSlobodnih) {
		if (sifra == null || sifra.equals("") || rezervisao == null || rezervisao.isEmpty() == true) {
			throw new RuntimeException("Greska!");
		}

		if (!(SOImaLiSlobodnih.izvrsi(brojSlobodnih))) {
			throw new RuntimeException("Nema slobodnih grobova.");
		}

		boolean izvrseno = false;

		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {
				if (grobovi[i][j].getSifra() != null) {
					if (grobovi[i][j].getSifra().equals(sifra)) {
						if (grobovi[i][j].isRezervisano()) {
							throw new RuntimeException("Grob " + sifra + " je vec rezervisan!");
						} else {
							grobovi[i][j].setRezervisano(true);
							grobovi[i][j].setRezervisao(rezervisao);
							brojSlobodnih--;
							izvrseno = true;
						}
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
