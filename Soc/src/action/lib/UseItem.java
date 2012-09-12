package action.lib;

import item.api.Item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import agents.api.Agent;

import choice.api.Choice;

/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * class UseItem :
 * it permits to a agent to use an item which is in the same cell
 */
public class UseItem extends AgentAction {

	
	protected static int cpt=0;
	protected String name;
	
	public UseItem() {
		super() ;
		this.name = "UseItem"+ cpt++;
	}
	/**
	 * @param agent the agent who is going to realize the action
	 */
	public UseItem(Agent agent) {
		super(agent);
	}

	/** 
	 * the action is possible if there is one item minimum in the caracter's inventory
	 */
	public boolean isPossible() {
		/* possible si le perso possède minimum 1 objet dans son inventaire */
		return (this.agent.getInventory().getItems().size() > 0) ;
	}
	
	/* (non-Javadoc)
	 * @see action.api.Action#act()
	 */
	public boolean act() {
		this.agent.lastaction = this.getName();
		/* we create a map of String,Item */
		Map<String,Item> theItems = new HashMap<String,Item>() ;
		/* we recover the agent's items */
		List<Item> agentItems = this.agent.getInventory().getItems() ;
		Iterator<Item> it = agentItems.iterator();
		/* we fill in the map with the items */
		while (it.hasNext()) {
			Item suivant = it.next();
			theItems.put(suivant.toString(), suivant);
		}
		/* we recover the caracter's choice */
		Choice choix = this.agent.getChoice() ;
		/* we call the method choose of the selected choice wich permits to obtain the item chosen */
		Item itemChosen = choix.choose(theItems) ;
		/* we call the method usedBy of the item chosen */
		itemChosen.usedBy(this.agent) ;
		/* the item is removed of the agent's inventory */
		this.agent.getInventory().removeItem(itemChosen) ;
		/* if it's ok we return true */ 
		return true ;
	}
	public int energyCost() {
		return 1;
	}
	public String getName() {
		return this.name;
	}
}
