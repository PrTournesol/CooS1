package model;

import exception.OlePuissanceException;
import exception.OleVitesseException;

public class OLE {

	private int vitesse;
	private int puissance;
	private int positionH;
	private int positionV;

	public OLE(int pfVitesse, int pfPuissance) throws Exception {
		if (pfVitesse > 3 || pfVitesse < 1 ){
			throw new OleVitesseException();
		}
		if ( pfPuissance > 3 || pfPuissance < 1) {
			throw new OlePuissanceException();
		}
		this.vitesse = pfVitesse;
		this.puissance = pfPuissance;
		this.positionH=0;
		this.positionV=0;
	}
	
	

	/** Constructeur
	 * @param pfVitesse
	 * @param pfPuissance
	 * @param positionH
	 * @param positionV
	 * @throws OleVitesseException 
	 * @throws OlePuissanceException 
	 */
	public OLE(int pfVitesse, int pfPuissance, int positionH, int positionV) throws OleVitesseException, OlePuissanceException {
		if (pfVitesse > 3 || pfVitesse < 1 ){
			throw new OleVitesseException();
		}
		if ( pfPuissance > 3 || pfPuissance < 1) {
			throw new OlePuissanceException();
		}
		this.vitesse = pfVitesse;
		this.puissance = pfPuissance;
		this.positionH = positionH;
		this.positionV = positionV;
	}



	public int getVitesse() {
		return this.vitesse;
	}

	public int getPuissance() {
		return this.puissance;
	}

	public void setVitesse(int pfVitesse) throws OleVitesseException {
		if (pfVitesse > 3 || pfVitesse < 1 ){
			throw new OleVitesseException();
		}
		this.vitesse = pfVitesse;
	}

	public void setPuissance(int pfPuissance) throws OlePuissanceException {
		if ( pfPuissance > 3 || pfPuissance < 1) {
			throw new OlePuissanceException();
		}
		this.puissance = pfPuissance;
	}
	
	/**
	 * @return le positionH
	 */
	public int getPositionH() {
		return positionH;
	}



	/**
	 * @param positionH la position horizontale à définir
	 */
	public void setPositionH(int positionH) {
		this.positionH = positionH;
	}



	/**
	 * @return le positionV
	 */
	public int getPositionV() {
		return positionV;
	}



	/**
	 * @param positionV la position verticale à définir
	 */
	public void setPositionV(int positionV) {
		this.positionV = positionV;
	}

}
