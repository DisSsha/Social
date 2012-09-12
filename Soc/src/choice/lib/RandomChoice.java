package choice.lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import agents.api.Agent;

import choice.api.Choice;



/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * class RandomChoice :
 * this class is an implementation of a Choice
 * it permits to choose randomly a "choice" present in the possible choices
 * 
 */
public class RandomChoice implements Choice {

	/**
	 * Method wich realize a random choice
	 * we create an array containing the map (got in parameter) values
	 * we set randomly an index of this array between 0 and the array length
	 * we return the corresponding value
	 */
	public <T> T choose(Map<String, T> choixPossible) {
		ArrayList<String> choix = new ArrayList<String>(choixPossible.size());
		Iterator<String> it = choixPossible.keySet().iterator();
		while (it.hasNext()){
			choix.add(it.next());
		}
		Random gen = new Random();
			String res = choix.get(gen.nextInt(choix.size()));
		return choixPossible.get(res);
		}
}
