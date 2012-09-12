package choice.lib;

import java.util.Map;

import action.api.Action;
import agents.api.Agent;

import choice.api.Choice;



/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * class RandomChoice :
 * this class is an implementation of a Choice
 * it permits to choose randomly a "choice" present in the possible choices
 * 
 */
public class RecoltChoice implements Choice {
	
	public Agent agent ;

	public RecoltChoice(Agent a){
		this.agent = a;
	}
	
	/**
	 * Method wich realize a random choice
	 * we create an array containing the map (got in parameter) values
	 * we set randomly an index of this array between 0 and the array length
	 * we return the corresponding value
	 */
	public <T> T choose(Map<String, T> choixPossible) {
		String todo = "GLOBAL";
		if (this.agent.getCell().buildingsAcceptItem("FOOD")&&this.agent.getInventory().contientNourriture()){// sur un dépot
			todo = "Deposer";// je vide
			return choixPossible.get(todo);
		}
		
		if (this.agent.getToCell == null) {
			if (this.agent.getCell().contientNourriture()){
				todo = "Recolter";
				this.agent.getToCell = this.agent.getCell();
				return choixPossible.get(todo);
			}
			if (!this.agent.nation.foodList.isEmpty()){
				todo = "RechercheNourriture";
				return choixPossible.get(todo);
			}
			if (this.agent.lastaction.equals("Explorer")) {
					todo = "Move";
					return choixPossible.get(todo);
			}
			todo = "Explorer";
			return choixPossible.get(todo);
		}
		
		if (!this.agent.getToCell.equals(this.agent.getCell())) {
			todo = "Move";
			return choixPossible.get(todo);
		}
		
		if (this.agent.getInventory().isFull()) {
			todo = "VersDepotNourriture";
			return choixPossible.get(todo);
		}
		
		if (this.agent.getCell().contientNourriture()){
			todo = "Recolter";
			return choixPossible.get(todo);
		}
		this.agent.getToCell=null;
		if (!this.agent.nation.foodList.isEmpty()){
			todo = "RechercheNourriture";
			return choixPossible.get(todo);
		}
		if (this.agent.lastaction.equals("Explorer")) {
				todo = "Move";
				return choixPossible.get(todo);
		}else{
			todo = "Explorer";
		}
		return choixPossible.get(todo);
	}
}
