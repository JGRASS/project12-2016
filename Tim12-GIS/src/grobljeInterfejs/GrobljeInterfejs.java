package grobljeInterfejs;

import groblje.Grob;

public interface GrobljeInterfejs {

	public boolean imaLiSlobodnihMesta ();
	
	public boolean daLiJeSlobodno(String sifra);
	
	public Grob pretraziMrtve(String imePrezime);

	public void rezervisi(String sifra);
	
	public void oslobodiRezervaciju (String sifra);

	public void oslobodiGrob();

	public void unesiUmrlog(Grob g);
}
