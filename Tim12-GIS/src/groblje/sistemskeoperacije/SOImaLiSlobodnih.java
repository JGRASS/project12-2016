package groblje.sistemskeoperacije;

import groblje.Groblje;

public class SOImaLiSlobodnih {

	public static boolean izvrsi() {
		if (Groblje.getBrojSlobodnih() == 0)
			return false;
		return true;
	}
}
