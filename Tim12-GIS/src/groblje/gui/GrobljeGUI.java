package groblje.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import groblje.gui.models.GrobTableModel;
import java.awt.Rectangle;
import javax.swing.ScrollPaneConstants;
import java.awt.Point;
import javax.swing.table.DefaultTableModel;

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
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmExit;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmRefresh;


	/**
	 * Create the frame.
	 */
	public GrobljeGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.ugasiAplikaciju();
			}

		});
		setTitle("Groblje IS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GrobljeGUI.class.getResource("/icons/black-cross-clipart-19684-black-cross-design.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 432);
		setJMenuBar(getMenuBar_1());
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
			btnProveriSlobodnaMesta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.proveriSlobodnaMesta();
				}
			});
			btnProveriSlobodnaMesta.setPreferredSize(new Dimension(200, 50));
		}
		return btnProveriSlobodnaMesta;
	}
	private JButton getBtnProveriOdredjenoMesto() {
		if (btnProveriOdredjenoMesto == null) {
			btnProveriOdredjenoMesto = new JButton("Proveri odre\u0111eno mesto");
			btnProveriOdredjenoMesto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.pokreniProveriMestoProzor();
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
					GUIKontroler.pokreniPretraziMrtveProzor();
				}
			});
			btnPretraziMrtve.setPreferredSize(new Dimension(200, 50));
		}
		return btnPretraziMrtve;
	}
	private JButton getBtnRezervisiMesto() {
		if (btnRezervisiMesto == null) {
			btnRezervisiMesto = new JButton("Rezervi\u0161i mesto");
			btnRezervisiMesto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.pokreniRezervisiMestoProzor();
				}
			});
			btnRezervisiMesto.setPreferredSize(new Dimension(200, 50));
		}
		return btnRezervisiMesto;
	}
	private JButton getBtnOslobodiRezervaciju() {
		if (btnOslobodiRezervaciju == null) {
			btnOslobodiRezervaciju = new JButton("Oslobodi rezervaciju");
			btnOslobodiRezervaciju.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.pokreniOslobodiMestoProzor();
				}
			});
			btnOslobodiRezervaciju.setPreferredSize(new Dimension(200, 50));
		}
		return btnOslobodiRezervaciju;
	}
	private JButton getBtnUnesiUmrlog() {
		if (btnUnesiUmrlog == null) {
			btnUnesiUmrlog = new JButton("Unesi umrlog");
			btnUnesiUmrlog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.pokreniUnesiUmrlogProzor();
				}
			});
			btnUnesiUmrlog.setPreferredSize(new Dimension(200, 50));
		}
		return btnUnesiUmrlog;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setViewportView(getTable());
			
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setRowHeight(20);
			table.setFillsViewportHeight(true);
			table.setModel(new GrobTableModel(GUIKontroler.vratiSveGrobove()));
			table.getColumnModel().getColumn(0).setResizable(false);
		}
		return table;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmRefresh());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ucitajIzfajla();
				}
			});
			mntmOpen.setIcon(new ImageIcon(GrobljeGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
			mntmExit.setIcon(new ImageIcon(GrobljeGUI.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		}
		return mntmExit;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(contentPane, "Aplikaciju napravili: \n"
							+ "1. Ana Miliæ\n2. Nikola Manojloviæ\n3. Aleksandra Mikaševiæ ", "About", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
			mntmAbout.setIcon(new ImageIcon(GrobljeGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify.gif")));
		}
		return mntmAbout;
	}
	private JMenuItem getMntmRefresh() {
		if (mntmRefresh == null) {
			mntmRefresh = new JMenuItem("Refresh");
			mntmRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					GUIKontroler.osveziTabelu();
				}
			});
			mntmRefresh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
			mntmRefresh.setIcon(new ImageIcon(GrobljeGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		}
		return mntmRefresh;
	}
	
	public void osveziTabelu() {

		GrobTableModel model = (GrobTableModel) table.getModel();
		model.staviGroboveUModel(GUIKontroler.vratiSveGrobove());
	}
}
