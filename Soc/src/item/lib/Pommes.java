package item.lib;

import java.awt.Color;

import world.lib.Cell;

import ihm.lib.Bitmaps;
import item.api.Item;

import agents.api.Agent;

/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * class Pommes :
 * a food is a specific item with a value of life between 10 and 30
 */
public class Pommes extends Item {

	protected int life;
	protected String name;
	protected static int cpt=0;
	protected int quantite;
			
	/**
	 * default constructor
	 * the param life is initialized to a random value between 10 and 30
	 */
	public Pommes(Cell c) {
		super(c);
		this.life = 20 ;
		this.quantite = 20;
		this.type = "FOOD";
		this.name = "Pommes"+cpt++;
		m_image = Bitmaps.listItems[0];
	}
	/**
	 * Here the character's health is increased by the value of the food
	 * If the character's life is the maximum, the value isn't added to 
	 */
	public void usedBy(Agent p) {
		p.addHealth(this.life) ;
		if (p.getHealth() > 100) {
			p.setHealth(100) ;
		}
	}
	@Override
	public int energyCost() {
		return 1;
	}
	@Override
	public String getName() {
		return this.name;
	}
	public boolean decrease(){
		this.quantite--;
		if(this.quantite<0){
			return false;
		}
		return true;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
