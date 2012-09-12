package world.lib;

import java.util.ArrayList;

import agents.api.*;
	
public class Nation {
	
	public Building home;
	public World2D world;
	protected static int cpt=0;
	public ArrayList<Agent> agents = new ArrayList<Agent>();
	public String name;
	public ArrayList<Cell> foodList = new ArrayList<Cell>();
	
	
	public void setHome(Building b){
		this.home = b;
		this.name = "Nation"+cpt++;
	}

	public int getFood() {
		return this.home.food;
	}
	
	public Nation(World2D w){
		this.world = w;
	}
	
	@Override
	public String toString(){
		return this.name;
	}

	public void Strategy(){
		ArrayList<Building> BuildingQueue = new ArrayList<Building>();
		ArrayList<Building> BuildAvailables = new ArrayList<Building>();
		for(Building b : this.world.AvaBuildings){
			if(b.requierment(this,this.world))
				BuildAvailables.add(b);
		}
		
		//Creer une BuildList
			//Lister les 
		//Réagencer les travailleurs --> Priorité
		//Dans les batiments ou c'est possible, payer une MAJ
		//Contacter les autres Nations.
	}
	@Override
	public boolean equals(Object arg0) {
		Nation a = (Nation) arg0;
		return this.name.equals(a.name);
	}
}