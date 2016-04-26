package groblje.gui.models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import groblje.Grob;

public class GrobTableModel extends AbstractTableModel {

	private final String[] kolone = new String[]{"Šifra", "Ime i prezime", "Datum rođenja", "Datum smrti", "Posveta", "Rezervisano?", "Rezervisao"};
	private Grob[][] grobovi;
	
	public GrobTableModel(Grob[][] grobovi) {
		this.grobovi =grobovi;
	}
	
	public void staviGroboveUModel(Grob[][] grobovi){
		this.grobovi = grobovi;
		fireTableDataChanged();
	}
	
	public Grob vratiGrob(int index1, int index2){
		return grobovi[index1][index2];
		
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {//ovo pogledaj!!
		return grobovi.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Grob g = grobovi[rowIndex][columnIndex];
		switch (columnIndex) {
		case 0:
			return g.getSifra();
		case 1: 
			return g.getImePrezime();
		case 2: 
			return g.getDatumRodjenja();
		case 3: 
			return g.getDatumSmrti();
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
