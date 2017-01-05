package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Main;
import model.Carte;
import model.Dessin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Accueil extends JFrame {

	private JPanel contentPane;
	private Principal2 vuePrincipale;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil(new Principal2(new Dessin(new Carte()), new Main()));
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
	public Accueil(final Principal2 vuePrincipale) {
		vuePrincipale.setVisible(false);
		this.vuePrincipale=vuePrincipale;
		setTitle("Pompiers des airs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel boutons = new JPanel();
		contentPane.add(boutons, BorderLayout.SOUTH);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBtnFermer();
			}
		});
		
		JButton btnNouvelleSimulation = new JButton("Nouvelle simulation");
		btnNouvelleSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vuePrincipale.setVisible(true);
				setVisible(false);
			}
		});
		boutons.add(btnNouvelleSimulation);
		
		JButton btnChargerSimulation = new JButton("Charger simulation ");
		btnChargerSimulation.setEnabled(false);
		boutons.add(btnChargerSimulation);
		boutons.add(btnFermer);
		
		JLabel lblBienvenueDansLe = new JLabel("Bienvenue dans le simulateur Pompiers des airs");
		lblBienvenueDansLe.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblBienvenueDansLe.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBienvenueDansLe, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Accueil.class.getResource("/images/accueil.jpg")));
		contentPane.add(label, BorderLayout.CENTER);
	}
	
	
	private void actionBtnFermer(){
		int confirmation;
		confirmation = JOptionPane.showConfirmDialog(
			this, "Voulez-vous réellement quitter cette application ?", "Quitter ?",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if ( confirmation==JOptionPane.YES_OPTION ) {
			System.exit(0);
		}
	
	}

}
