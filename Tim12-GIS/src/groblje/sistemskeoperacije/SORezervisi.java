package groblje.sistemskeoperacije;

import groblje.Grob;
import groblje.Groblje;

public class SORezervisi {

	public static void izvrsi(String sifra, String rezervisao, Grob[][] grobovi) {
		if (sifra == null || sifra.equals("") || rezervisao == null || rezervisao.isEmpty() == true) {
			throw new RuntimeException("Greska!");
		}

		if (!(SOImaLiSlobodnih.izvrsi())) {
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
							Groblje.setBrojSlobodnih(Groblje.getBrojSlobodnih()-1);
							izvrseno = true;
						}
					}
				}
			}
		}

		if (!(izvrseno)) {
			throw new RuntimeException("Grob sa sifrom " + sifra + " ne postoji!");
		}

	}

}
