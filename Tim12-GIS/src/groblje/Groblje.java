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
	private  static Grob[][] grobovi = new Grob[20][20];
	/**
	 * Broj slobodnih mesta kao int
	 */
	private int brojSlobodnih = 20 * 20;

	public Grob[][] getGrobovi() {
		return grobovi;
	}

	public void setGrobovi(Grob[][] grobovi) {
		this.grobovi = grobovi;
	}

	public Groblje() {
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {
				grobovi[i][j] = new Grob();
				String sifra = "" + i + "" + j;
				grobovi[i][j].setSifra(sifra);
			}
		}
	}

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
		if (naziv == null || naziv.isEmpty() == true)
			throw new RuntimeException("Morate uneti naziv groblja.");
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
		if (adresa == null || adresa.isEmpty() == true)
			throw new RuntimeException("Morate uneti adresu groblja.");
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
	public void rezervisi(String sifra, String rezervisao) {
		if (sifra == null || sifra.equals("") || rezervisao == null || rezervisao.isEmpty() == true) {
			throw new RuntimeException("Greska!");
		}

		if (!(imaLiSlobodnihMesta())) {
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

	}

	@Override

	public void unesiUmrlog(String imePrezime, String posveta, String rezervisao, GregorianCalendar datumRodjenja,
			GregorianCalendar datumSmrti) {
		if (imaLiSlobodnihMesta() == false)
			throw new RuntimeException("Sva mesta su zauzeta!");

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

	@Override
	public boolean daLiJeSlobodno(String sifra) {
		// TODO Auto-generated method stub
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

	@Override

	public LinkedList<Grob> pretraziMrtve(String imePrezime) {
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

	public LinkedList<Grob> vratiGrobove() {
		
		LinkedList<Grob> lista = new LinkedList<Grob>();
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi[i].length; j++) {
				lista.add(grobovi[i][j]);
			}

		}
		return lista;
	}
}
