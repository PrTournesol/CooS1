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
import exception.OlePuissanceException;
import exception.OleVitesseException;
import model.Feu;
import model.OLE;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;

public class AfficherLaSimu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] lesObjets;
	private String[] titres;
	private int nbFeux;
	private int nbOLE;
	private Double[][] lesDistances;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherLaSimu frame = new AfficherLaSimu(1,2,null);
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
	public AfficherLaSimu(int pfNbFeux, int pfNbOLE, Double[][] pfLesDistances) {
		lesDistances=pfLesDistances;
		nbFeux= pfNbFeux;
		nbOLE=pfNbOLE;
		
		lesObjets = new Object[nbFeux+1][nbOLE+1];
		
		for (int i=0; i<nbFeux; i++){
			lesObjets[i][0]="Feu"+i;	
		}
		
		for (int i=0; i<nbFeux;  i++){
			for (int j=0; j< nbOLE ;j++){
				lesObjets[i][j+1]=lesDistances[i][j];				
			}
		}
		
		
		titres = new String[nbOLE+1];
		titres[0] = "Feux \\ OLE ";
		for (int i=0; i<nbOLE; i++){
			titres[i+1]="OLE"+i;
		}
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(true);
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(lesObjets, titres));
	
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		
		for (int i=0; i<nbOLE; i++){
			table.getColumnModel().getColumn(i+1).setPreferredWidth(80);
		}
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setSize(800, 800);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(new JScrollPane(table));
		setTitle("Liste des Feux");
	}

	
}
