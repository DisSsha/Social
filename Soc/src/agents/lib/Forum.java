package agents.lib;



import ihm.lib.Bitmaps;
import world.lib.Building;
import world.lib.Cell;
import world.lib.Nation;

public class Forum extends Building{
	
	public static int cpt=0;
	public Nation nation;
	public int iron;
	
	public Forum(Cell c, Nation a){
		super(c,a);
		this.name = "Forum"+cpt++;
		this.food = 1000;
		this.iron = 0; 
		m_image = Bitmaps.listHouses[0];
	}

	@Override
	public boolean accepted(String s) {
		if(s.equals("FOOD")){
			return true;
		}
		if(s.equals("WOOD")){
			return true;
		}
		return false;
	}
}
