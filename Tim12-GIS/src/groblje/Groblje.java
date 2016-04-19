package groblje;

import java.util.GregorianCalendar;

import java.util.LinkedList;

import grobljeInterfejs.GrobljeInterfejs;

/**
 * Klasa prestavlja Groblje.
 * 
 * @author Tim12
 *
 */
public class Groblje implements GrobljeInterfejs {

	/**
	 * Naziv groblja kao String
	 */
	private String naziv;
	/**
	 * Adresa groblja kao String
	 */
	private String adresa;
	/**
	 * Grobna mesta kao matrica klase Grob
	 */
	private Grob[][] grobovi = new Grob[20][20];
	/**
	 * Broj slobodnih mesta kao int
	 */
	private int brojSlobodnih;

	/**
	 * Metoda vraca vrednost atributa naziv
	 * 
	 * @return naziv groblja
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut naziv
	 * 
	 * @param naziv
	 *            Novi naziv groblja
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * Metoda vraca vrednost atributa adresa
	 * 
	 * @return adresa groblja
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut adresa
	 * 
	 * @param adresa
	 *            Nova adresa groblja
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	/**
	 * Metoda vraca vrednost atributa brojSlobodnih
	 * 
	 * @return broj slobodnih mesta
	 */
	public int getBrojSlobodnih() {
		return brojSlobodnih;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut brojSlobodnih
	 * 
	 * @param brojSlobodnih
	 *            Nova vrednost broja slobodnih mesta
	 */
	public void setBrojSlobodnih(int brojSlobodnih) {
		this.brojSlobodnih = brojSlobodnih;
	}

	@Override
	public boolean imaLiSlobodnihMesta() {
		if (getBrojSlobodnih() == 0)
			return false;
		return true;
	}

	@Override
	public void rezervisi(String sifra) {
		if (sifra == null || sifra.equals("")) {
			throw new RuntimeException("Greska!");
		}

		if (!(imaLiSlobodnihMesta())) {
			throw new RuntimeException("Nema slobodnih grobova.");
		}

		boolean izvrseno = false;

		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {
				if (grobovi[i][j].getSifra().equals(sifra)) {
					if (grobovi[i][j].isRezervisano()) {
						throw new RuntimeException("Grob " + sifra + " je vec rezervisan!");
					} else {
						grobovi[i][j].setRezervisano(true);
						brojSlobodnih--;
						izvrseno = true;
					}
				}
			}
		}

		if (!(izvrseno)) {
			throw new RuntimeException("Grob sa sifrom " + sifra + " ne postoji!");
		}

	}

	@Override
	public void oslobodiRezervaciju(String sifra) {
		if (sifra == null || sifra.equals("")) {
			throw new RuntimeException("Greska!");
		}

		boolean izvrseno = false;

		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {
				if (grobovi[i][j].getSifra().equals(sifra)) {
					if (grobovi[i][j].isRezervisano()) {
						grobovi[i][j].setRezervisano(false);
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

	}

	@Override
	public void oslobodiGrob() {
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi.length; j++) {
				if (grobovi[i][j] != null && grobovi[i][j].getDatumSmrti() != null) {
					if (new GregorianCalendar().YEAR - grobovi[i][j].getDatumSmrti().YEAR > 99) {
						grobovi[i][j] = null;
					}
				}
			}
		}

	}

	@Override
	public void unesiUmrlog(Grob g) {
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi.length; j++) {
				if (grobovi[i][j] == null) {
					grobovi[i][j] = g;
					return;
				}
			}
		}
		throw new RuntimeException("Sva mesta su zauzeta!");

	}

	@Override
	public boolean daLiJeSlobodno(String sifra) {
		// TODO Auto-generated method stub
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi.length; j++) {
				if (grobovi[i][j].getSifra().equals(sifra)) {
					return grobovi[i][j].isRezervisano();
				}
			}
		}
		throw new RuntimeException("Ne postoji grobno mesto sa unetom sifrom.");
	}

	@Override

	public LinkedList<Grob> pretraziMrtve(String imePrezime) {
		LinkedList<Grob> pretrazeni = new LinkedList<Grob>();
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi.length; j++) {
				if (grobovi[i][j].getImePrezime().equals(imePrezime)) {
					pretrazeni.add(grobovi[i][j]);
				}
			}
		}
		return pretrazeni;

	}

}
