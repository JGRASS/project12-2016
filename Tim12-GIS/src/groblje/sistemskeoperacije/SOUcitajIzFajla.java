package groblje.sistemskeoperacije;

import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedInputStream;
import groblje.Grob;
import java.io.FileInputStream;

public class SOUcitajIzFajla {
	
	public static void izvrsi(String putanja, LinkedList<Grob> grobovi) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			LinkedList<Grob> grobovi2 = (LinkedList<Grob>) (in.readObject());
			grobovi.clear();
			grobovi.addAll(grobovi2);
			

			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
