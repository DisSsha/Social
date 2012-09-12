
/**
 * GraphicalGridDisplayer.java
 *
 *
 * Created: Mon Nov 05 09:29:47 2001
 *
 * @author <a href="mailto:routier@lifl.fr">Jean-Christophe Routier</a>
 * @version
 */
package ihm.lib;

import ihm.api.GridDisplayer;



import javax.swing.*;

import environment.api.Grid;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

/** display a grid in a JFrame
 */
public class Gaphical2DImageDisplayer extends Canvas implements GridDisplayer{
	
	private BufferStrategy m_bufferStrategy;
	JFrame frame = new JFrame();
	JPanel  panel = new JPanel();
	  
	public Gaphical2DImageDisplayer(int width, int height) {
		
	//	setIgnoreRepaint(true);
		this.setSize(width, height);
	    
		BorderLayout BL = new BorderLayout();
		panel.setPreferredSize(new Dimension(3000, 3000));
	    panel.setLayout(BL);
        panel.add(this);
        
        this.frame.setLayout(BL);
        this.frame.add(new JScrollPane(panel), BorderLayout.CENTER);
        this.frame.setPreferredSize(new Dimension(600,400));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    this.frame.pack();
	    this.frame.setVisible(true);
	}	
	
	/**
	   * Override addNotify() pour récupérer le BufferStrategy
	   */
	  public void addNotify(){
	    super.addNotify();
	    createBufferStrategy(2);
	    m_bufferStrategy = getBufferStrategy();
	  }

	public void display(Grid World2D, int tileset,String msg) {
		this.frame.setTitle(msg);
	    Graphics2D g = (Graphics2D) m_bufferStrategy.getDrawGraphics();
	    g.setColor(Color.WHITE);
	    g.fillRect(0, 0, getWidth(), getHeight());
	    World2D.render(g,tileset);
	    g.dispose();
	    m_bufferStrategy.show();
	    Toolkit.getDefaultToolkit().sync();
	}	
}
