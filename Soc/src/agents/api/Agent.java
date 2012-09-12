package agents.api;

import action.api.Action;

import agents.lib.Forum;
import choice.api.Choice;
import choice.lib.RecoltChoice;
import choice.lib.RandomChoice;
import ihm.lib.Bitmaps;
import item.api.Inventory;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.*;


import world.lib.Cell;
import world.lib.Nation;
import world.lib.World2D;

/**
 * @author Julien Merl in 
 * June 2007
 * abstract class Agent :
 * a agent has a name, a health, a strength,a energy, a list of actions, a cell, 
 * an inventory, a choice and a gold bag
 */
public abstract class Agent {
	protected Image m_image;
	@Override
	public boolean equals(Object arg0) {
		Agent a = (Agent) arg0;
		return this.name.equals(a.name);
	}

	/* Agent maison*/
	protected Forum maison;
	/* Agent's name */
	protected String name ;
	
	/* Agent's health */
	protected int health ;
	
	/* Agent's strength */
	protected int strength ;
	
	/* Agent's energy */
	protected int energy ;
	
	/* Agent's list of actions */
	protected List<Action> actions ;

	/* Agent's cell */
	protected Cell cell ;

	/* Agent's inventory */
	protected Inventory inventory ;

	/* Agent's choice */
	protected Choice choice ;
	
	public int faim;
	
	/* Map of String,Action */
	protected Map<String, Action> mapActions;
	
	/*Color*/
	protected java.awt.Color color ;
	/* energy par tours */
	protected  int energymax;
	/* va etre supprimé*/
	public boolean die ;
	public Cell getToCell;
	public World2D world;
	public Nation nation;
	public int portee;
	public String lastaction;
	
	public static int id = 0;
	
	/**
	 * Default constructor
	 * we initialize the agent's health to 100 and the gold bag to 50
	 * a default value of strength is set to 20
	 * @param a 
	 */
	public Agent(Nation a) {
		this.actions = new ArrayList<Action>();
		this.mapActions = new HashMap<String, Action>();
		this.inventory = new Inventory() ;
		this.setHealth(100) ;
		this.strength = 20 ;
		this.energymax = 6;
		this.choice = new RandomChoice();
		this.name = id++ + "" ;
		this.faim = 500;
		this.lastaction = "";
		this.portee = 5;
		 m_image = Bitmaps.listCharacters[0];
	}
			
	/**
	 * get the agent's name
	 * @return the agent's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the agent's name
	 * @param name the agent's name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * increase the agent's strength
	 * @param strength the caracter's strength
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}	

	/**
	 * @return the caracter's health
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * @param health the caracter's health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @param health the caracter's health
	 */
	public void addHealth(int health) {
		this.health += health;
	}
	
	/**
	 * get the agent's strength
	 * @return the agent's strength
	 */
	public int getStrength() {
		return this.strength ;
	}
	
	/**
	 * set the agent's choice
	 * @param choice the agent's choice
	 */
	public void setChoice(Choice choice) {
		this.choice = choice ;
	}	

	/**
	 * get the agent's cell
	 * @return the agent's cell
	 */
	public Cell getCell() {
		return this.cell;
	}
	
	/**
	 * set the agent's cell
	 * @param cell the agent's cell
	 */
	public void setCell(Cell cell) {
		this.cell = cell ;
	}

	/**
	 * get the agent's inventory
	 * @return the agent's inventory
	 */
	public Inventory getInventory() {
		return this.inventory ;
	}

	/**
	 * add an action in the agent's list of actions
	 * @param action
	 */
	public void addAction(Action action) {
		this.actions.add(action);
		this.updateMapActions();
	}

	/**
	 * remove an action of the agent's list of actions
	 * @param action
	 */
	public void removeAction(Action action) {
		this.actions.remove(action);
	}

	/**
	 * update the map of the agent's actions
	 * if the action is possible, it is put in the map
	 */
	public void updateMapActions() {
		this.mapActions.clear() ;
		for(Action suivante : this.actions){
			if (suivante.isPossible()) {
				this.mapActions.put(suivante.getName(), suivante);	
			}
		}
	}

	/**
	 * methods used to realize an action
	 * @return true if the action has been realized
	 * else return false
	 */
	public boolean act() {
		this.updateEnergy();
		this.faim -= 1;
		boolean bool= true;
		this.updateMapActions() ;
		if(this.mapActions.size()==0){
			System.out.println("ALERTE ZERO ACTIONS ");
		}
		while((this.energy>1)&&(this.mapActions.size()>0)){
				//System.out.println(mapActions);
				Action actionChosed = this.choice.choose(mapActions);
				//System.out.println(actionChosed);
				bool = actionChosed.act();
				this.decreaseEnergy(actionChosed.energyCost());
				this.updateMapActions() ;
		}
		if(this.faim <= 0)
			this.die();
		return bool;
		
	}

	
	/**
	 * abstract method which permits the agent to interact with another agent
	 * @param c
	 */
	public abstract void interact(Agent c);
	
	/**
	 * get the agent's choice
	 * @return the agent's choice
	 */
	public Choice getChoice() {
		return this.choice ;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.name ;
	}

	public void decreaseEnergy(int energyCost) {
		this.energy -= energyCost;
		
	}

	public void decreaseHealth(int i) {
		this.health-=i;
	}

	public void addStrength(int i) {
		this.strength-=i;	
	}

	public void updateEnergy() {
		this.energy=this.energymax ;	
	}
	
	public java.awt.Color getColor() {
		return color;
	}

	public void setColor(java.awt.Color color) {
		this.color = color;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public Forum getMaison() {
		return maison;
	}

	public void setMaison(Forum maison) {
		this.maison = maison;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<Action> getActions() {
		return actions;
	}

	public boolean isDie() {
		return die;
	}


	public abstract void die();
	public abstract void clean();
	
	public int getFoodCost() {
		return 1;

	}

	public void render(Graphics2D pGraphics, int tileset) {
			pGraphics.drawImage(m_image, this.cell.getPos().getX()*tileset, this.cell.getPos().getY()*tileset, tileset, tileset, null);
	}
}
