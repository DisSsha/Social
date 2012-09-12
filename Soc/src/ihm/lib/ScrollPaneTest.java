package ihm.lib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
 
 
/**
 * Cette classe ouvre une fenêtre (JFrame), dans laquelle se trouve un
 * JScrollPane qui permet de faire défiler un panneau personnalisé.
 */
public class ScrollPaneTest extends JFrame {
    private static final long serialVersionUID = 2859468497265768263L;
 
    public ScrollPaneTest() {
        super("Test ScrollPane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
        setLayout(new BorderLayout());
        add(new JScrollPane(new Panneau()), BorderLayout.CENTER);
         
        setPreferredSize(new Dimension(800, 600));
        pack();
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ScrollPaneTest();
                frame.setVisible(true);
            }
        });
    }
}
 
/**
 * Panneau personnalisé d'une taille arbitraire,
 * qui se contente d'afficher un "motif"
 */
class Panneau extends JPanel {
    private static final long serialVersionUID = -3373703143308676581L;
 
    public Panneau() {
        // taille arbitraire
        setPreferredSize(new Dimension(2000, 1000));
    }
 
    /**
     * Affichage du motif. Cela consiste à afficher les coordonnées de points
     * régulièrement répartis sur le panneau.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for(int x=0; x<getWidth(); x+=100)
            for(int y=0; y<getHeight(); y+=50)
                g.drawString(
                        "(" + x + ", " + y + ")", 
                        x, y + g.getFontMetrics().getHeight());
    }
}