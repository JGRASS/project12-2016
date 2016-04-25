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
		if(sifra == null || sifra.isEmpty() == true) throw new RuntimeException("Nije prosledjena odgovarajuca sifra.");
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
		if((isRezervisano() == true && imePrezime == null) || (isRezervisano() == true && imePrezime.isEmpty() == true)) 
			throw new RuntimeException("Morate uneti neko ime i prezime.");
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
		if(isRezervisano() == true && datumRodjenja == null) throw new RuntimeException("Morate uneti datum rodjenja.");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((biografija == null) ? 0 : biografija.hashCode());
		result = prime * result + ((datumRodjenja == null) ? 0 : datumRodjenja.hashCode());
		result = prime * result + ((datumSmrti == null) ? 0 : datumSmrti.hashCode());
		result = prime * result + ((imePrezime == null) ? 0 : imePrezime.hashCode());
		result = prime * result + ((posveta == null) ? 0 : posveta.hashCode());
		result = prime * result + (rezervisano ? 1231 : 1237);
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grob other = (Grob) obj;
		if (biografija == null) {
			if (other.biografija != null)
				return false;
		} else if (!biografija.equals(other.biografija))
			return false;
		if (datumRodjenja == null) {
			if (other.datumRodjenja != null)
				return false;
		} else if (!datumRodjenja.equals(other.datumRodjenja))
			return false;
		if (datumSmrti == null) {
			if (other.datumSmrti != null)
				return false;
		} else if (!datumSmrti.equals(other.datumSmrti))
			return false;
		if (imePrezime == null) {
			if (other.imePrezime != null)
				return false;
		} else if (!imePrezime.equals(other.imePrezime))
			return false;
		if (posveta == null) {
			if (other.posveta != null)
				return false;
		} else if (!posveta.equals(other.posveta))
			return false;
		if (rezervisano != other.rezervisano)
			return false;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}
	
	
}
