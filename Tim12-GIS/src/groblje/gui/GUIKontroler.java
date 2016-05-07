package groblje.gui;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.File;
import java.sql.Savepoint;
import java.util.GregorianCalendar;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import groblje.Grob;
import groblje.Groblje;


public class GUIKontroler {
	private static GrobljeGUI grobljeGui;
	private static Groblje groblje;
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
		try {
		JFileChooser fc = new JFileChooser();
		int povratnaVrednost = fc.showOpenDialog(grobljeGui.getContentPane());

		if (povratnaVrednost == JFileChooser.APPROVE_OPTION) {
			File fajl = fc.getSelectedFile();
			groblje.ucitajIzFajla(fajl.getAbsolutePath());
			grobljeGui.osveziTabelu();
			JOptionPane.showMessageDialog(grobljeGui.getContentPane(), "Uspesno ste ocitali fajl: " +fajl , "Poruka",
					JOptionPane.INFORMATION_MESSAGE);
		}
		else {	JOptionPane.showMessageDialog(grobljeGui.getContentPane(), "Niste uspesno ocitali fajl." , "Poruka",
					JOptionPane.ERROR_MESSAGE);
		}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(grobljeGui.getContentPane(), "Niste uspesno ocitali fajl..." , "Poruka",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int povratnaVrednost = fc.showSaveDialog(grobljeGui.getContentPane());

			if (povratnaVrednost == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				groblje.sacuvajUFajl(file.getAbsolutePath());
				JOptionPane.showMessageDialog(grobljeGui.getContentPane(), "Uspesno ste sacuvali fajl." , "Poruka",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(grobljeGui.getContentPane(), "Niste uspesno sacuvali u fajl." , "Poruka",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(grobljeGui.getContentPane(), "Niste uspesno sacuvali u fajl..." , "Poruka",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void proveriSlobodnaMesta(){
		if(groblje.imaLiSlobodnihMesta())
			JOptionPane.showInternalMessageDialog(grobljeGui.getContentPane(), "Na groblju trenutno ima slobodnih mesta!", "Poruka",JOptionPane.OK_CANCEL_OPTION);
		else 
			JOptionPane.showInternalMessageDialog(grobljeGui.getContentPane(), "Na groblju trenutno nema slobodnih mesta!", "Poruka",JOptionPane.OK_CANCEL_OPTION);
	}
	
	public static boolean proveriOdredjenoMesto(String sifra){
		return groblje.daLiJeSlobodno(sifra);
	}
	
	public static void rezervisiMesto(String sifra, String rezervisao){
		groblje.rezervisi(sifra, rezervisao);
		grobljeGui.osveziTabelu();

	}
	public static void pokreniRezervisiMestoProzor(){
		RezervisiMestoProzor prozor = new RezervisiMestoProzor();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	
	public static void pokreniProveriMestoProzor(){
		ProveriMestoGUI prozor = new ProveriMestoGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	
	public static void oslobodi(String sifra){
		groblje.oslobodiRezervaciju(sifra);
		grobljeGui.osveziTabelu();
	}
	
	public static void pokreniOslobodiMestoProzor(){
		OslobodiMestoProzor prozor = new OslobodiMestoProzor();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}

	
	public static void pokreniUnesiUmrlogProzor() {
		UnesiUmrlogProzor prozor = new UnesiUmrlogProzor();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	
	public static void unesiUmrlog(String imePrezime,String posveta, String rezervisao, GregorianCalendar datumRodjenja,GregorianCalendar datumSmrti) {
		groblje.unesiUmrlog(imePrezime, posveta, rezervisao, datumRodjenja, datumSmrti);
		grobljeGui.osveziTabelu();
	}
	
	public static LinkedList<Grob> vratiSveGrobove(){
		return groblje.vratiGrobove();
	}
	
	public static void pokreniPretraziMrtveProzor() {
		PretraziMrtvePoImenu prozor = new PretraziMrtvePoImenu();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
	
	public static LinkedList<Grob> pretraziMrtvePoImenu (String imePrezime) {
		return groblje.pretraziMrtve(imePrezime);
	}

	public static void osveziTabelu(){
		grobljeGui.osveziTabelu();
	}
} 

