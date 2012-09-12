package ground.lib;

import ihm.lib.Bitmaps;
import agents.api.Agent;
import ground.api.Ground;

public class Field extends Ground {
	
	public Field() {
		super();
		this.energyCost = 2 ;
		m_image = Bitmaps.listTiles[0];
	}
	
	public String toString(){
		return "Field";
	}

	public void EnergyCost(Agent agent) {
		agent.decreaseEnergy(this.energyCost) ;
	}


	public int getEnergyCost() {
		return this.energyCost ;
	}
	
	public boolean equals(Ground g) {
		return g.toString().equals(this.toString());
	}

	@Override
	public boolean traversable() {
		return true;
	}

}
