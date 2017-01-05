package model;

import java.util.Random;

import exception.FeuIntensiteException;

public class Feu {

	private int intensite;
	private int positionH;
	private int positionV;
	
	/** Constructeur paramétré.
	 * @param pfIntensite
	 * @throws FeuIntensiteException
	 */
	public Feu(int pfIntensite) throws FeuIntensiteException{
		if (pfIntensite<1 || pfIntensite>3){
			throw new FeuIntensiteException();
		}
		this.intensite = pfIntensite;
		this.positionH=0;
		this.positionV=0;
	}
	
	
	
	/** Constructeur paramétré prenant en compte l'entensité du feu ainsi que sa position verticale et horizontale.
	 * @param pfIntensite
	 * @param pfPositionH
	 * @param pfPositionV
	 * @throws FeuIntensiteException 
	 */
	public Feu(int pfIntensite, int pfPositionH, int pfPositionV) throws FeuIntensiteException {
		super();
		if (pfIntensite<1 || pfIntensite>3){
			throw new FeuIntensiteException();
		}
		this.intensite = pfIntensite;
		this.positionH = pfPositionH;
		this.positionV = pfPositionV;
	}



	/** Retourne l'intensité du feu.
	 * @return intensite
	 */
	public int getIntensite() {
		return this.intensite;
	}
	
	/**
	 * @param pfIntensite
	 * @throws FeuIntensiteException
	 */
	public void setIntensite(int pfIntensite) throws FeuIntensiteException {
		if (pfIntensite<1 || pfIntensite>3){
			throw new FeuIntensiteException();
		}
		this.intensite = pfIntensite;
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
