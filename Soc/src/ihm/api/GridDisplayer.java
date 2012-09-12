
/**
 * GridDisplayer.java
 *
 *
 * Created: Mon Nov 05 09:27:30 2001
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package ihm.api;

import environment.api.Grid;

/** interface of a displayer of a Grid object
 */
public interface GridDisplayer {
    /** displays the grid
     * @param grid the grid to be displaid
     * @param msg a msg 
     */
    public void display(Grid grid, int tileset,String msg);
}// GridDisplayer
