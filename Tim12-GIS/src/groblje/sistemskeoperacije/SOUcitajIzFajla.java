package groblje.sistemskeoperacije;

import java.io.ObjectInputStream;

import java.io.BufferedInputStream;
import groblje.Grob;
import java.io.FileInputStream;

public class SOUcitajIzFajla {
	
	public static void izvrsi(String putanja, Grob [] [] grobovi) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));
			Grob [][] grobovi2 = (Grob[][]) (in.readObject());
			for (int i = 0; i < grobovi.length; i++) {
				for (int j = 0; j < grobovi.length; j++) {
					grobovi[i][j] = grobovi2[i][j];
				}
			}

			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
