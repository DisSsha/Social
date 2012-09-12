package action.lib;

import java.util.ArrayList;

import item.api.Item;
import item.lib.Pommes;
import agents.api.Agent;

public class Deposer extends AgentAction {

	public Deposer(Agent a){
		this.agent = a;
		this.name= "Deposer";
	}
	
	public boolean act() {
		this.agent.lastaction = this.getName();
		ArrayList<Item> ita = new ArrayList<Item>();
		int ii=0;
		for(Item i :this.agent.getInventory().getItems()){
			if(i.isA("FOOD")){
				Pommes foo = (Pommes) i;
				this.agent.nation.home.food+= foo.getQuantite();
				ita.add(i);
				ii++;
			}
		}
		for(Item id :ita){
			this.agent.getInventory().theItems.remove(id);
		}
		if(ii==1){
			this.agent.getToCell = null;
		}
		return true;
	}

	public int energyCost() {
		return 3;
	}

	public String getName() {
		return "Deposer";
	}

	public boolean isPossible() {
		for(Item i:this.agent.getInventory().theItems){
			if(this.agent.getCell().buildingsAcceptItem(i.type)){
				return true;
			}	
		}
		return false;
	}

}
