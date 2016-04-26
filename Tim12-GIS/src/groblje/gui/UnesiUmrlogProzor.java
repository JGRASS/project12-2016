package groblje.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
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
		setBounds(100, 100, 337, 343);
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
			textImePrezime.setBounds(166, 6, 164, 42);
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
			textPosveta.setBounds(166, 58, 164, 42);
			textPosveta.setColumns(10);
		}
		return textPosveta;
	}
	private JLabel getLblDatumRoenja() {
		if (lblDatumRoenja == null) {
			lblDatumRoenja = new JLabel("Datum ro\u0111enja");
			lblDatumRoenja.setBounds(5, 162, 151, 42);
		}
		return lblDatumRoenja;
	}
	private JButton getBtnUnesiUmrlog() {
		if (btnUnesiUmrlog == null) {
			btnUnesiUmrlog = new JButton("Unesi umrlog");
			btnUnesiUmrlog.setBounds(5, 266, 151, 37);
			btnUnesiUmrlog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					String imePrezime = textImePrezime.getText();
					String posveta = textPosveta.getText();
					String rezervisao = textRezervisao.getText();
			
					int danR = (int) spinnerDanR.getValue();
					int mesecR = (int) spinnerMesecR.getValue();
					int godinaR = (int) spinnerGodinaR.getValue();
					GregorianCalendar datumRodjenja = new GregorianCalendar(godinaR, mesecR, danR);
					
					int danS = (int) spinnerDanS.getValue();
					int mesecS = (int) spinnerMesecS.getValue();
					int godinaS = (int) spinnerGodS.getValue();
					GregorianCalendar datumSmrti= new GregorianCalendar(godinaS, mesecS, danS);
					
					GUIKontroler.unesiUmrlog(imePrezime, posveta, rezervisao, datumRodjenja, datumSmrti);}
					
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
			textRezervisao.setBounds(166, 110, 164, 42);
			textRezervisao.setColumns(10);
		}
		return textRezervisao;
	}
	private JSpinner getSpinnerDanR() {
		if (spinnerDanR == null) {
			spinnerDanR = new JSpinner();
			spinnerDanR.setModel(new SpinnerNumberModel(1, 1, 31, 1));
			spinnerDanR.setBounds(166, 162, 48, 42);
		}
		return spinnerDanR;
	}
	private JSpinner getSpinnerMesecR() {
		if (spinnerMesecR == null) {
			spinnerMesecR = new JSpinner();
			spinnerMesecR.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spinnerMesecR.setBounds(224, 162, 48, 42);
		}
		return spinnerMesecR;
	}
	private JSpinner getSpinnerGodinaR() {
		if (spinnerGodinaR == null) {
			spinnerGodinaR = new JSpinner();
			spinnerGodinaR.setBounds(282, 162, 48, 42);
		}
		return spinnerGodinaR;
	}
	private JLabel getLblDatumSmrti() {
		if (lblDatumSmrti == null) {
			lblDatumSmrti = new JLabel("Datum smrti");
			lblDatumSmrti.setBounds(5, 213, 151, 42);
		}
		return lblDatumSmrti;
	}
	private JSpinner getSpinnerDanS() {
		if (spinnerDanS == null) {
			spinnerDanS = new JSpinner();
			spinnerDanS.setModel(new SpinnerNumberModel(1, 1, 31, 1));
			spinnerDanS.setBounds(166, 213, 48, 42);
		}
		return spinnerDanS;
	}
	private JSpinner getSpinnerMesecS() {
		if (spinnerMesecS == null) {
			spinnerMesecS = new JSpinner();
			spinnerMesecS.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spinnerMesecS.setBounds(224, 213, 48, 42);
		}
		return spinnerMesecS;
	}
	private JSpinner getSpinnerGodS() {
		if (spinnerGodS == null) {
			spinnerGodS = new JSpinner();
			spinnerGodS.setBounds(282, 213, 48, 42);
		}
		return spinnerGodS;
	}
}
