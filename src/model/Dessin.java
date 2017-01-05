package model;

import java.awt.Graphics;
import java.awt.Paint;
import java.math.BigDecimal;

import javax.swing.JPanel;

public class Dessin extends JPanel {
	
	private Carte carte;
		
	
	/** Constructeur
	 * @param carte
	 */
	public Dessin(Carte carte) {
		super();
		this.carte = carte;
	}




	@Override
	public void paint(Graphics g){
		super.paint(g);
	    g.drawString("Simulation carte de dimension "+carte.getLargeur()+" 000 m x "+carte.getHauteur()+" 000 m", this.getWidth()/2-100, 20);
	   // g.drawRect(50, 50, this.getWidth()-80, this.getHeight()-80);

	    for (int i=0; i<=carte.getLargeur();i++){
		    g.drawLine(50+i*(this.getWidth()-100)/carte.getLargeur(), 50, 50+i*(this.getWidth()-100)/carte.getLargeur(),this.getHeight()-50);
	    }
	    for (int i=0; i<=carte.getHauteur();i++){
		    g.drawLine(50, 50+ i*(this.getHeight()-100)/carte.getHauteur(), this.getWidth()-50 ,50+ i*(this.getHeight()-100)/carte.getHauteur());
	    }
	    for (int i=0; i<carte.getListFeu().size();i++){
	    	Feu feu = carte.getListFeu().get(i);
	    	int val;
	    	g.drawString("Feu"+i, 40+feu.getPositionH()*(this.getWidth()-100)/(1000*carte.getLargeur()), 50+feu.getPositionV()*(this.getHeight()-100)/(1000*carte.getHauteur()));
	    }
	    
	    for (int i=0; i<carte.getListOLE().size();i++){
	    	OLE ole = carte.getListOLE().get(i);
	    	int val;
	    	g.drawString("OLE"+i, 40+ole.getPositionH()*(this.getWidth()-100)/(1000*carte.getLargeur()), 50+ole.getPositionV()*(this.getHeight()-100)/(1000*carte.getHauteur()));
	    }
	    
	    
	    System.out.println("carte "+carte.getHauteur()+" paint : carte " + this.getWidth()+" "+this.getHeight());
	   

		
		
	}



	

}
