package ground.api;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import agents.api.Agent;



/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * inteface Ground :
 * a ground is an object which cost points of energy (health) to be gone through
 * a cell has his ground
 * 
 */
public abstract class Ground {
	
	
	public int energyCost ; 

	protected Image m_image;
	 
	/**
	 * method which processes the crossing of a ground
	 * @param character the character which goes through the cell
	 */
	public abstract void EnergyCost(Agent character) ;
	
	/**
	 * display the ground
	 * @return a string representing the ground
	 */
	public abstract  String toString() ;
	
	public abstract boolean equals(Ground g ) ;
	
	public  abstract boolean traversable();

	public void render(Graphics2D pGraphics,int tileset,int X,int Y) {
		pGraphics.drawImage(m_image, X*tileset, Y*tileset, tileset, tileset, null);
}
}
