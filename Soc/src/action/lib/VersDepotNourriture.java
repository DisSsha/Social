package action.lib;

import agents.api.Agent;
import agents.lib.AgentBasic;

public class VersDepotNourriture extends AgentAction {

	public VersDepotNourriture(Agent a){
		this.agent = a;
		this.name = "VersDepotNourriture";
	}
	
	public boolean act() {
		this.agent.lastaction = this.getName();
		this.agent.getToCell = this.agent.nation.home.p;
		return true;
	}

	public int energyCost() {
		return 1;
	}

	public String getName() {
		return "VersDepotNourriture";
	}

	public boolean isPossible() {
		AgentBasic a = (AgentBasic) this.agent;
		if(a.getCell().equals(a.nation.home.p))
			return false;
		if(a.getInventory().isFull())
			return true;
		if(a.getInventory().isEmpty())
			return false;
		return true;
	}

}
