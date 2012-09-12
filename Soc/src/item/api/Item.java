package item.api;

import java.awt.Graphics2D;
import java.awt.Image;

import world.lib.Cell;

import agents.api.Agent;

public abstract class Item {
	
	Cell cell;
	protected Image m_image;
	public String type;

	public Item (Cell c) { 
		this.cell = c;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Item a = (Item) arg0;
		return this.getName().equals(a.getName());
	}
	/**
	 * Method wich treats the use of an item by a character
	 * @param c the character which wants to use the item
	 */
	public abstract void usedBy(Agent c) ;
	public abstract String getName() ;
	public abstract int energyCost();

	public boolean isA(String string) {
		return this.type.equals(string);
	}
	public void render(Graphics2D pGraphics,int tileset) {
			pGraphics.drawImage(m_image, this.cell.getPos().getX()*tileset, this.cell.getPos().getY()*tileset, tileset, tileset, null);
	}
}
