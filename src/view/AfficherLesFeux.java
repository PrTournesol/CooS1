package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exception.FeuIntensiteException;
import model.Feu;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

public class AfficherLesFeux extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] lesObjets;
	private String[] titres;
	private ArrayList<Feu> lesFeu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherLesFeux frame = new AfficherLesFeux(RetourneTestFeux());
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
	public AfficherLesFeux(ArrayList<Feu> pfFeu) {
		lesFeu= pfFeu;
		//lesObjets = new Object[][] { {"test", new Integer(1)},};
		lesObjets = new Object[lesFeu.size()+1][4];
		
		for (int i=0; i<lesFeu.size(); i++){
			lesObjets[i][0]="Feu"+i;
			lesObjets[i][1]=lesFeu.get(i).getPositionH();
			lesObjets[i][2]=lesFeu.get(i).getPositionV();
			lesObjets[i][3]=lesFeu.get(i).getIntensite();
			
			
		}
		
		
		titres = new String[] {"num\u00E9ro de Feu","Position H","Position V","intensit\u00E9"};
		
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
	
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(67);
		table.getColumnModel().getColumn(1).setMaxWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setMaxWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(67);
		table.getColumnModel().getColumn(3).setMaxWidth(90);
		table.getTableHeader().setReorderingAllowed(false);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(new JScrollPane(table));
		setTitle("Liste des Feux");
	}

	private static ArrayList<Feu> RetourneTestFeux(){
		ArrayList<Feu> listeDeTest = new ArrayList<Feu>();
		try {
			listeDeTest.add(new Feu(2, 1000, 1000));
			listeDeTest.add(new Feu(2, 500, 500));
			listeDeTest.add(new Feu(2, 4000, 4000));
		} catch (FeuIntensiteException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		return listeDeTest;
	}
	
	
}
