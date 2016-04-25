package groblje.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GrobljeGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnProveriSlobodnaMesta;
	private JButton btnProveriOdreenoMesto;
	private JButton btnPretraiMrtve;
	private JButton btnRezerviiMesto;
	private JButton btnOslobodiRezervaciju;
	private JButton btnUnesiUmrlog;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrobljeGUI frame = new GrobljeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GrobljeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(150, 10));
			panel.add(getBtnProveriSlobodnaMesta());
			panel.add(getBtnProveriOdreenoMesto());
			panel.add(getBtnPretraiMrtve());
			panel.add(getBtnRezerviiMesto());
			panel.add(getBtnOslobodiRezervaciju());
			panel.add(getBtnUnesiUmrlog());
		}
		return panel;
	}
	private JButton getBtnProveriSlobodnaMesta() {
		if (btnProveriSlobodnaMesta == null) {
			btnProveriSlobodnaMesta = new JButton("Proveri slobodna mesta");
			btnProveriSlobodnaMesta.setPreferredSize(new Dimension(147, 25));
		}
		return btnProveriSlobodnaMesta;
	}
	private JButton getBtnProveriOdreenoMesto() {
		if (btnProveriOdreenoMesto == null) {
			btnProveriOdreenoMesto = new JButton("Proveri odre\u0111eno mesto");
			btnProveriOdreenoMesto.setPreferredSize(new Dimension(147, 25));
		}
		return btnProveriOdreenoMesto;
	}
	private JButton getBtnPretraiMrtve() {
		if (btnPretraiMrtve == null) {
			btnPretraiMrtve = new JButton("Pretra\u017Ei mrtve po imenu");
			btnPretraiMrtve.setPreferredSize(new Dimension(147, 25));
		}
		return btnPretraiMrtve;
	}
	private JButton getBtnRezerviiMesto() {
		if (btnRezerviiMesto == null) {
			btnRezerviiMesto = new JButton("Rezervi\u0161i mesto");
			btnRezerviiMesto.setPreferredSize(new Dimension(147, 25));
		}
		return btnRezerviiMesto;
	}
	private JButton getBtnOslobodiRezervaciju() {
		if (btnOslobodiRezervaciju == null) {
			btnOslobodiRezervaciju = new JButton("Oslobodi rezervaciju");
			btnOslobodiRezervaciju.setPreferredSize(new Dimension(147, 25));
		}
		return btnOslobodiRezervaciju;
	}
	private JButton getBtnUnesiUmrlog() {
		if (btnUnesiUmrlog == null) {
			btnUnesiUmrlog = new JButton("Unesi umrlog");
			btnUnesiUmrlog.setPreferredSize(new Dimension(147, 25));
		}
		return btnUnesiUmrlog;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFillsViewportHeight(true);
		}
		return table;
	}
}
