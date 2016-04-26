package groblje.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProveriMestoGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblUnesiteifruGroba;
	private JTextField txtSifra;
	private JTextArea textArea;
	private JButton btnProveri;

	

	/**
	 * Create the frame.
	 */
	public ProveriMestoGUI() {
		setTitle("Provera mesta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 239, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 5, 5));
		contentPane.add(getLblUnesiteifruGroba());
		contentPane.add(getTxtSifra());
		contentPane.add(getBtnProveri());
		contentPane.add(getTextArea());
	}
	private JLabel getLblUnesiteifruGroba() {
		if (lblUnesiteifruGroba == null) {
			lblUnesiteifruGroba = new JLabel("Unesite \u0161ifru groba koji proveravate");
		}
		return lblUnesiteifruGroba;
	}
	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		}
		return textArea;
	}
	private JButton getBtnProveri() {
		if (btnProveri == null) {
			btnProveri = new JButton("Proveri");
			btnProveri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sifra = txtSifra.getText();
					if(!GUIKontroler.proveriOdredjenoMesto(sifra))
						textArea.setText("Mesto sa šifrom "+sifra+" je slobodno");
					else 
						textArea.setText("Mesto sa šifrom "+sifra+" nije slobodno");
				}
			});
		}
		return btnProveri;
	}
}
