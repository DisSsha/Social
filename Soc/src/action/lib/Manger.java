package action.lib;

import world.lib.Building;
import agents.api.Agent;

public class Manger extends AgentAction {

	public Manger(Agent a){
		this.agent = a;
		this.name = "Manger";
	}
	
	public boolean act() {
		this.agent.lastaction = this.getName();
		int i=0;
		while (this.agent.faim < 500 && i < this.agent.getCell().theBuildings.size()){
			Building b = this.agent.getCell().theBuildings.get(i);
			i++;
			if(b.food+this.agent.faim>500){
				b.food -= (500 - this.agent.faim);
				this.agent.faim = 500;
			}else{
				this.agent.faim += b.food;
				b.food = 0;
			}
		}
		return true;
	}

	public int energyCost() {
		return 1;
	}

	public String getName() {
		return "SeNourrir";
	}

	public boolean isPossible() {
		return (this.agent.faim < 50 && this.agent.nation.home.p==this.agent.getCell() && this.agent.getCell().theBuildings.size()>=1);
	}

}
