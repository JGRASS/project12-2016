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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OslobodiMestoProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblUnesiteifruMesta;
	private JTextField txtSifra;
	private JButton btnOslobodiRezervaciju;
	private JTextArea textArea;


	/**
	 * Create the frame.
	 */
	public OslobodiMestoProzor() {
		setResizable(false);
		setTitle("Oslobađanje mesta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 306, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 5, 5));
		contentPane.add(getLblUnesiteifruMesta());
		contentPane.add(getTxtSifra());
		contentPane.add(getBtnOslobodiRezervaciju());
		contentPane.add(getTextArea());
	}

	private JLabel getLblUnesiteifruMesta() {
		if (lblUnesiteifruMesta == null) {
			lblUnesiteifruMesta = new JLabel("Unesite \u0161ifru mesta \u010Diju rezervaciju osloba\u0111ate");
		}
		return lblUnesiteifruMesta;
	}
	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}
	private JButton getBtnOslobodiRezervaciju() {
		if (btnOslobodiRezervaciju == null) {
			btnOslobodiRezervaciju = new JButton("Oslobodi rezervaciju");
			btnOslobodiRezervaciju.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sifra = txtSifra.getText();
					try{GUIKontroler.oslobodi(sifra);
					if(!GUIKontroler.proveriOdredjenoMesto(sifra))
						textArea.setText("Uspešno ste skinuli rezervaciju sa mesta "+sifra);
					else 
						textArea.setText("Oslobadjanje rezervacije neuspešno!" );}
					catch(RuntimeException r){
						textArea.setText(r.getMessage());
					};
				}
			});
		}
		return btnOslobodiRezervaciju;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		}
		return textArea;
	}
}
