package groblje.sistemskeoperacije;

import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.io.BufferedInputStream;
import groblje.Grob;
import java.io.FileInputStream;

public class SOUcitajIzFajla {
	
	public static void izvrsi(String putanja, Grob [] [] grobovi) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			LinkedList<Grob> grobovi2 = (LinkedList<Grob>) (in.readObject());
			int p = 0;
			for (int i = 0; i < grobovi.length; i++) {
				int j = 0;
				while(j < grobovi.length && p < grobovi2.size()){
					grobovi[i][j] = grobovi2.get(p);
					p++;
					j++;
				}
			}

			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
