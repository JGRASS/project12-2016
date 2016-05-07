package groblje.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.JobAttributes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

public class UnesiUmrlogProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblImeIPrezime;
	private JTextField textImePrezime;
	private JLabel lblPosveta;
	private JTextField textPosveta;
	private JLabel lblDatumRoenja;
	private JButton btnUnesiUmrlog;
	private JLabel lblRezervisao;
	private JTextField textRezervisao;
	private JSpinner spinnerDanR;
	private JSpinner spinnerMesecR;
	private JSpinner spinnerGodinaR;
	private JLabel lblDatumSmrti;
	private JSpinner spinnerDanS;
	private JSpinner spinnerMesecS;
	private JSpinner spinnerGodS;

	/**
	 * Create the frame.
	 */
	public UnesiUmrlogProzor() {
		setTitle("Unesi umrlog");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblImeIPrezime());
		contentPane.add(getTextImePrezime());
		contentPane.add(getLblPosveta());
		contentPane.add(getTextPosveta());
		contentPane.add(getLblRezervisao());
		contentPane.add(getTextRezervisao());
		contentPane.add(getLblDatumRoenja());
		contentPane.add(getSpinnerDanR());
		contentPane.add(getBtnUnesiUmrlog());
		contentPane.add(getSpinnerMesecR());
		contentPane.add(getSpinnerGodinaR());
		contentPane.add(getLblDatumSmrti());
		contentPane.add(getSpinnerDanS());
		contentPane.add(getSpinnerMesecS());
		contentPane.add(getSpinnerGodS());
		
		JLabel lblDan = new JLabel("Dan:");
		lblDan.setBounds(166, 169, 48, 16);
		contentPane.add(lblDan);
		
		JLabel lblMesec = new JLabel("Mesec:");
		lblMesec.setBounds(226, 169, 56, 16);
		contentPane.add(lblMesec);
		
		JLabel lblGodina = new JLabel("Godina:");
		lblGodina.setBounds(284, 169, 56, 16);
		contentPane.add(lblGodina);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOdustani.setBounds(234, 309, 151, 37);
		contentPane.add(btnOdustani);
	}
	private JLabel getLblImeIPrezime() {
		if (lblImeIPrezime == null) {
			lblImeIPrezime = new JLabel("Ime i prezime");
			lblImeIPrezime.setBounds(5, 6, 151, 42);
		}
		return lblImeIPrezime;
	}
	private JTextField getTextImePrezime() {
		if (textImePrezime == null) {
			textImePrezime = new JTextField();
			textImePrezime.setBounds(166, 6, 182, 42);
			textImePrezime.setColumns(10);
		}
		return textImePrezime;
	}
	private JLabel getLblPosveta() {
		if (lblPosveta == null) {
			lblPosveta = new JLabel("Posveta");
			lblPosveta.setBounds(5, 58, 151, 42);
		}
		return lblPosveta;
	}
	private JTextField getTextPosveta() {
		if (textPosveta == null) {
			textPosveta = new JTextField();
			textPosveta.setBounds(166, 58, 182, 42);
			textPosveta.setColumns(10);
		}
		return textPosveta;
	}
	private JLabel getLblDatumRoenja() {
		if (lblDatumRoenja == null) {
			lblDatumRoenja = new JLabel("Datum ro\u0111enja");
			lblDatumRoenja.setBounds(5, 198, 151, 42);
		}
		return lblDatumRoenja;
	}
	private JButton getBtnUnesiUmrlog() {
		if (btnUnesiUmrlog == null) {
			btnUnesiUmrlog = new JButton("Unesi umrlog");
			btnUnesiUmrlog.setBounds(5, 309, 151, 37);
			btnUnesiUmrlog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					String imePrezime = textImePrezime.getText();
					String posveta = textPosveta.getText();
					String rezervisao = textRezervisao.getText();
			
					int danR = (int) spinnerDanR.getValue();
					int mesecR = (int) spinnerMesecR.getValue();
					int godinaR = (int) spinnerGodinaR.getValue();
					GregorianCalendar datumRodjenja = new GregorianCalendar(godinaR, mesecR-1, danR);
					
					int danS = (int) spinnerDanS.getValue();
					int mesecS = (int) spinnerMesecS.getValue();
					int godinaS = (int) spinnerGodS.getValue();
					GregorianCalendar datumSmrti= new GregorianCalendar(godinaS, mesecS-1, danS);
					try {
					GUIKontroler.unesiUmrlog(imePrezime, posveta, rezervisao, datumRodjenja, datumSmrti);}
					catch(RuntimeException r) {
						JOptionPane.showMessageDialog(contentPane, r.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
					}
			
				}
			});
		}
		return btnUnesiUmrlog;
	}
	private JLabel getLblRezervisao() {
		if (lblRezervisao == null) {
			lblRezervisao = new JLabel("Rezervisao");
			lblRezervisao.setBounds(5, 110, 151, 42);
		}
		return lblRezervisao;
	}
	private JTextField getTextRezervisao() {
		if (textRezervisao == null) {
			textRezervisao = new JTextField();
			textRezervisao.setBounds(166, 110, 182, 42);
			textRezervisao.setColumns(10);
		}
		return textRezervisao;
	}
	private JSpinner getSpinnerDanR() {
		if (spinnerDanR == null) {
			spinnerDanR = new JSpinner();
			spinnerDanR.setModel(new SpinnerNumberModel(15, 1, 31, 1));
			spinnerDanR.setBounds(166, 198, 48, 42);
		}
		return spinnerDanR;
	}
	private JSpinner getSpinnerMesecR() {
		if (spinnerMesecR == null) {
			spinnerMesecR = new JSpinner();
			spinnerMesecR.setModel(new SpinnerNumberModel(6, 1, 12, 1));
			spinnerMesecR.setBounds(226, 198, 48, 42);
		}
		return spinnerMesecR;
	}
	private JSpinner getSpinnerGodinaR() {
		if (spinnerGodinaR == null) {
			spinnerGodinaR = new JSpinner();
			spinnerGodinaR.setModel(new SpinnerNumberModel(new Integer(1950), null, null, new Integer(1)));
			spinnerGodinaR.setBounds(284, 198, 66, 42);
		}
		return spinnerGodinaR;
	}
	private JLabel getLblDatumSmrti() {
		if (lblDatumSmrti == null) {
			lblDatumSmrti = new JLabel("Datum smrti");
			lblDatumSmrti.setBounds(5, 253, 151, 42);
		}
		return lblDatumSmrti;
	}
	private JSpinner getSpinnerDanS() {
		if (spinnerDanS == null) {
			spinnerDanS = new JSpinner();
			spinnerDanS.setModel(new SpinnerNumberModel(15, 1, 31, 1));
			spinnerDanS.setBounds(166, 253, 48, 42);
		}
		return spinnerDanS;
	}
	private JSpinner getSpinnerMesecS() {
		if (spinnerMesecS == null) {
			spinnerMesecS = new JSpinner();
			spinnerMesecS.setModel(new SpinnerNumberModel(6, 1, 12, 1));
			spinnerMesecS.setBounds(224, 253, 48, 42);
		}
		return spinnerMesecS;
	}
	private JSpinner getSpinnerGodS() {
		if (spinnerGodS == null) {
			spinnerGodS = new JSpinner();
			spinnerGodS.setModel(new SpinnerNumberModel(new Integer(2016), null, null, new Integer(1)));
			spinnerGodS.setBounds(282, 253, 66, 42);
		}
		return spinnerGodS;
	}
}
