package groblje.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RezervisiMestoProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblUnesiteifruMesta;
	private JTextField txtRezervisi;
	private JButton btnRezervii;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public RezervisiMestoProzor() {
		setResizable(false);
		setTitle("Rezervi\u0161i mesto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 270, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 5, 5));
		contentPane.add(getLblUnesiteifruMesta());
		contentPane.add(getTxtRezervisi());
		contentPane.add(getBtnRezervii());
		contentPane.add(getTextArea());
	}

	private JLabel getLblUnesiteifruMesta() {
		if (lblUnesiteifruMesta == null) {
			lblUnesiteifruMesta = new JLabel("Unesite \u0161ifru mesta koji \u017Eelite da rezervi\u0161ete");
		}
		return lblUnesiteifruMesta;
	}

	private JTextField getTxtRezervisi() {
		if (txtRezervisi == null) {
			txtRezervisi = new JTextField();
			txtRezervisi.setPreferredSize(new Dimension(6, 10));
			txtRezervisi.setColumns(10);
		}
		return txtRezervisi;
	}

	private JButton getBtnRezervii() {
		if (btnRezervii == null) {
			btnRezervii = new JButton("Rezervi\u0161i");
			btnRezervii.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sifra = txtRezervisi.getText();
					GUIKontroler.rezervisiMesto(sifra);
					if (GUIKontroler.proveriOdredjenoMesto(sifra))
						textArea.setText("Uspesno ste rezervisali mesto " + sifra);
					else
						textArea.setText("Neuspela rezervacija!");
				}
			});
		}
		return btnRezervii;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "STATUS",
					TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		}
		return textArea;
	}
}
