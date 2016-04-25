package groblje.gui;

import java.awt.EventQueue;
import java.io.File;
import java.sql.Savepoint;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import groblje.Groblje;
import grobljeInterfejs.GrobljeInterfejs;

public class GUIKontroler {
	private static GrobljeGUI grobljeGui;
	private static GrobljeInterfejs groblje;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					groblje = new Groblje();
					grobljeGui = new GrobljeGUI();
					grobljeGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(grobljeGui.getContentPane(),
				"Da li zelite da zatvorite aplikaciju?", "Izlazak", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void ucitajIzfajla() {
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showOpenDialog(grobljeGui.getContentPane());

		if (povratnaVrednost == JFileChooser.APPROVE_OPTION) {
			File fajl = fc.getSelectedFile();


			JOptionPane.showMessageDialog(grobljeGui.getContentPane(), "Uspesno ste ocitali fajl!", "Poruka",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
