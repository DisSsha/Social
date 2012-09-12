package action.lib;

import action.api.Action; 

import agents.api.Agent;

/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * Abstract class AgentAction :
 * this class implements the interface Action
 * it has a character in parameter witch permits to know the character who is going to realize the action
 */
public abstract class AgentAction implements Action  {

	/* the character who is going to realize the action */
	protected Agent agent;
	public String name;


	public AgentAction() {
		
	}
	/**
	 * @param character the character who is going to realize the action
	 */
	public AgentAction(Agent agent) {
		this.agent = agent;
	}
	
	public void setAgent (Agent c) {
		this.agent = c ;
	}
	
	public boolean equals(Object o){
		AgentAction aa = (AgentAction) o;
		return this.name.equals(aa.name);
	}
}
