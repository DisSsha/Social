
/**
 * Position.java
 *
 *
 * Created: Fri Nov 02 15:40:51 2001
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package environment.lib;

/**
 * a position in a grid
 */
public class Position{
	
	private int x;
	private int y;
	
	public Position (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return  the x
	 * @uml.property  name="x"
	 */
	public int getX() { return x; }
	/**
	 * @return  the y
	 * @uml.property  name="y"
	 */
	public int getY() { return y; }
	
//	public int hashCode(){
//		return (1000*this.x+this.y);
//	}
	/** returns one of 8 neighbours of this position assuming environment is a tore
	 * @param width width of environment
	 * @param hieght height of environment
	 */
	public Position randomNeighbour(int width, int height) {
		int dx = 0;
		int dy =0;
		do {
			dx = (((int) (Math.random()*1000)) % 3) - 1 ;
			dy = (((int) (Math.random()*1000)) % 3) - 1;
		} while (dx == 0 && dy == 0);	
		return new Position((width+x+dx)%width,(height+y+dy)%height);
	}
	
	public boolean equals(Position p) {
		return (this.x == p.getX()) && (this.y == p.getY());
	}
	
	public boolean equals(Object o) {
		if (o instanceof Position) {
			return this.equals((Position) o);
		}
		else {
			throw new ClassCastException(o+" should be a Position");
		}
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
	public int distance(Position p){
		return (Math.abs(p.getX()-this.getX())+Math.abs(p.getY()-this.getY()));
	}
}
