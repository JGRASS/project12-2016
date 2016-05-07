package groblje;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;

import java.util.LinkedList;

import groblje.sistemskeoperacije.SODaLiJeSlobodno;
import groblje.sistemskeoperacije.SOImaLiSlobodnih;
import groblje.sistemskeoperacije.SOOslobodiRezervaciju;
import groblje.sistemskeoperacije.SOPretraziMrtve;
import groblje.sistemskeoperacije.SORezervisi;
import groblje.sistemskeoperacije.SOSacuvajUFajl;
import groblje.sistemskeoperacije.SOUcitajIzFajla;
import groblje.sistemskeoperacije.SOUnesiUmrlog;
import groblje.sistemskeoperacije.SOVratiGrobove;
import grobljeInterfejs.GrobljeInterfejs;

/**
 * Klasa prestavlja Groblje.
 * 
 * @author Tim12
 *
 */
public class Groblje implements Serializable, GrobljeInterfejs{

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
	public  int getBrojSlobodnih() {
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
		return SOImaLiSlobodnih.izvrsi(getBrojSlobodnih());
	}

	@Override
	public void rezervisi(String sifra, String rezervisao) {
		setBrojSlobodnih(SORezervisi.izvrsi(sifra, rezervisao, grobovi, getBrojSlobodnih()));
	}

	@Override
	public void oslobodiRezervaciju(String sifra) {
		setBrojSlobodnih(SOOslobodiRezervaciju.izvrsi(sifra, grobovi, getBrojSlobodnih()));
	}

	@Override

	public void unesiUmrlog (String imePrezime, String posveta, String rezervisao, GregorianCalendar datumRodjenja,
			GregorianCalendar datumSmrti) {
		SOUnesiUmrlog.izvrsi(imePrezime, posveta, rezervisao, datumRodjenja, datumSmrti, grobovi, getBrojSlobodnih());
	}

	@Override
	public boolean daLiJeSlobodno(String sifra) {
		return SODaLiJeSlobodno.izvrsi(sifra, grobovi);
	}

	@Override

	public LinkedList<Grob> pretraziMrtve(String imePrezime) {
		return SOPretraziMrtve.izvrsi(imePrezime, grobovi);
	}

	public LinkedList<Grob> vratiGrobove() {
		return SOVratiGrobove.izvrsi(grobovi);
	}

	@Override
	public void ucitajIzFajla(String putanja) {
		// TODO Auto-generated method stub
		SOUcitajIzFajla.izvrsi(putanja, grobovi);
		
	}

	@Override
	public void sacuvajUFajl(String putanja) {
		// TODO Auto-generated method stub
		SOSacuvajUFajl.izvrsi(putanja, grobovi);
	}
}
