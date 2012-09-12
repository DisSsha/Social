package agents.lib;

import choice.lib.RecoltChoice;
import choice.lib.RandomChoice;

import environment.lib.Position;
import world.lib.Cell;
import world.lib.Nation;
import world.lib.World2D;
import action.lib.*;
import agents.api.Agent;
/**
 * @author Julien Merlin 
 * June 2007
 * Agent Basic :
 * He can't fly but it's the first developpment state we need some food !!
 */
public class AgentBasic extends Agent implements Mobile{

	protected static int cpt=0;
	
	public AgentBasic(Nation a, Position p, World2D World) {
		super(a);
		this.name = "agent Basic "+cpt++;
		this.choice = new RecoltChoice(this);
		this.world = World;
		this.world.getCell(p).putAgent(this);
		this.cell = this.world.getCell(p);
		this.nation = a;
		this.nation.agents.add(this);
		this.addAction(new Move(this));
		this.addAction(new Recolter(this));
		this.addAction(new RechercheNourriture(this));
		this.addAction(new VersDepotNourriture(this));
		this.addAction(new Deposer(this));
		this.addAction(new Manger(this));
		this.addAction(new Explorer(this));
		
	}
	
	@Override
	public void interact(Agent c) {
		// TODO Auto-generated method stub
		
	}
	
	public void ChangeCurrentCell(Cell cell) {
		this.cell.removeAgent(this) ;
		cell.putAgent(this) ;		
		this.setCell(cell);
	}

	@Override
	public void die() {
		this.setEnergy(0);
		this.die=true;
	}
	
	public void clean(){
		this.cell.getAgents().remove(this);
		this.nation.agents.remove(this);
		this.cell=null;
	}

}
