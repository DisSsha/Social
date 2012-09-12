package world.lib;



import ground.api.Ground;
import ground.lib.Field;
import ground.lib.Lava;
import item.lib.Pommes;
import item.lib.Wood;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import agents.api.Agent;
import agents.lib.AgentBasic;
import agents.lib.Forum;
import direction.lib.*;
import environment.api.Grid;
import environment.lib.Position;


public class World2D implements Grid {

	public ArrayList<Building> AvaBuildings = new ArrayList<Building>();

	protected Cell[][] cell;
	
	protected int x;
	protected int width;
	
	protected int length;
	protected int y;
	
	public Random gen  = new Random();
	public ArrayList<Ground> grounds;
	
	public ArrayList<Nation> nations = new ArrayList<Nation>();

	public World2D(int x,int y,int nb_nations,int food, int populous,ArrayList<Ground> arg) {
		this.x = x;
		this.y = y;
		this.length = x;
		this.width = y;
		this.grounds = arg;
		this.create(x,y);
		this.tileWord();
		this.feed(food);
		this.select(nb_nations);
		this.populous(populous);
		System.out.println("they cry ! Muahaha ( :p )");
	}
	
	public Cell[][] getTheCells() {
		return this.cell;
	}
	
	public String toString() {
		return "World";
	}
	
	public void create(int x,int y) {
		System.out.println("Creating ...");
		this.cell = new Cell[this.x][this.y];
		for (int i = 0; i < this.x; i++) {
			for (int g = 0; g < this.y; g++) {
				Cell c = new Cell();
				c.setPos(new Position(i,g));
				this.cell[i][g] = c;
			}
		}
		this.setNeighbours();
	}
	
	public void tileWord(){
		for (int i = 0; i < this.x; i++) {
			for (int g = 0; g < this.y; g++) {
				int rand = new Random().nextInt(100);
				Ground gr;
				if(rand > 98)
					gr = new Lava();
				else
					gr = new Field();
				this.cell[i][g].ground = new Field();
			}
		}
	}
	
	public void feed(int food){
		System.out.println("And the light born ...");
		for(int gi=0;gi<food;gi++)
			this.dropFood();
	}
	
	public void select(int nb_nations){
		System.out.print("Selections ...");
		Random gen  = new Random();
		for(int i=0; i<nb_nations;i++){
			Nation a = new Nation(this);
			Cell p = this.getCell(new Position(gen.nextInt(x-1),gen.nextInt(y-1)));
			while (!p.ground.traversable()){
				p = this.getCell(new Position(gen.nextInt(x-1),gen.nextInt(y-1)));
			}
			Forum h = new Forum(p,a);
			a.setHome(h);
			p.theBuildings.add(h);
			this.nations.add(a);
		}
	}
		
	public void populous(int populous){
		System.out.print("Genesis ...");
		for(int i=0;i<populous;i++){
			for(Nation na: this.nations){
				addAgentToNation(na);
			}
		}
	}
	
	public void addAgentToNation(Nation n){
		Position p2 = new Position(gen.nextInt(x-1),gen.nextInt(y-1));
		new AgentBasic(n,p2,this);
	}
	
	public void setNeighbours() {
		System.out.println("Connecting ...");
		for(int i=0;i<this.width;i++){
			for(int j=0;j<this.length;j++){
				Position p = new Position(i,j);
				Cell c = this.getCell(p);				
				/** all the cells without the 4 headbands **/
				if ((i > 0) && (i < this.width - 1) && (j > 0) && (j < this.length - 1) ) {
					c.addNeighbour(WindRose.North, this.getCell(new Position((i - 1),j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position((i + 1),j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,j - 1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,j + 1))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(i - 1,j - 1))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(i - 1,j + 1))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(i + 1,j - 1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(i + 1,j + 1))) ;
				}
				/** the cell in top left **/
				if ((i == 0) && (j==0)) {
					c.addNeighbour(WindRose.North, this.getCell(new Position(this.width - 1,j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position((i + 1),j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,this.length - 1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,j + 1))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(this.width - 1,this.length - 1))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(this.width - 1,j + 1))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(i + 1,this.length - 1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(i + 1,j + 1))) ;
				}
				/** the cell in top right **/
				if ((i == 0) && (j == this.length - 1)) {
					c.addNeighbour(WindRose.North, this.getCell(new Position(this.width - 1,j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position((i + 1),j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,j - 1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,0))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(this.width - 1,j - 1))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(this.width - 1,0))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(i+1,j - 1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(i+1,0))) ;
				}
				/** the cell in bottom left **/
				if ((i == this.width - 1) && ( j == 0 )) {
					c.addNeighbour(WindRose.North, this.getCell(new Position(i - 1,j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position(0,j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,this.length - 1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,j + 1))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(i - 1,this.length - 1))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(i - 1,j + 1))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(0,this.length - 1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(0,j + 1))) ;
				}
				/** the cell in bottom right **/
				if ((i == this.width - 1) && (j == this.length - 1)) {
					c.addNeighbour(WindRose.North, this.getCell(new Position(i - 1,j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position(0,j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,j - 1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,0))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(i - 1,j))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(i - 1,0))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(0,j - 1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(0,0))) ;
				}
				/** the north headband without extremities **/
				if ((i == 0) && (j > 0) && (j < this.length - 1)) {
					c.addNeighbour(WindRose.North, this.getCell(new Position(this.width - 1,j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position((i+1),j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,j-1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,j+1))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(this.width - 1,j-1))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(this.width - 1,j+1))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(i+1,j-1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(i+1,j+1))) ;
				}
				/** the south headband without extremities **/
				if ((i == this.width-1) && (j > 0) && (j < this.length - 1)){
					c.addNeighbour(WindRose.North, this.getCell(new Position((i-1),j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position(0,j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,j-1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,j+1))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(i-1,j-1))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(i-1,j+1))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(0,j-1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(0,j+1))) ;
				}
				/** the west headband without extremities **/
				if((i > 0) && (i < this.width - 1) && (j==0)){
					c.addNeighbour(WindRose.North, this.getCell(new Position((i-1),j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position((i+1),j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,this.length - 1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,j+1))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(i-1,this.length - 1))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(i-1,j+1))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(i+1,this.length - 1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(i+1,j+1))) ;
				}
				/** the east headband without extremities **/
				if((i > 0) && (i < this.width - 1) && (j==this.length - 1)){
					c.addNeighbour(WindRose.North, this.getCell(new Position((i-1),j))) ;
					c.addNeighbour(WindRose.South, this.getCell(new Position((i+1),j))) ;
					c.addNeighbour(WindRose.West, this.getCell(new Position(i,j-1)));
					c.addNeighbour(WindRose.East, this.getCell(new Position(i,0))) ;
					c.addNeighbour(WindRose.NorthWest, this.getCell(new Position(i-1,j-1))) ;
					c.addNeighbour(WindRose.NorthEast, this.getCell(new Position(i-1,0))) ;
					c.addNeighbour(WindRose.SouthWest, this.getCell(new Position(i+1,j-1))) ;
					c.addNeighbour(WindRose.SouthEast, this.getCell(new Position(i+1,0))) ;
				}
			}
		}
	}	
	
	public Cell getCell(Position p){
		return this.cell[p.getX()][p.getY()];
	}

	public void update() {
		this.killingDeaths();
	}

	public void killingDeaths(){
		for (Nation na: this.nations){
			List<Agent> tokill = new ArrayList<Agent>();
			for (Agent a:na.agents){
				if (a.isDie()){
					tokill.add(a);
				}
			}
			for (Agent k: tokill){
				k.clean();
				na.agents.remove(k);
			}
		}
	}
	
	public Nation getNation(Nation a) {
		return this.nations.get(this.nations.indexOf(a));
	}

	@Override
	public int getWidth() {
		return this.y;
	}

	@Override
	public int getLength() {
		return this.x; 
	}
	

	public void dropFood() {
		Cell c = this.getCell(new Position(gen.nextInt(x-1),gen.nextInt(y-1)));
		while (!c.ground.traversable()){
			c = this.getCell(new Position(gen.nextInt(x-1),gen.nextInt(y-1)));
		}
		c.theItems.add(new Pommes(c));
	}

	public void executeOneCycle() {
		ArrayList<Nation> toRemove = new ArrayList<Nation>();
		for (Nation na: this.nations){
			for (Agent a:na.agents){
				a.act();
			}
			if(na.agents.size()==0){
				na.home.p.theBuildings.remove(na.home); 
				na.home=null;
				toRemove.add(na);
			}
		}
		for(Nation na : toRemove){
			this.nations.remove(na);
		}
	}

	@Override
	public void render(Graphics2D graph,int tileset) {
		for (int i = 0; i < this.x; i++) {
			for (int g = 0; g < this.y; g++) {
				Cell c = this.cell[i][g];
				c.render(graph,tileset);
			}
		}
	}

	public void dropWood() {
		Cell c = this.getCell(new Position(gen.nextInt(x-1),gen.nextInt(y-1)));
		while (!c.ground.traversable()){
			c = this.getCell(new Position(gen.nextInt(x-1),gen.nextInt(y-1)));
		}
		c.theItems.add(new Wood(c));
	}
	
}
