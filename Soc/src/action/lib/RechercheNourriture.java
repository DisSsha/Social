package action.lib;

import java.util.Random;
import agents.api.Agent;

public class RechercheNourriture extends AgentAction {

	public RechercheNourriture(Agent a){
		this.agent = a;
		this.name = "RechercheNourriture";
	}
	
	public boolean act() {
		this.agent.lastaction = this.getName();
		Random gen = new Random();
		int i = gen.nextInt(this.agent.nation.foodList.size());
		this.agent.getToCell=this.agent.nation.foodList.get(i);	
		this.agent.nation.foodList.remove(i);
		//System.out.println("je prends "+this.agent.getToCell);
		return true;
	}

	public int energyCost() {
		return 1;
	}

	public String getName() {
		return "RechercheNourriture";
	}

	public boolean isPossible() {
		return !this.agent.nation.foodList.isEmpty();
	}

}
