package action.api;

/**
 * @author Fabien Daste & Julien Merlin S6 Info groupe 2
 * Mai 2007
 * 
 * Interface Action :
 * The characters have their actions
 * To be executed, an action must be possible 
 */

public interface Action {
	

	/**
	 * @return true if the action is possible
	 * else return false
	 */
	public boolean isPossible() ;	
	/**
	 * @return true if the action has been executed
	 * else return false
	 */
	public boolean act();
		
	public int energyCost();
	
	public String getName();
	
	@Override
	public boolean equals(Object o);
}
