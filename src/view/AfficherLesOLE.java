package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exception.OlePuissanceException;
import exception.OleVitesseException;
import model.OLE;

import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

public class AfficherLesOLE extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] lesObjets;
	private String[] titres;
	private ArrayList<OLE> lesOLE;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherLesOLE frame = new AfficherLesOLE(RetourneTestOLE());
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
	@SuppressWarnings("serial")
	public AfficherLesOLE(ArrayList<OLE> pfOLE) {
		
		lesOLE= pfOLE;
		//lesObjets = new Object[][] { {"test", new Integer(1)},};
		lesObjets = new Object[lesOLE.size()+1][5];
		
		for (int i=0; i<lesOLE.size(); i++){
			lesObjets[i][0]="OLE"+i;
			lesObjets[i][1]=lesOLE.get(i).getPositionH();
			lesObjets[i][2]=lesOLE.get(i).getPositionV();
			lesObjets[i][3]=lesOLE.get(i).getPuissance();
			lesObjets[i][4]=lesOLE.get(i).getVitesse();
			
			
		}
		
		
		titres = new String[] {"num\u00E9ro de OLE","Position H","Position V","puissance","vitesse"};
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 505, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(lesObjets, titres));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMaxWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(67);
		table.getColumnModel().getColumn(1).setMaxWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setMaxWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(67);
		table.getColumnModel().getColumn(3).setMaxWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(67);
		table.getColumnModel().getColumn(3).setMaxWidth(90);
		table.getTableHeader().setReorderingAllowed(false);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(new JScrollPane(table));
		setTitle("Liste des OLEx");
	}

	private static ArrayList<OLE> RetourneTestOLE(){
		ArrayList<OLE> listeDeTest = new ArrayList<OLE>();
		try {
			listeDeTest.add(new OLE(1,2, 1000, 1000));
			listeDeTest.add(new OLE(3,2, 500, 500));
			listeDeTest.add(new OLE(2,2, 4000, 4000));
		} catch (OleVitesseException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		} catch (OlePuissanceException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		return listeDeTest;
	}
	
	
}
