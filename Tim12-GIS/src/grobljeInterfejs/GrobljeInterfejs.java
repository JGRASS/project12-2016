package grobljeInterfejs;

import groblje.Grob;

public interface GrobljeInterfejs {

	public boolean imaLiSlobodnihMesta ();
	
	public boolean daLiJeSlobodno(Grob g);
	
	public Grob pretraziMrtve();

	public void rezervisi(String sifra);
	
	public void oslobodiRezervaciju (String sifra);

	public void oslobodiGrob();

	public void unesiUmrlog(Grob g);
}
