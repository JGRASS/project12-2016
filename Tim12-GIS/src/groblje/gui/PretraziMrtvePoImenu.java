package groblje.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import groblje.Grob;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class PretraziMrtvePoImenu extends JFrame {

	private JPanel contentPane;
	private JLabel lblUnesiImeI;
	private JTextField textFieldImePrezime;
	private JTextArea textAreaMrtvi;
	private JButton btnPretrazi;
	private JPanel Sever;


	/**
	 * Create the frame.
	 */
	public PretraziMrtvePoImenu() {
		setTitle("Pretrazi mrtve");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getTextAreaMrtvi());
		contentPane.add(getSever(), BorderLayout.NORTH);
	}
	private JLabel getLblUnesiImeI() {
		if (lblUnesiImeI == null) {
			lblUnesiImeI = new JLabel("Unesi ime i prezime:");
		}
		return lblUnesiImeI;
	}
	private JTextField getTextFieldImePrezime() {
		if (textFieldImePrezime == null) {
			textFieldImePrezime = new JTextField();
			textFieldImePrezime.setPreferredSize(new Dimension(10, 20));
			textFieldImePrezime.setColumns(10);
		}
		return textFieldImePrezime;
	}
	private JTextArea getTextAreaMrtvi() {
		if (textAreaMrtvi == null) {
			textAreaMrtvi = new JTextArea();
			textAreaMrtvi.setEditable(false);
		}
		return textAreaMrtvi;
	}
	private JButton getBtnPretrazi() {
		if (btnPretrazi == null) {
			btnPretrazi = new JButton("Pretrazi");
			btnPretrazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String imePrezime = textFieldImePrezime.getText();
					LinkedList<Grob> mrtvi = GUIKontroler.pretraziMrtvePoImenu(imePrezime);
					
					if ( mrtvi.isEmpty() ) {
						textAreaMrtvi.setText("Nema mrtvih pod imenom " + imePrezime + "\n");
					} else {
						
						int i = 0;
						
						while ( i < mrtvi.size() ) {
							textAreaMrtvi.append("SIFRA: " + mrtvi.get(i).getSifra() + " IME I PREZIME:" + mrtvi.get(i).getImePrezime() + " DATUM SMRTI (mesec i godina): " + mrtvi.get(i).getDatumSmrti().MONTH + ". " + mrtvi.get(i).getDatumSmrti().YEAR + "\n");
							i++;
						}
						
					}
					
				}
			});
		}
		return btnPretrazi;
	}
	private JPanel getSever() {
		if (Sever == null) {
			Sever = new JPanel();
			Sever.add(getLblUnesiImeI());
			Sever.add(getTextFieldImePrezime());
			Sever.add(getBtnPretrazi());
		}
		return Sever;
	}
}
