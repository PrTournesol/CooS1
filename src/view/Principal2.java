package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Main;
import exception.FeuIntensiteException;
import exception.OlePuissanceException;
import exception.OleVitesseException;
import model.*;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Principal2 extends JFrame {
	
	private Main leMain;
	private Dessin dessin;
	private JPanel contentPane;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_9 = new JPanel();
	private JPanel panel_10 = new JPanel();
	private JPanel panel_11 = new JPanel();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_1 = new JComboBox();
	private JTextField posHOLE= new JTextField();
	private JTextField posVOLE= new JTextField();
	private JRadioButton btnOLEP1 = new JRadioButton("1");
	private JRadioButton btnOLEP2 = new JRadioButton("2");
	private JRadioButton btnOLEV1 = new JRadioButton("1");
	private JRadioButton btnOLEV2 = new JRadioButton("2");
	private JTextField posHFeu= new JTextField();
	private JTextField posVFeu= new JTextField();
	private JRadioButton btnFeuP1 = new JRadioButton("1");
	private JRadioButton btnFeuP2 = new JRadioButton("2");
	private JTextField nbOLE = new JTextField();
	private JTextField nbFeu = new JTextField();












	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal2 frame = new Principal2(new Dessin(new Carte()), new Main());
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
	public Principal2(Dessin leDessin, Main main) {
		this.leMain=main;
		this.dessin=leDessin;
		repeindre();
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e){
				repeindre();
		    }
		});
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_17 = new JPanel();
		panel.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCarte = new JLabel("Carte :");
		panel_17.add(lblCarte, BorderLayout.NORTH);
		lblCarte.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_17.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblTailleHoizontale = new JLabel("Taille  : largeur");
		panel_1.add(lblTailleHoizontale);
		
		comboBox.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10}));
		comboBox.setSelectedIndex(9);
		panel_1.add(comboBox);
		
		JLabel lblTailleVerticale = new JLabel("km  X  hauteur");
		panel_1.add(lblTailleVerticale);
		
		comboBox_1.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8,9,10}));
		comboBox_1.setSelectedIndex(9);
		panel_1.add(comboBox_1);
		
		
		JButton btnGnrer = new JButton("G\u00E9n\u00E9rer");
		btnGnrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				genererCarte((int)comboBox.getSelectedItem(), (int)comboBox_1.getSelectedItem());
				repeindre();
			}
		});
		
		JLabel lblKm = new JLabel("km    ");
		panel_1.add(lblKm);
		panel_1.add(btnGnrer);
		
		JSeparator separator_1 = new JSeparator();
		panel_17.add(separator_1, BorderLayout.SOUTH);
		
		JPanel panel_16 = new JPanel();
		panel.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_16.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblOle = new JLabel("OLE :");
		panel_2.add(lblOle);
		
		JRadioButton rdbtnAuto = new JRadioButton("auto");
		rdbtnAuto.setSelected(true);
		rdbtnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.setVisible(true);
				panel_9.setVisible(false);
				pack();
			}
		});
		buttonGroup.add(rdbtnAuto);
		panel_2.add(rdbtnAuto);
		
		JRadioButton rdbtnManuel = new JRadioButton("manuel");
		rdbtnManuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel_9.setVisible(true);
				pack();

			}
		});
		buttonGroup.add(rdbtnManuel);
		panel_2.add(rdbtnManuel);
		
		JButton btnNewButton = new JButton("Afficher la liste des OLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leMain.afficherLesOLE();
			}
		});
		panel_2.add(btnNewButton);
		
		JPanel panel_8 = new JPanel();
		panel_16.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_8.add(panel_9);
		panel_9.setVisible(false);
		panel_9.setLayout(new GridLayout(3, 0, 0, 0));
		JPanel panel_7 = new JPanel(); 
		
				panel_9.add(panel_7);
				
						JLabel lblPuissance = new JLabel("puissance");
						panel_7.add(lblPuissance);
						
						buttonGroup_2.add(btnOLEP1);
						panel_7.add(btnOLEP1);
						
						buttonGroup_2.add(btnOLEP2);
						panel_7.add(btnOLEP2);
						btnOLEP2.setSelected(true);

						
						JRadioButton btnOLEP3 = new JRadioButton("3");
						buttonGroup_2.add(btnOLEP3);
						panel_7.add(btnOLEP3);
						
		JPanel panel_6 = new JPanel();
		panel_9.add(panel_6);
		JLabel lblVitesst = new JLabel("vitesse");
		panel_6.add(lblVitesst);
		
		
		buttonGroup_3.add(btnOLEV1);
		panel_6.add(btnOLEV1);
		
		
		buttonGroup_3.add(btnOLEV2);
		panel_6.add(btnOLEV2);
		btnOLEV2.setSelected(true);
		
		JRadioButton btnOleV3 = new JRadioButton("3");
		buttonGroup_3.add(btnOleV3);
		panel_6.add(btnOleV3);
		
		JPanel panel_18 = new JPanel();
		panel_9.add(panel_18);
		
		JLabel lblPositionH = new JLabel("Position H :");
		panel_18.add(lblPositionH);
		
		panel_18.add(posHOLE);
		posHOLE.setColumns(5);
		
		JLabel lblNewLabel = new JLabel("m Position V :");
		panel_18.add(lblNewLabel);
		
		panel_18.add(posVOLE);
		posVOLE.setColumns(5);
		
		JLabel lblM = new JLabel("m    ");
		panel_18.add(lblM);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					leMain.ajouterOLE(new OLE(getOlePui(), getOleVit(), new Integer(posHOLE.getText()), new Integer(posVOLE.getText())));
					posHOLE.setText("");
					posVOLE.setText("");
					repeindre();
				} catch (NumberFormatException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				} catch (OleVitesseException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				} catch (OlePuissanceException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				}
			}
		});
		panel_18.add(button);
		panel_8.add(panel_3);
		panel_3.setVisible(true);
		
		JLabel nombreOLE = new JLabel("Nombre");
		panel_3.add(nombreOLE);		
		
		nbOLE.setColumns(10);
		panel_3.add(nbOLE);
		
		JButton btnGnrer_1 = new JButton("G\u00E9n\u00E9rer");
		btnGnrer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leMain.genererOLEs(new Integer(nbOLE.getText()));
				repeindre();
			}
		});
		panel_3.add(btnGnrer_1);
		
		JSeparator separator = new JSeparator();
		panel_16.add(separator, BorderLayout.SOUTH);
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_15.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblFeux = new JLabel("Feux :");
		panel_4.add(lblFeux);
		
		JRadioButton rdBtnAuto = new JRadioButton("auto");
		rdBtnAuto.setSelected(true);
		rdBtnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_10.setVisible(true);
				panel_11.setVisible(false);
				pack();

			}
		});
		buttonGroup_1.add(rdBtnAuto);
		panel_4.add(rdBtnAuto);
		
		JRadioButton rdBtnManuel = new JRadioButton("manuel");
		rdBtnManuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_10.setVisible(false);
				panel_11.setVisible(true);
				pack();

			}
		});
		buttonGroup_1.add(rdBtnManuel);
		panel_4.add(rdBtnManuel);
		
		JButton btnNewButton_1 = new JButton("Afficher la liste des feux");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leMain.afficherLeFeux();
			}
		});
		panel_4.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_15.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_5.add(panel_11);
		panel_11.setVisible(false);
		panel_11.setLayout(new GridLayout(2, 1, 0, 0));
		
				JPanel panel_12 = new JPanel();
				panel_11.add(panel_12);
				
				JLabel lblIntensit = new JLabel("intensit\u00E9");
				panel_12.add(lblIntensit);
				
				

				buttonGroup_4.add(btnFeuP1);
				panel_12.add(btnFeuP1);
				
				buttonGroup_4.add(btnFeuP2);
				btnFeuP2.setSelected(true);
				panel_12.add(btnFeuP2);
				
				JRadioButton btnFeuP3 = new JRadioButton("3");
				buttonGroup_4.add(btnFeuP3);
				panel_12.add(btnFeuP3);
				
				JPanel panel_13 = new JPanel();
				panel_11.add(panel_13);
				
				JLabel label_2 = new JLabel("Position H :");
				panel_13.add(label_2);
				
				panel_13.add(posHFeu);
				posHFeu.setColumns(5);
				
				JLabel label_3 = new JLabel("m Position V :");
				panel_13.add(label_3);
				
				panel_13.add(posVFeu);
				posVFeu.setColumns(5);
				
				JLabel label_4 = new JLabel("m    ");
				panel_13.add(label_4);
				
				JButton btnAjouter_1 = new JButton("Ajouter");
				btnAjouter_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							leMain.ajouterFeu(new Feu(getFeuPui(), new Integer(posHFeu.getText()), new Integer(posVFeu.getText())));
							posHFeu.setText("");
							posVFeu.setText("");
							repeindre();
						} catch (NumberFormatException e) {
							// TODO Bloc catch généré automatiquement
							e.printStackTrace();
						} catch (FeuIntensiteException e) {
							// TODO Bloc catch généré automatiquement
							e.printStackTrace();
						}
						repeindre();
						
					}
				});
				panel_13.add(btnAjouter_1);
		
		panel_5.add(panel_10);
		
		JLabel label = new JLabel("Nombre");
		panel_10.add(label);
		
		nbFeu.setColumns(10);
		panel_10.add(nbFeu);
		
		JButton btnGnrer_2 = new JButton("Générer");
		btnGnrer_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leMain.genererFeux(new Integer(nbFeu.getText()));
				repeindre();
			}
		});
		panel_10.add(btnGnrer_2);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		
		JButton btnLancerSimulation = new JButton("Lancer Simulation");
		btnLancerSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leMain.afficherLaSimu();
			}
		});
		panel_14.add(btnLancerSimulation);
		contentPane.add(dessin, BorderLayout.CENTER);
		dessin.setPreferredSize(new Dimension(800, 800));
		genererCarte(10,10);
		repeindre();
		pack();
	}
	
	protected int getFeuPui() {
		if (btnFeuP1.isSelected()) return 1;
		if (btnFeuP2.isSelected()) return 2;
		else return 3;
	}

	protected int getOleVit() {
		if (btnOLEP1.isSelected()) return 1;
		if (btnOLEP2.isSelected()) return 2;
		else return 3;
	}

	protected int getOlePui() {
		if (btnOLEV1.isSelected()) return 1;
		if (btnOLEV2.isSelected()) return 2;
		else return 3;
	}

	private void genererCarte(int pfLargeur, int pfHauteur){
		leMain.genererCarte(pfLargeur, pfHauteur);
	}

	public void repeindre(){
		dessin.repaint();
	}


}

