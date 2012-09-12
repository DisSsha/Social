package action.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import agents.api.*;
import choice.api.Choice;

/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * class Interact :
 * it permits to a character to interact with another one
 */
public class Interact extends AgentAction {

	protected static int cpt=0;
	protected String name;
	
	public Interact() {
		super() ;
		this.name = "Interac"+ cpt++;
	}
	/**
	 * @param character the character who is going to realize the action
	 */
	public Interact(Agent character) {
		super(character);
	}

	/** 
	 * the action is possible if there is another agent in the caracter's cell
	 */
	public boolean isPossible() {
		List<Agent> currentAgents = this.agent.getCell().getAgents() ;
		return (currentAgents.size() > 1) ;				
	}

	public boolean act() {
		/* we create a map of String,Agent */
		Map<String,Agent> thePersos = new HashMap<String,Agent>() ;
		/* we recover all the agents who are in the cell */
		List<Agent> agents = this.agent.getCell().getAgents() ;
		Iterator<Agent> it = agents.iterator();
		/* we fill in the map with these agents */
		while (it.hasNext()) {
			Agent suivant = it.next();
			thePersos.put(suivant.toString(), suivant);
		}
		/* we remove the agent who is going to realize the action because a agent can't interact with itself */
		thePersos.remove(this.agent.toString()) ;
		/* we recover the caracter's choice */
		Choice choix = this.agent.getChoice() ;
		/* we call the method choose of the selected choice wich permits to obtain the agent chosen */ 
		Agent agentChosen = choix.choose(thePersos) ;
		/* we call the method interact of the caracter wich permits to it to interact with the caracter chosen */
		this.agent.interact(agentChosen) ;
		/* if it's ok we return true */ 
		return true ;
	}
	public int energyCost() {
		return 0;
	}
	public String getName() {
		return this.name;
	}
	
}
