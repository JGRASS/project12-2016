package groblje.sistemskeoperacije;

import java.util.GregorianCalendar;

import groblje.Grob;

public class SOUnesiUmrlog {

	public static void izvrsi(String imePrezime, String posveta, String rezervisao, GregorianCalendar datumRodjenja,
			GregorianCalendar datumSmrti, Grob[][] grobovi, int brojSlobodnih) {
		if (SOImaLiSlobodnih.izvrsi(brojSlobodnih) == false)
			throw new RuntimeException("Sva mesta su zauzeta!");
		if(imePrezime == null || imePrezime.isEmpty() == true) throw new RuntimeException("Morate uneti ime i prezime umrlog!");

			

			for (int i = 0; i < grobovi.length; i++) {
				for (int j = 0; j < grobovi[i].length; j++) {
					if (grobovi[i][j].isRezervisano() == false) {
						grobovi[i][j].setRezervisao(rezervisao);
						grobovi[i][j].setDatumRodjenja(datumRodjenja);
						grobovi[i][j].setDatumSmrti(datumSmrti);
						grobovi[i][j].setImePrezime(imePrezime);
						grobovi[i][j].setPosveta(posveta);
						grobovi[i][j].setRezervisano(true);
						return;
						}
					} 
				
			
				
			}
	}
}
