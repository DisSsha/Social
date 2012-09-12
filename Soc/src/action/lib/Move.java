package action.lib;


import java.util.Random;

import direction.api.Direction;
import agents.api.Agent;
import world.lib.Cell;
import agents.lib.Mobile;

public class Move extends AgentAction {

	protected String name;
	public boolean random;
	
	/**
	 * @param agent the agent who is going to realize the action
	 */
	public Move(Agent agent) {
		super(agent);
		this.name = "Move";
	}

	/** 
	 * the action is possible if the agent is mobile and has enough energy to move (there is a cost of energy implied by the cell)
	 */
	public boolean isPossible() {
		if(!(this.agent instanceof Mobile))
			return false;
		if ((this.agent.getCell().getGround().energyCost > this.agent.getEnergy()))
			return false;
		return true;
	}

	public boolean act() {
		this.agent.lastaction = "Move";
		Direction d;
		Random r = new Random();
		if (this.agent.getToCell==null){
			d = this.agent.getCell().getDirectionsPossibles().get(r.nextInt(this.agent.getCell().getDirectionsPossibles().size()));
		}else{
			d= this.agent.getCell().vers(this.agent.getToCell);
			if (d==null){
				System.out.println("Direction Nulle move"+this.agent.getToCell+ " "+this.agent.getCell());
			}
		}
		Cell newCell = this.agent.getCell().getMapDirections().get(d);
		int i=0;
		while (newCell.getGround().traversable()==false && i<10){
			i++;
			d = this.agent.getCell().getDirectionsPossibles().get(r.nextInt(this.agent.getCell().getDirectionsPossibles().size()));
			newCell = this.agent.getCell().getMapDirections().get(d);
		}
		((Mobile)this.agent).ChangeCurrentCell(newCell) ;
		return true ;
	}
	public int energyCost() {
		return this.agent.getCell().getGround().energyCost;
	}
	public String getName() {
		return this.name;
	}
}
