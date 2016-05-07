package groblje.sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import groblje.Grob;

public class SOSacuvajUFajl {
	
	public static void izvrsi(String putanja, Grob [] [] grobovi) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));
			out.writeObject(grobovi);
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
