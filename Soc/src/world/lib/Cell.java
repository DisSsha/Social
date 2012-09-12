package world.lib;

import ground.api.Ground;


import item.api.Item;
import item.lib.Iron;
import java.awt.Graphics2D;
import java.util.*;

import agents.api.Agent;
import direction.api.Direction;
import direction.lib.WindRose;
import environment.lib.Position;


public class Cell {
	protected Map<Direction, Cell> theNeighbours;
	public ArrayList<Item> theItems;
	protected ArrayList<Agent> theAgents;
	protected Ground ground ;
	protected static int cpt = 1 ;
	protected int id ;
	protected Position pos;
	public ArrayList<Building> theBuildings = new ArrayList<Building>();
	public Random random = new Random();
	/**
	 * default constructor
	 */
	public Cell() {
		this.id = this.cpt++ ;
		this.theNeighbours = new HashMap<Direction, Cell>();
		this.theAgents = new ArrayList<Agent>() ;
		this.theItems = new ArrayList<Item>() ;
		this.pos = new Position(-1,-1);
	}
	/**
	 * Method used to add a neighbour cell
	 * @param d the direction of the new cell
	 * @param c the new cell (neighbour)
	 */
	public void addNeighbour(Direction d, Cell c) {
		if (!this.theNeighbours.containsKey(d))
			this.theNeighbours.put(d, c) ;
	}
	/**
	 * Method wich return the map of neighbours
	 * @return
	 */
	public Map<Direction,Cell> getMapDirections() {
		return this.theNeighbours ;
	}
	/**
	 * Method used to know which are the possible directions (method used for moving)
	 * @return
	 */
	public List<Direction> getDirectionsPossibles() {
		List<Direction> theDirections = new ArrayList<Direction>() ;
		for(Direction it:this.theNeighbours.keySet()){
			theDirections.add(it) ;
		}
		return theDirections ;
	}
	/**
	 * set the cell's ground
	 * @param ground the ground
	 */
	public void setGround(Ground ground) {
		this.ground = ground ;
	}
	/**
	 * get the cell's ground
	 * @return the ground
	 */
	public Ground getGround() {
		return this.ground;
	}
	/**
	 * method used to know the characters present in the cell
	 * @return the list of characters
	 */
	public List<Agent> getAgents() {
		return this.theAgents;
	}
	/**
	 * method used to know the items present in the cell
	 * @return the list of items
	 */
	public List<Item> getItems() {
		return this.theItems;
	}
	/**
	 * put a character in the list of character
	 * @param character the character to add
	 */
	public void putAgent(Agent character) {
		this.theAgents.add(character);
	}
	/**
	 * remove a character of the list of characters
	 * @param character the character to remove
	 */
	public void removeAgent(Agent character) {
		this.theAgents.remove(character);
	}
	/**
	 * Attention utilise get 0;
	 * @return
	 */
	
	public void render(Graphics2D pGraphics,int tileset){
		this.ground.render(pGraphics,tileset,this.getPos().getX(),this.getPos().getY());
		//pGraphics.fillRect(this.pos.getX()*tileset, this.pos.getY()*tileset, tileset, tileset);
		if(!this.theBuildings.isEmpty()){
			this.theBuildings.get(0).render(pGraphics,tileset);
			return;
		}
		if(!this.theAgents.isEmpty()){
			this.theAgents.get(0).render(pGraphics,tileset);
			return;
		}
		if(!this.theItems.isEmpty()){
			this.theItems.get(0).render(pGraphics,tileset);
			return;
		}
	}
	
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return this.pos.toString();
	}
	public boolean contientNourriture(){
		for(Item it:this.theItems){
			if (it.isA("FOOD"))
				return true;
		}
		return false;
	}
	public boolean contientIron(){
		for(Item it:this.theItems){
			if (it instanceof Iron)
				return true;
		}
		return false;
	}

	public Direction vers(Cell c){
		int x1 = this.pos.getX();
		int y1 = this.pos.getY();
		int x2 = c.pos.getX();
		int y2 = c.pos.getY();
		if ((x1>x2)&&(y1>y2))//donc au sud et a l'est 
			return WindRose.NorthWest;
		if ((x1<x2)&&(y1<y2))//donc au nord et a l'ouest 
			return WindRose.SouthEast;
		if ((x1>x2)&&(y1<y2))//donc au sud et a l'ouest 
			return WindRose.NorthEast;
		if ((x1<x2)&&(y1>y2))//donc au sud et a l'est 
			return WindRose.SouthWest;
		if ((x1>x2)&&(y1==y2))//donc au sud 
			return WindRose.North;
		if ((x1<x2)&&(y1==y2))//donc au nord 
			return WindRose.South;
		if ((x1==x2)&&(y1<y2))//donc au sud et a l'ouest 
			return WindRose.East;
		if ((x1==x2)&&(y1>y2))//donc au sud et a l'est 
			return WindRose.West;
		return null;
	}
	public Cell proche(Cell c1,Cell c2){
		if (this.getPos().distance(c1.getPos())>this.getPos().distance(c2.getPos())){
			return c2;
		}
		else {
			return c1;
		}
	}
	public boolean buildingsAcceptItem(String s) {
		if (this.theBuildings.size() < 1)
			return false;
		for(Building b:this.theBuildings){
			if(b.accepted(s))
				return true;
		}
		return false;
	}
	
	public boolean equals(Cell o) {
		return o.pos.equals(this.pos);
	}

	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Cell) {
			return this.equals((Cell) o);
		}else{
			throw new ClassCastException(o+" should be a Cell");
		}
	}
	
	

}
