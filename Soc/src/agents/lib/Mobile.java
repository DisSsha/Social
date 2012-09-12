package agents.lib;

import world.lib.Cell;

public interface Mobile {

	/**
	 * method which permits to move to an other cell
	 * @param cell the new cell
	 */
	public void ChangeCurrentCell(Cell cell) ;
	
	
}
