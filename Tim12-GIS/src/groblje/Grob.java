package groblje;

import java.util.GregorianCalendar;

public class Grob {

	String sifra;
	String imePrezime;
	GregorianCalendar datumRodjenja;
	GregorianCalendar datumSmrti;
	String posveta;
	String biografija;

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public GregorianCalendar getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(GregorianCalendar datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public GregorianCalendar getDatumSmrti() {
		return datumSmrti;
	}

	public void setDatumSmrti(GregorianCalendar datumSmrti) {
		this.datumSmrti = datumSmrti;
	}

	public String getPosveta() {
		return posveta;
	}

	public void setPosveta(String posveta) {
		this.posveta = posveta;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

}
