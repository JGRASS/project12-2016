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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GrobljeGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnProveriSlobodnaMesta;
	private JButton btnProveriOdredjenoMesto;
	private JButton btnPretraziMrtve;
	private JButton btnRezervisiMesto;
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
		setTitle("Groblje IS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GrobljeGUI.class.getResource("/icons/cemetery-headstones.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 402);
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
			panel.setPreferredSize(new Dimension(210, 10));
			panel.add(getBtnProveriSlobodnaMesta());
			panel.add(getBtnProveriOdredjenoMesto());
			panel.add(getBtnPretraziMrtve());
			panel.add(getBtnRezervisiMesto());
			panel.add(getBtnOslobodiRezervaciju());
			panel.add(getBtnUnesiUmrlog());
		}
		return panel;
	}
	private JButton getBtnProveriSlobodnaMesta() {
		if (btnProveriSlobodnaMesta == null) {
			btnProveriSlobodnaMesta = new JButton("Proveri broj slobodnih mesta");
			btnProveriSlobodnaMesta.setPreferredSize(new Dimension(200, 50));
		}
		return btnProveriSlobodnaMesta;
	}
	private JButton getBtnProveriOdredjenoMesto() {
		if (btnProveriOdredjenoMesto == null) {
			btnProveriOdredjenoMesto = new JButton("Proveri odre\u0111eno mesto");
			btnProveriOdredjenoMesto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnProveriOdredjenoMesto.setPreferredSize(new Dimension(200, 50));
		}
		return btnProveriOdredjenoMesto;
	}
	private JButton getBtnPretraziMrtve() {
		if (btnPretraziMrtve == null) {
			btnPretraziMrtve = new JButton("Pretra\u017Ei mrtve po imenu");
			btnPretraziMrtve.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnPretraziMrtve.setPreferredSize(new Dimension(200, 50));
		}
		return btnPretraziMrtve;
	}
	private JButton getBtnRezervisiMesto() {
		if (btnRezervisiMesto == null) {
			btnRezervisiMesto = new JButton("Rezervi\u0161i mesto");
			btnRezervisiMesto.setPreferredSize(new Dimension(200, 50));
		}
		return btnRezervisiMesto;
	}
	private JButton getBtnOslobodiRezervaciju() {
		if (btnOslobodiRezervaciju == null) {
			btnOslobodiRezervaciju = new JButton("Oslobodi rezervaciju");
			btnOslobodiRezervaciju.setPreferredSize(new Dimension(200, 50));
		}
		return btnOslobodiRezervaciju;
	}
	private JButton getBtnUnesiUmrlog() {
		if (btnUnesiUmrlog == null) {
			btnUnesiUmrlog = new JButton("Unesi umrlog");
			btnUnesiUmrlog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnUnesiUmrlog.setPreferredSize(new Dimension(200, 50));
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
			table.setPreferredSize(new Dimension(150, 10));
			table.setFillsViewportHeight(true);
		}
		return table;
	}
}
