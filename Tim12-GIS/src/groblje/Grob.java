package groblje;

import java.util.GregorianCalendar;

/**
 * Klasa predtsvlja jedan grob
 * 
 * @author Tim12
 *
 */
public class Grob {

	/**
	 * Sirfa groba kao String
	 */
	private String sifra;
	/**
	 * Ime i prezime umrlog kao String
	 */
	private String imePrezime;
	/**
	 * Datum rodjenja umrlog kao GregorianCalendar
	 */
	private GregorianCalendar datumRodjenja;
	/**
	 * Datum smrti umrlog kao GregorianCalendar
	 */
	private GregorianCalendar datumSmrti;
	/**
	 * Posveta umrlom kao String
	 */
	private String posveta;
	/**
	 * Biografija umrlog kao String
	 */
	private String biografija;
	/**
	 * Rezervisano kao boolean
	 */
	private boolean rezervisano;

	/**
	 * Metoda vraca vrednost atributa rezervisano
	 * 
	 * @return rezervisano mesto
	 */
	public boolean isRezervisano() {
		return rezervisano;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut rezervisano
	 * 
	 * @param rezervisano
	 *            Nova vrednost rezervisano
	 */
	public void setRezervisano(boolean rezervisano) {
		this.rezervisano = rezervisano;
	}

	/**
	 * Metoda vraca vrednost atributa sifra
	 * 
	 * @return sifra groba
	 */
	public String getSifra() {
		return sifra;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut sirfa
	 * 
	 * @param sifra
	 *            Nova sifra groba
	 */
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	/**
	 * Metoda vraca vrednost atributa imePrezime
	 * 
	 * @return ime i prezime umrlog
	 */
	public String getImePrezime() {
		return imePrezime;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut imePrezime
	 * 
	 * @param imePrezime
	 *            Novo ime i prezime
	 */
	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	/**
	 * Metoda vraca vrednost atributa datumRodjenja
	 * 
	 * @return datum rodjenja umrlog
	 */
	public GregorianCalendar getDatumRodjenja() {
		return datumRodjenja;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut datumRodjenja
	 * 
	 * @param datumRodjenja
	 *            Datum rodjenja umrlog
	 */
	public void setDatumRodjenja(GregorianCalendar datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	/**
	 * Metoda vraca vrednost atributa datumSmrti
	 * 
	 * @return datum smrti umrlog
	 */
	public GregorianCalendar getDatumSmrti() {
		return datumSmrti;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut datumSmrti
	 * 
	 * @param datumSmrti
	 *            Datum smrti
	 */
	public void setDatumSmrti(GregorianCalendar datumSmrti) {
		this.datumSmrti = datumSmrti;
	}

	/**
	 * Metoda vraca vrednost atributa posveta
	 * 
	 * @return posveta umrlom
	 */
	public String getPosveta() {
		return posveta;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut posveta
	 * 
	 * @param posveta
	 *            Posveta umrlom
	 */
	public void setPosveta(String posveta) {
		this.posveta = posveta;
	}

	/**
	 * Metoda vraca vrednost atributa biografija
	 * 
	 * @return biografija umrlog
	 */
	public String getBiografija() {
		return biografija;
	}

	/**
	 * Metoda postavlja novu vrednost za atribut biografija
	 * 
	 * @param biografija
	 *            Biografija umrlog
	 */
	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

}
