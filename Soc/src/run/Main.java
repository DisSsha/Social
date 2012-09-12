package run;

import ihm.lib.Bitmaps;

import java.io.IOException;
import java.util.ArrayList;

import environment.lib.GameOfLife;
import ground.api.Ground;
import ground.lib.Field;
import ground.lib.Lava;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Bitmaps.loadAll();	
		int food = 10; 
		int nb_nations= 3;
		int populous=4;
		int x = 200;
		int y = 200;
		int tileset = 8;
		ArrayList<Ground> arg = new ArrayList<Ground>();
		arg.add(new Field());;
		arg.add(new Lava());
		GameOfLife gof = new GameOfLife(x,y,nb_nations,populous,food,arg,tileset);	
		gof.execute();
	}

}