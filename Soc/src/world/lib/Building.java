package world.lib;


import java.awt.Color; 
import java.awt.Graphics2D;
import java.awt.Image;


public  abstract class Building {
	
	public String name;
	public int food;
	public Cell p;
	public Nation nation;
	protected Image m_image;
	protected java.awt.Color color ;
	
	public Building(Cell p, Nation a) {
		this.p = p;
		this.nation = a;
		this.color = new Color(102,102,0);
	}

	public void render(Graphics2D pGraphics,int tileset) {
			pGraphics.drawImage(m_image, this.p.pos.getX()*tileset, this.p.pos.getY()*tileset, tileset, tileset, null);
	}

	public abstract boolean accepted(String s);

	public boolean requierment(Nation n,World2D w) {
		return true;
	}
	

}
