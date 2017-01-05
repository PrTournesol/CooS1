package controller;

import javax.swing.JFrame;

import exception.CarteHorizException;
import exception.CarteVertException;
import exception.FeuIntensiteException;
import exception.OlePuissanceException;
import exception.OleVitesseException;
import model.*;
import view.*;
import controller.*;

public class Main {
	
	private Carte carte;
	private Dessin dessin;
	private Principal2 vue;
	private Accueil accueil;
	
	
	
	/** Constructeur
	 * 
	 */
	public Main() {
		super();
		carte=new Carte();
		dessin = new Dessin(carte);
		vue=new Principal2(dessin, this);
		accueil=new Accueil(vue);
		accueil.setVisible(true);
	}



	public static void main(String[] args) {
		Main main = new Main();
		/*try {
			main.carte.addFeu(new Feu(2, 1000, 1000));
			main.carte.addFeu(new Feu(2, 500, 500));
			main.carte.addFeu(new Feu(2, 4000, 4000));
			main.carte.addOLE(new OLE(1, 3, 750, 750));
			main.carte.addOLE(new OLE(1, 3, 2500, 3457));

		} catch (CarteHorizException | CarteVertException | FeuIntensiteException | OleVitesseException | OlePuissanceException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}*/
		
		
		}
	
	public void genererCarte(int pfLargeur, int pfHauteur){
		try {
			carte.setLargeur(pfLargeur);
			carte.setHauteur(pfHauteur);
		} catch (CarteHorizException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		} catch (CarteVertException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		
	}



	public void ajouterOLE(OLE ole) {
		try {
			carte.addOLE(ole);
		} catch (CarteHorizException | CarteVertException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
		
	}

	public void ajouterFeu(Feu feu) {
		
		try {
			carte.addFeu(feu);
		} catch (CarteHorizException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		} catch (CarteVertException e) {
			// TODO Bloc catch généré automatiquement
			e.printStackTrace();
		}
	}
	
	public void genererOLEs(int nombre){
		carte.genererOLEs(nombre);
	}
	
	public void genererFeux(int nombre){
		carte.genererFeux(nombre);
	}

	
	public void afficherLesOLE(){
		JFrame lesOLE = new AfficherLesOLE(carte.getListOLE());
		lesOLE.setVisible(true);
	}
	
	public void afficherLeFeux(){
		JFrame lesFeux = new AfficherLesFeux(carte.getListFeu());
		lesFeux.setVisible(true);
	}
	
	
	public void afficherLaSimu(){
		AfficherLaSimu laSimu = new AfficherLaSimu(carte.getListFeu().size(), carte.getListOLE().size(),Pythagore.CalculerDistances(carte));
		laSimu.setVisible(true);
	}
	
}



	