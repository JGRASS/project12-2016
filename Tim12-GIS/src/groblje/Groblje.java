package groblje;

import grobljeInterfejs.GrobljeInterfejs;

public class Groblje implements GrobljeInterfejs {

	private String naziv;
	private String adresa;
	private Grob[][] grobovi = new Grob[20][20];
	private int brojSlobodnih;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getBrojSlobodnih() {
		return brojSlobodnih;
	}

	public void setBrojSlobodnih(int brojSlobodnih) {
		this.brojSlobodnih = brojSlobodnih;
	}

	@Override
	public boolean imaLiSlobodnihMesta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void rezervisi(String sifra) {
		// TODO Auto-generated method stub

	}

	@Override
	public void oslobodiRezervaciju(String sifra) {
		// TODO Auto-generated method stub

	}

	@Override
	public void oslobodiGrob() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unesiUmrlog(Grob g) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean daLiJeSlobodno(String sifra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Grob pretraziMrtve(String imePrezime) {
		// TODO Auto-generated method stub
		return null;
	}

}
