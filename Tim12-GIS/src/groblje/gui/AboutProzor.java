package groblje.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Font;

public class AboutProzor extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JEditorPane dtrpnInformacioniSistemGroblja;


	/**
	 * Create the frame.
	 */
	public AboutProzor() {
		setTitle("Pomo\u0107");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutProzor.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getDtrpnInformacioniSistemGroblja());
		}
		return scrollPane;
	}
	private JEditorPane getDtrpnInformacioniSistemGroblja() {
		if (dtrpnInformacioniSistemGroblja == null) {
			dtrpnInformacioniSistemGroblja = new JEditorPane();
			dtrpnInformacioniSistemGroblja.setContentType("text/plane");
			dtrpnInformacioniSistemGroblja.setFont(new Font("Tahoma", Font.PLAIN, 15));
			dtrpnInformacioniSistemGroblja.setBackground(Color.LIGHT_GRAY);
			dtrpnInformacioniSistemGroblja.setText("Informacioni sistem groblja vam omogu\u0107ava:\r\n1. Rezervaciju grobnog mesta, potrebno je znati \u0161ifru grobnog mesta. \r\n2. Brisanje unete rezervacije, tako\u0111e je potrebno znati jedinstvenu \u0161ifru grobnog mesta.\r\n3. Uno\u0161enje umrlog u bazu podataka, obavezno je znati ime i prezime umrlog, ime i prezime osobe koja pla\u0107a grobno mesto.\r\n4. Pretra\u017Eivanje baze podataka i dobijanje informacije na osnovu imena i prezimena umrlog, mo\u017Ee se dobiti vi\u0161e osoba.\r\n5. Dobijanje informacije o zauzetosti odre\u0111enog grobnog mesta, na osnovu njegove \u0161ifre.\r\n6. Dobijanje infromacije o broju slobodnih mesta na groblju, ukoliko do\u0111e do popunjavanja groblja, ne\u0107e vi\u0161e biti omogu\u0107en unos umrlih.\r\n\r\nAplikaciju napravili:\r\n1. Ana Mili\u0107\r\n2. Nikola Manojlovi\u0107\r\n3. Aleksandra Mika\u0161evi\u0107");
		}
		return dtrpnInformacioniSistemGroblja;
	}
}
