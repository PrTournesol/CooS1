package controller;

import model.Carte;
import model.Feu;
import model.OLE;

public class Pythagore {
		
	public static Double[][] CalculerDistances(Carte pfCarte){
		Double[][] lesDistances = new Double[pfCarte.getListFeu().size()][pfCarte.getListOLE().size()];
		for (int i=0; i<pfCarte.getListFeu().size();  i++){
			for (int j=0; j<pfCarte.getListOLE().size();j++){
				lesDistances[i][j]=dist(pfCarte.getListFeu().get(i),pfCarte.getListOLE().get(j));				
			}
		}
		return lesDistances;
		
		
	}

	private static Double dist(Feu feu, OLE ole) {
		int distH;
		int distV;
		double dist;
		distH=Math.abs(feu.getPositionH()-ole.getPositionH());
		distV=Math.abs(feu.getPositionV()-ole.getPositionV());
		dist=Math.sqrt(Math.pow(distH,2)+Math.pow(distV,2));
		return dist;
	}
	

}
