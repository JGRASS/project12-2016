package groblje;


import java.util.GregorianCalendar;

import java.util.LinkedList;


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
		if(getBrojSlobodnih() == 0) return false;
		return true;
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
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi.length; j++) {
				if(grobovi[i][j]!=null && grobovi[i][j].getDatumSmrti()!=null){
					if(new GregorianCalendar().YEAR - grobovi[i][j].getDatumSmrti().YEAR > 99){
						grobovi[i][j] = null;
					}
				}
			}
		}
		

	}

	@Override
	public void unesiUmrlog(Grob g) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean daLiJeSlobodno(String sifra) {
		// TODO Auto-generated method stub
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi.length; j++) {
				if(grobovi[i][j].getSifra().equals(sifra)) {
					return grobovi[i][j].isRezervisano();
				}
			}
		}
		throw new RuntimeException("Ne postoji grobno mesto sa unetom sifrom.");
	}

	@Override

	public LinkedList<Grob> pretraziMrtve(String imePrezime) {
		LinkedList<Grob> pretrazeni = new LinkedList<Grob>();
		for (int i = 0; i < grobovi.length; i++) {
			for (int j = 0; j < grobovi.length; j++) {
				if(grobovi[i][j].getImePrezime().equals(imePrezime)) {
					pretrazeni.add(grobovi[i][j]);
				}
			}
		}
		return pretrazeni;


	}

}
