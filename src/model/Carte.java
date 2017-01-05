package model;

import java.util.ArrayList;
import java.util.Random;

import exception.CarteVertException;
import exception.FeuIntensiteException;
import exception.OlePuissanceException;
import exception.OleVitesseException;
import exception.CarteHorizException;

public class Carte {
	// largeur de la carte de m�tres [0,10000]
	private int dimH;
	
	// hauteur de la carte de m�tres [0,10000]
	private int dimV;
	private ArrayList<Feu> ListFeu;
	private ArrayList<OLE> ListOLE;
	

	/**
	 * Constructeur par d�faut.
	 */
	public Carte() {
		this.dimH = 1;
		this.dimV = 1;
		this.ListFeu = new ArrayList<Feu>();
		this.ListOLE = new ArrayList<OLE>();
	}

	/** Constructeur param�tr� prenant en compte la taille de la carte (ligne et colonnes) en m�tres.
	 * @param pfLargeur
	 * @param pfHauteur
	 * @throws CarteHorizException 
	 * @throws CarteVertException 
	 */
	public Carte(int pfLargeur, int pfHauteur) throws CarteHorizException, CarteVertException {
		if (pfLargeur<=0 || pfLargeur >10000){
			throw new CarteHorizException();
		}
		if (pfHauteur<=0 || pfHauteur >10000){
			throw new CarteVertException();
		}
		this.dimH = pfLargeur;
		this.dimV = pfHauteur;
		this.ListFeu = new ArrayList<Feu>();
		this.ListOLE = new ArrayList<OLE>();
	}

	/**Constructeur param�tr� permettant de cr�er une carte par sa taille et ses feux et OLE.
	 * @param pfLargeur
	 * @param pfHauteur
	 * @param pfFeux
	 * @param pfOLEs
	 * @throws CarteHorizException 
	 * @throws CarteVertException 
	 */
	public Carte(int pfLargeur, int pfHauteur, ArrayList<Feu> pfFeux, ArrayList<OLE> pfOLEs) throws CarteHorizException, CarteVertException {
		if (pfLargeur<=0 || pfLargeur >10000){
			throw new CarteHorizException();
		}
		if (pfHauteur<=0 || pfHauteur >10000){
			throw new CarteVertException();
		}
		this.dimH = pfLargeur;
		this.dimV = pfHauteur;
		this.ListFeu = pfFeux;
		this.ListOLE = pfOLEs;
	}

	/**
	 * @return le largeur
	 */
	public int getLargeur() {
		return dimH;
	}

	/**
	 * @param pfLargeur la largeur de la carte � d�finir en m�tres 
	 * @throws CarteHorizException 
	 */
	public void setLargeur(int pfLargeur) throws CarteHorizException {
		if (pfLargeur<=0 || pfLargeur >10000){
			throw new CarteHorizException();
		}
		this.dimH = pfLargeur;
	}

	/**
	 * @return la hauteur de la carte en m�tres
	 */
	public int getHauteur() {
		return dimV;
	}

	/**
	 * @param pfHauteur la hauteur de la carte � d�finir en m�tres
	 * @throws CarteVertException 
	 */
	public void setHauteur(int pfHauteur) throws CarteVertException {
		if (pfHauteur<=0 || pfHauteur >10000){
			throw new CarteVertException();
		}
		this.dimV = pfHauteur;
	}

	/**
	 * @return l'ArrayList de Feu
	 */
	public ArrayList<Feu> getListFeu() {
		return ListFeu;
	}

	/**
	 * @return l'ArrayList d'OLE
	 */
	public ArrayList<OLE> getListOLE() {
		return ListOLE;
	}

	/**
	 * @param e
	 * @return
	 * @throws CarteHorizException 
	 * @throws CarteVertException 
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean addFeu(Feu e) throws CarteHorizException, CarteVertException {
		if (e.getPositionH()<0 || e.getPositionH()>10000){
			throw new CarteHorizException();
		}
		if (e.getPositionV()<0 || e.getPositionV()>10000){
			throw new CarteVertException();
		}
		return ListFeu.add(e);
	}

	/**
	 * @param e
	 * @return
	 * @throws CarteHorizException 
	 * @throws CarteVertException 
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	public boolean addOLE(OLE e) throws CarteHorizException, CarteVertException {
		if (e.getPositionH()<0 || e.getPositionH()>10000){
			throw new CarteHorizException();
		}
		if (e.getPositionV()<0 || e.getPositionV()>10000){
			throw new CarteVertException();
		}
		return ListOLE.add(e);
	}

	public void genererOLEs(int nombre){
		Random alea = new Random();
		for (int i=0; i<nombre; i++){
			try {
				addOLE(new OLE(1+alea.nextInt(3),1+alea.nextInt(3),alea.nextInt(1000*dimH),alea.nextInt(1000*dimV)));
			} catch (CarteHorizException e) {
				// TODO Bloc catch g�n�r� automatiquement
				e.printStackTrace();
			} catch (CarteVertException e) {
				// TODO Bloc catch g�n�r� automatiquement
				e.printStackTrace();
			} catch (OleVitesseException e) {
				// TODO Bloc catch g�n�r� automatiquement
				e.printStackTrace();
			} catch (OlePuissanceException e) {
				// TODO Bloc catch g�n�r� automatiquement
				e.printStackTrace();
			}			
		}		
	}
	
	public void genererFeux(int nombre){
		Random alea = new Random();
		for (int i=0; i<nombre; i++){
			
			try {
				addFeu(new Feu(1+alea.nextInt(3),alea.nextInt(1000*dimH),alea.nextInt(1000*dimV)));
			} catch (CarteHorizException e) {
				// TODO Bloc catch g�n�r� automatiquement
				e.printStackTrace();
			} catch (CarteVertException e) {
				// TODO Bloc catch g�n�r� automatiquement
				e.printStackTrace();
			} catch (FeuIntensiteException e) {
				// TODO Bloc catch g�n�r� automatiquement
				e.printStackTrace();
			}
			
		}		
	}
	
	
	
	

}
