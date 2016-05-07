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
	 *             ako ne postoji mesto sa unetom sifrom
	 * @throws java.lang.RuntimeException
	 *             nije uneta sifra
	 */
	public boolean daLiJeSlobodno(String sifra);

	/**
	 * Metoda vraca listu grobova na kojima pocivaju ljudi sa unetim imenom
	 * 
	 * @param imePrezime
	 *            Ime i prezime umrlog kog trazimo
	 * @return lista grobova
	 * @throws java.lang.RuntimeException
	 *             nije uneto ime i prezime
	 */
	public LinkedList<Grob> pretraziMrtve(String imePrezime);

	/**
	 * Metoda vrsi rezervaciju ukoliko imamo slobodnih mest ana groblju
	 * 
	 * @param sifra
	 *            Sifra groba
	 * @param rezervisao
	 *            Ime i prezime onog ko je rezervisao grob
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
	public void rezervisi(String sifra, String rezervisao);

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
	 * @throws java.lang.RuntimeException
	 *             Trazeni grob nije ni bio rezervisan
	 * @throws java.lang.RuntimeException
	 *             Grob sa unetom sifrom ne postoji
	 */
	public void oslobodiRezervaciju(String sifra);

	/**
	 * Metoda unosi umrlog u groblje
	 * 
	 * @param imePrezime
	 *            Ime i prezime umrlog
	 * @param posveta
	 *            Posveta umrlom
	 * @param rezervisao
	 *            Ime i prezime onog ko je rezervisao grob
	 * @param datumRodjenja
	 *            Datum rodjenja umrlog
	 * @param datumSmrti
	 *            Datum smrti umrlog
	 * @throws java.lang.RuntimeException
	 *             Sva mesta su zauzeta
	 * @throws java.lang.RuntimeException
	 *             ako je uneto ime i prezime:
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan String</li>
	 *             </ul>
	 */
	public void unesiUmrlog(String imePrezime, String posveta, String rezervisao, GregorianCalendar datumRodjenja,
			GregorianCalendar datumSmrti);

	/**
	 * Metoda ucivata objekte iz fajla
	 * 
	 * @param putanja
	 * @throws java.lang.RuntimeException
	 *             Pri bilo kod izuzetku
	 */
	public void ucitajIzFajla(String putanja);

	/**
	 * Metoda cuva objekte u fajl
	 * 
	 * @param putanja
	 * @throws java.lang.RuntimeException
	 *             Pri bilo kod izuzetku
	 * 
	 */
	public void sacuvajUFajl(String putanja);
}
