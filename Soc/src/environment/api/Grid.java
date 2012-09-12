
/**
 * Grid.java
 *
 *
 * Created: Mon Nov 05 09:04:06 2001
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package environment.api;

import java.awt.Graphics2D;


/** a Grid is an aera of width times height boxes. Each box can have a
  * specific color and a char to be displaid in it */
public interface Grid {

    /** returns the width of the grid
     * @return the width of the grid
     */
    public int getWidth();
    /** returns the height of the grid
     * @return the height of the grid
     */
    public int getLength();
    /** returns the color of the box at position<em>p</em>
     * @param p the position
     */
	public void render(Graphics2D g,int tileset);  

}// Grid
