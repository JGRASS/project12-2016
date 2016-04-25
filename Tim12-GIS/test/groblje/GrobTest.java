package groblje;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GrobTest {
	private Grob grob;
	
	@Before
	public void setUp() throws Exception {
		grob = new Grob();
	}

	@After
	public void tearDown() throws Exception {
		grob = null;
	}

	@Test
	public void testSetSifraDobarTest() {
		String sifra = "2415";
		grob.setSifra(sifra);
		assertEquals(sifra, grob.getSifra());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSifraNull() {
		grob.setSifra(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSifraPrazanString() {
		grob.setSifra("");
	}
	

	@Test
	public void testSetImePrezimeDobarTest() {
		String imePrezime = "Pera Peric";
		grob.setImePrezime(imePrezime);
		assertEquals(imePrezime, grob.getImePrezime());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetImePrezimeNull() {
		grob.setRezervisano(true);
		grob.setImePrezime(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetImePrezimePrazanString() {
		grob.setRezervisano(true);
		grob.setImePrezime("");
	}
	
	@Test
	public void testSetDatumRodjenja() {
		GregorianCalendar datumRodjenja = new GregorianCalendar();
		grob.setDatumRodjenja(datumRodjenja);
		assertEquals(datumRodjenja, grob.getDatumRodjenja());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetDatumRodjenjaNull() {
		grob.setRezervisano(true);
		grob.setDatumRodjenja(null);
	}
	
}
