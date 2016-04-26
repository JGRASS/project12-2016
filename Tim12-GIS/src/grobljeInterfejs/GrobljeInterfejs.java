package grobljeInterfejs;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import groblje.Grob;

public interface GrobljeInterfejs {

	/**
	 * Metoda proverava da li na groblju ima slobodnih mesta i vraca boolean
	 * vrednost
	 * 
	 * @return da li ima slobodnih mesta
	 */
	public boolean imaLiSlobodnihMesta();

	/**
	 * Metoda proverava da li je odredjeno mesto slobodno
	 * 
	 * @param sifra
	 *            Sifra mesta za koje vrsimo proveru
	 * @return da li je mesto slobodno
	 * @throws java.lang.RuntimeException
	 *             ako ne psotoji mesto sa unetom sifrom
	 */
	public boolean daLiJeSlobodno(String sifra);

	/**
	 * Metoda vraca listu grobova na kojima pocivaju ljudi sa unetim imenom
	 * 
	 * @param imePrezime
	 *            Ime i prezime umrlog kog trazimo
	 * @return lista grobova
	 * 
	 */
	public LinkedList<Grob> pretraziMrtve(String imePrezime);

	/**
	 * Metoda vrsi rezervaciju ukoliko imamo slobodnih mest ana groblju
	 * 
	 * @param sifra
	 *            Sifra groba
	 * @throws java.lang.RuntimeException
	 *             ako je uneta sifra:
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan String</li>
	 *             </ul>
	 * @throws java.lang.RuntimeException
	 *             ako nema slobodnih mesta na groblju
	 * @throws java.lang.RuntimeException
	 *             ako je grob sa unetom sifrom vec rezervisan
	 * 
	 */
	public void rezervisi(String sifra);

	/**
	 * Metoda oslobadja rezervaciju rezervisanog groba
	 * 
	 * @param sifra
	 *            Sifra groba
	 * @throws java.lang.RuntimeException
	 *             ako je uneta sifra:
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan String</li>
	 *             <li>ne postoji</li>
	 *             <li>vec je bio slobodan</li>
	 *             </ul>
	 * 
	 */
	public void oslobodiRezervaciju(String sifra);


	/**
	 * Metoda unosi novog umrlog u groblje.
	 * 
	 * @param g
	 *            Novi grob
	 * @throws java.lang.RuntimeException
	 *             ako su sva mesta zauzeta
	 */
	public void unesiUmrlog(String imePrezime, String posveta, GregorianCalendar datumRodjenja, GregorianCalendar datumSmrti);
	
}
