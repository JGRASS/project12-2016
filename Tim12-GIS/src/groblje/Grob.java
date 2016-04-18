package groblje;

import java.util.GregorianCalendar;

public class Grob {

	private String sifra;
	private String imePrezime;
	private GregorianCalendar datumRodjenja;
	private GregorianCalendar datumSmrti;
	private String posveta;
	private String biografija;
	private boolean rezervisano;

	public boolean isRezervisano() {
		return rezervisano;
	}

	public void setRezervisano(boolean rezervisano) {
		this.rezervisano = rezervisano;
	}

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
