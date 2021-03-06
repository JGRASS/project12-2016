package groblje.gui.models;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import groblje.Grob;

public class GrobTableModel extends AbstractTableModel {

	private final String[] kolone = new String[]{"Šifra", "Ime i prezime", "Datum rođenja", "Datum smrti", "Posveta", "Rezervisano?", "Rezervisao"};
	private LinkedList<Grob> grobovi;
	
	public GrobTableModel(LinkedList<Grob> grobovi) {
		this.grobovi = grobovi;
	}
	
	public void staviGroboveUModel(LinkedList<Grob> grobovi){
		this.grobovi = grobovi;
		fireTableDataChanged();
	}
	
	public Grob vratiGrob(int index){
		return grobovi.get(index);
		
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return grobovi.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Grob g = grobovi.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return g.getSifra();
		case 1: 
			return g.getImePrezime();
		case 2: 
			if(g.getDatumRodjenja() == null) return g.getDatumRodjenja();
			else { 
					int dan = g.getDatumRodjenja().get(GregorianCalendar.DAY_OF_MONTH);
					int mesec = g.getDatumRodjenja().get(GregorianCalendar.MONTH)+1;
					int godina = g.getDatumRodjenja().get(GregorianCalendar.YEAR);
					String datum = ""+dan+":"+mesec+":"+godina;
					return datum;
					}
		case 3: 
			if(g.getDatumSmrti() == null) return g.getDatumSmrti();
			else { 
				int dan = g.getDatumSmrti().get(GregorianCalendar.DAY_OF_MONTH);
				int mesec = g.getDatumSmrti().get(GregorianCalendar.MONTH)+1;
				int godina = g.getDatumSmrti().get(GregorianCalendar.YEAR);
				String datum = ""+dan+":"+mesec+":"+godina;
				return datum;
				}
		case 4: 
			return g.getPosveta();
		case 5: 
			return g.isRezervisano();
		case 6: 
			return g.getRezervisao();

		default:
			return "";
		}
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}
	

}
