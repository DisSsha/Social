package action.lib;




import item.api.Item;
import java.util.ArrayList;
import agents.api.Agent;

public class Recolter extends AgentAction {
	
	public Recolter(Agent a){
		this.agent = a;
		this.name = "Recolter";
	}
	
	public boolean act() {	
		this.agent.lastaction = this.getName();
		while (this.agent.getCell().contientNourriture() && !this.agent.getInventory().isFull()){
			ArrayList<Item> ita = new ArrayList<Item>();
			for(Item suivant : this.agent.getCell().getItems()){
				if (suivant.isA("FOOD")){
					this.agent.getInventory().addItem(suivant);
					ita.add(suivant);
				}
			}
			for(Item i:ita){
				this.agent.getCell().theItems.remove(i) ;
			}
		}
		return true;
	}

	public int energyCost() {
		return 6;
	}

	public String getName() {
		return this.name;
	}

	public boolean isPossible() {
		if(this.agent.getInventory().isFull()) {
			return false;
		}if(this.agent.getCell().contientNourriture()){
			return true;
		}
		return false;
	}

}
