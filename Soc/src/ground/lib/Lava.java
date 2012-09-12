package ground.lib;

import ihm.lib.Bitmaps;

import java.util.Random;

import agents.api.Agent;
import ground.api.Ground;

public class Lava extends Ground {

	/* the cost of crossing the ground */
	protected int energyCost ; 
	
	public Lava() {
		super();
		this.energyCost = 6 ;
		m_image = Bitmaps.listTiles[3];
	}
	
	public String toString(){
		return "Lava";
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
		return false;
	}

}
