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

public class UnesiUmrlogProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblImeIPrezime;
	private JTextField textImePrezime;
	private JLabel lblPosveta;
	private JTextField textPosveta;
	private JLabel lblDatumRoenja;
	private JSpinner spinnerRodjenje;
	private JLabel lblDatumSmrti;
	private JSpinner spinnerSmrt;
	private JButton btnUnesiUmrlog;
	private JLabel lblRezervisao;
	private JTextField textRezervisao;

	/**
	 * Create the frame.
	 */
	public UnesiUmrlogProzor() {
		setTitle("Unesi umrlog");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 329, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 2, 10, 10));
		contentPane.add(getLblImeIPrezime());
		contentPane.add(getTextImePrezime());
		contentPane.add(getLblPosveta());
		contentPane.add(getTextPosveta());
		contentPane.add(getLblRezervisao());
		contentPane.add(getTextRezervisao());
		contentPane.add(getLblDatumRoenja());
		contentPane.add(getSpinnerRodjenje());
		contentPane.add(getLblDatumSmrti());
		contentPane.add(getSpinnerSmrt());
		contentPane.add(getBtnUnesiUmrlog());
	}
	private JLabel getLblImeIPrezime() {
		if (lblImeIPrezime == null) {
			lblImeIPrezime = new JLabel("Ime i prezime");
		}
		return lblImeIPrezime;
	}
	private JTextField getTextImePrezime() {
		if (textImePrezime == null) {
			textImePrezime = new JTextField();
			textImePrezime.setColumns(10);
		}
		return textImePrezime;
	}
	private JLabel getLblPosveta() {
		if (lblPosveta == null) {
			lblPosveta = new JLabel("Posveta");
		}
		return lblPosveta;
	}
	private JTextField getTextPosveta() {
		if (textPosveta == null) {
			textPosveta = new JTextField();
			textPosveta.setColumns(10);
		}
		return textPosveta;
	}
	private JLabel getLblDatumRoenja() {
		if (lblDatumRoenja == null) {
			lblDatumRoenja = new JLabel("Datum ro\u0111enja");
		}
		return lblDatumRoenja;
	}
	private JSpinner getSpinnerRodjenje() {
		if (spinnerRodjenje == null) {
			spinnerRodjenje = new JSpinner();
			spinnerRodjenje.setModel(new SpinnerDateModel(new Date(1461621600000L), null, null, Calendar.DAY_OF_YEAR));
		}
		return spinnerRodjenje;
	}
	private JLabel getLblDatumSmrti() {
		if (lblDatumSmrti == null) {
			lblDatumSmrti = new JLabel("Datum smrti");
		}
		return lblDatumSmrti;
	}
	private JSpinner getSpinnerSmrt() {
		if (spinnerSmrt == null) {
			spinnerSmrt = new JSpinner();
			spinnerSmrt.setModel(new SpinnerDateModel(new Date(1461621600000L), null, null, Calendar.DAY_OF_YEAR));
		}
		return spinnerSmrt;
	}
	private JButton getBtnUnesiUmrlog() {
		if (btnUnesiUmrlog == null) {
			btnUnesiUmrlog = new JButton("Unesi umrlog");
			btnUnesiUmrlog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String imePrezime = textImePrezime.getText();
					String posveta = textPosveta.getText();
					String rezervisao = textRezervisao.getText();
					GregorianCalendar datumRodjenja = (GregorianCalendar) spinnerRodjenje.getValue();
					GregorianCalendar datumSmrti =  (GregorianCalendar) spinnerSmrt.getValue();
					
					GUIKontroler.unesiUmrlog(imePrezime, posveta, rezervisao, datumRodjenja, datumSmrti);
			
					}
			});
		}
		return btnUnesiUmrlog;
	}
	private JLabel getLblRezervisao() {
		if (lblRezervisao == null) {
			lblRezervisao = new JLabel("Rezervisao");
		}
		return lblRezervisao;
	}
	private JTextField getTextRezervisao() {
		if (textRezervisao == null) {
			textRezervisao = new JTextField();
			textRezervisao.setColumns(10);
		}
		return textRezervisao;
	}
}
