package item.lib;
import world.lib.Cell;

import ihm.lib.Bitmaps;
import item.api.Item;

import agents.api.Agent;

public class Wood extends Item {

	public int life;
	public String name;
	protected static int cpt=0;
	public int quantite;
			
	/**
	 * default constructor
	 * the param life is initialized to a random value between 10 and 30
	 */
	public Wood(Cell c) {
		super(c);
		this.life = 20 ;
		this.quantite = 100;
		this.type = "WOOD";
		this.name = "WOOD"+cpt++;
		m_image = Bitmaps.listItems[1];
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
}
