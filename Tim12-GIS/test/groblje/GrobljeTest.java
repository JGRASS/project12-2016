package groblje;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GrobljeTest {
	Groblje groblje;

	@Before
	public void setUp() throws Exception {
		groblje = new Groblje();
	}

	@After
	public void tearDown() throws Exception {
		groblje = null;
	}

	@Test
	public void testSetNazivDobarTest() {
		String naziv = "Naziv";
		groblje.setNaziv(naziv);
		assertEquals(naziv, groblje.getNaziv());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNazivNull() {
		groblje.setNaziv(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNazivPrazanString() {
		groblje.setNaziv("");
	}
	@Test
	public void testSetAdresa() {
		String adresa = "Adresa";
		groblje.setAdresa(adresa);
		assertEquals(adresa, groblje.getAdresa());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetAdresaNull() {
		groblje.setAdresa(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetAdresaPrazanString() {
		groblje.setAdresa("");
	}
	
	@Test
	public void testRezervisiDobarTest() {
		String sifra = "00";
		groblje.rezervisi(sifra);
		assertEquals(true, groblje.daLiJeSlobodno(sifra));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testRezervisiNull() {
		groblje.rezervisi(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testRezervisiPrazanString() {
		groblje.rezervisi("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testRezervisiNemaSlobodnih() {
		groblje.setBrojSlobodnih(0);
		groblje.rezervisi("00");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testRezervisiNePostojiSifra() {
		groblje.rezervisi("94081895017185POHK0");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testRezervisiVecRezervisan() {
		groblje.rezervisi("00");
		groblje.rezervisi("00");
	}
	@Test
	public void testOslobodiRezervacijuDobarTest() {
		groblje.rezervisi("00");
		groblje.oslobodiRezervaciju("00");
		assertEquals(false, groblje.daLiJeSlobodno("00"));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testOslobodiRezervacijuNull() {
		groblje.oslobodiRezervaciju(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testOslobodiRezervacijuPrazanString() {
		groblje.oslobodiRezervaciju("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testOslobodiRezervacijuNijeRezervisan() {
		groblje.oslobodiRezervaciju("00");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testOslobodiRezervacijuNePostjiSifra() {
		groblje.oslobodiRezervaciju("fakdhf8459752");
	}
	@Test
	public void testOslobodiGrob() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnesiUmrlogDobarTest() {
		Grob g = new Grob();
		g.setBiografija(null);
		g.setDatumRodjenja(new GregorianCalendar());
		g.setDatumSmrti(new GregorianCalendar());
		g.setImePrezime("Pera Peric");
		g.setPosveta(null);
		g.setRezervisano(true);
		g.setSifra("00");
		groblje.unesiUmrlog("Pera Peric", null, null, new GregorianCalendar(), new GregorianCalendar());
		assertEquals(g, groblje.getGrobovi()[0][0]);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiUmrlog() {
		groblje.setBrojSlobodnih(0);
		groblje.unesiUmrlog("Pera Peric", null, null, null, null);
	}
	@Test
	public void testDaLiJeSlobodno() {
		groblje.rezervisi("00");
		assertEquals(false, groblje.daLiJeSlobodno("00"));
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testDaLiJeSlobodnoNull() {
		groblje.daLiJeSlobodno(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testDaLiJeSlobodnoPrazanString() {
		groblje.daLiJeSlobodno("");

	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testDaLiJeSlobodnoNePostojiSifra() {
		groblje.daLiJeSlobodno("dakfa");
	}
	
	@Test
	public void testPretraziMrtveDobarTest() {
		LinkedList<Grob> pretrazeni = new LinkedList<Grob>();
		Grob g = new Grob();
		Grob g1 = new Grob();
		Grob g2 = new Grob();
		g.setImePrezime("Pera Peric");
		g1.setImePrezime("Jovana Jovic");
		g2.setImePrezime("Pera Peric");
		g.setDatumRodjenja(new GregorianCalendar());
		g1.setDatumRodjenja(new GregorianCalendar());
		g2.setDatumRodjenja(new GregorianCalendar());
		g.setRezervisano(true);
		g1.setRezervisano(true);
		g2.setRezervisano(true);
		g.setSifra("00");
		g1.setSifra("01");
		g2.setSifra("03");
		pretrazeni.add(g);
		pretrazeni.add(g1);
		pretrazeni.add(g2);
		groblje.unesiUmrlog("Pera Peric", null, null, new GregorianCalendar(), null);
		groblje.unesiUmrlog("Jovana Jovic", null, null, new GregorianCalendar(), null);
		groblje.unesiUmrlog("Pera Peric", null, null, new GregorianCalendar(), null);
		
		assertEquals(pretrazeni, groblje.pretraziMrtve("Pera Peric"));
	}
	

	@Test (expected = java.lang.RuntimeException.class)
	public void testPretraziMrtveNull() { 
		groblje.pretraziMrtve(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testPretraziMrtvePrazanString() { 
		groblje.pretraziMrtve("");
	}
}
