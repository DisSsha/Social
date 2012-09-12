package environment.lib;

import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;

import world.lib.Cell;
import world.lib.Nation;
import world.lib.World2D;
import ground.api.Ground;
import ihm.api.GridDisplayer;
import ihm.lib.Gaphical2DImageDisplayer;
import ihm.lib.Info;
import agents.api.*;

public class GameOfLife {

	protected World2D environment; // l'environnement torique
	protected Gaphical2DImageDisplayer displayer; // pour l'affichage 
	protected Info info;
	public Random random = new Random();
	public int tileset;
	
	public GameOfLife (int x,int y,int nb_nations,int populous,int food,ArrayList<Ground> arg,int tileset) {
		this.environment = new World2D(x,y,nb_nations,food, populous,arg);
		this.displayer = new Gaphical2DImageDisplayer(x*tileset, y*tileset);
		this.info = new Info();
		this.info.setVisible(true);
		this.info.setLocation(x, y);		
		this.tileset = tileset;
	}
	
	public void execute() {

		int Tours=0;		
		int FOOD_TOUS_LES_N_T = 8;
		int TOUR_EXPLO = 200;
		boolean NO_EXPLORER = true;
		int TOUR_AVANT_NAISSANCES = 100;
		int NAISSANCES_TOUS_LES_X_TOURS = 100;
		
		for(;;){	
			Tours++;
			
			this.displayer.display(this.environment,this.tileset, Tours+"");		
			if (Tours%FOOD_TOUS_LES_N_T== 0){
					this.environment.dropFood();
					this.environment.dropWood();
			}
			this.executeOneCycle();  
			this.environment.update();
			String s="<html>";
			for(Nation n:this.environment.nations){
				s+=n+" :"+n.agents.size()+" Nourriture: "+n.home.food+"<br/>";
				if((Tours%TOUR_EXPLO ==0) && NO_EXPLORER){
					this.addExplorer(n);
					NO_EXPLORER = false;
				}
				ArrayList<Cell> todel = new ArrayList<Cell>();
				for(Cell c:n.foodList){
					Boolean donne= false;
					for(Agent aa: n.agents){
						if((donne==false) && (!aa.getCell().contientNourriture()) && (aa.getInventory().isEmpty())){
							aa.getToCell = c;
							donne=true;
							todel.add(c);
						}
					}
				}
				for(Cell c:todel){
					n.foodList.remove(c);
				}
				if((n.home.food > n.agents.size()*200) && (Tours > TOUR_AVANT_NAISSANCES) && (Tours%NAISSANCES_TOUS_LES_X_TOURS==0)){
					this.environment.addAgentToNation(n);
				}
			}
			s+="</html>";
			this.info.setTexte(s);
		      try
		      {
		        Thread.sleep(50);
		      }
		      catch (Exception e)
		      {
		      }
		}
	}

	private void executeOneCycle() {
		this.environment.executeOneCycle();
	}
	/**
	 * make things in place
	 */

	public void addExplorer(Nation n){
		if(!n.agents.isEmpty()){
			n.agents.get(0).portee = 20;
			System.out.println("Ajout d'un Explorateur ! a "+n );
		}
	
	}
	
	public GridDisplayer getDisplayer() {
		return displayer;
	}
	public World2D getEnvironment() {
		return environment;
	}
	public void setEnvironment(World2D environment) {
		this.environment = environment;
	}
}