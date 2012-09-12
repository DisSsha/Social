
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
public class CopyOfGaphical2DImageDisplayersaved extends Canvas implements GridDisplayer{
	
	private BufferStrategy m_bufferStrategy;
	JFrame frame = new JFrame();
	JPanel  panel = new JPanel();
	  
	public CopyOfGaphical2DImageDisplayersaved(int width, int height) {
		setIgnoreRepaint(true);
		this.setSize(width, height);
	    
		panel.setPreferredSize(new Dimension(width, height));
	    panel.setLayout(new BorderLayout());
        panel.add(this);
	    
	    JScrollPane scroller = new JScrollPane(panel);
        scroller.setPreferredSize(new Dimension(300,200));
        scroller.getViewport().add(panel);
        this.frame.add(scroller, BorderLayout.CENTER);
        
        
        this.frame.setContentPane(scroller);
	    this.frame.pack();
	    this.frame.setVisible(true);
	    //this.frame.setLocationRelativeTo(null);
	    this.frame.addWindowListener(new WindowAdapter()
	    {
	      public void windowClosing(WindowEvent e)
	      {
	        System.exit(0);
	      }
	    });

	    this.frame.requestFocus();
		
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
