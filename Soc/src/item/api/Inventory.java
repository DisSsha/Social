package item.api;




import item.lib.Pommes;
import item.lib.Iron;

import java.util.*;


/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * class Inventory :
 * a character has got an inventory where it puts all items he has collected 
 * an inventory is a list of items
 */
public class Inventory {
	
	/* List of items */
	public List<Item> theItems;
	protected int contientMax;
	/**
	 * default constructor
	 * with a creation of a new list of items
	 */
	public Inventory(){
		this.theItems= new ArrayList<Item>();
		this.contientMax = 1;
	}

	/**
	 * Method wich permits to get the list of items
	 * @return the list of items
	 */
	public List<Item> getItems() {
		return this.theItems;
	}

	/**
	 * Method wich permits to add an item
	 * @param item the item to add in the list
	 */
	public void addItem(Item item) {
		this.theItems.add(item) ;
	}
	
	public boolean contientNourriture(){
		for(Item it : this.theItems){
			if (it instanceof Pommes)
				return true;
		}
		return false;
	}
	public boolean contientIron(){
		for(Item it : this.theItems){
			if (it instanceof Iron)
				return true;
		}
		return false;
	}
	/**
	 * Method wich permits to remove an item
	 * @param item the item to remove
	 */
	public void removeItem(Item item) {
		ArrayList<Item> futur = new ArrayList<Item>();
		for(Item a : new ArrayList<Item>()){
			if (a.getName()!=item.getName()){
				futur.add(a);
			}
		}
		this.theItems = futur;
	}	
	public boolean isFull(){
		return this.contientMax<=this.theItems.size();
	}
	public void removeItem(){
		for(Item i : this.theItems){
			this.removeItem(i);
		}
	}

	public boolean isEmpty() {
		return this.theItems.size()==0;
	}
}

