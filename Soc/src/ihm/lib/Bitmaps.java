package ihm.lib;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Contient la liste des bitmaps
 */
public class Bitmaps{
	/** Les images de maisons */
  public static BufferedImage[] listHouses;
  public static BufferedImage[] listItems;
  public static BufferedImage[] listCharacters;
  public static BufferedImage[] listTiles;
  
  /**
   * 
   * Constructeur
   */
  public Bitmaps(){}
  
  /**
   * Lance le chargement des images
   */ 
  public static void loadAll() throws IOException{
    Image sheet;
    
    // Charge les maisons
    listHouses = new BufferedImage[1];
    sheet = ImageIO.read(Bitmaps.class.getResourceAsStream("/tiles/Houses.png"));
    listHouses[0] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    Graphics g = listHouses[0].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 0, 0, 32, 32, null);
    g.dispose();
    
    // Charge les Personnages
    listCharacters = new BufferedImage[1];
    sheet = ImageIO.read(Bitmaps.class.getResourceAsStream("/tiles/characters.png"));
    listCharacters[0] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listCharacters[0].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 0, 0, 32, 32, null);
    g.dispose();

    
    // Charge les Items
    listItems = new BufferedImage[2];
    sheet = ImageIO.read(Bitmaps.class.getResourceAsStream("/tiles/items.png"));
    listItems[0] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listItems[0].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 0, 0, 32, 32, null);
    g.dispose();
    listItems[1] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listItems[1].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 32, 0, 64, 32, null);
    g.dispose();
    
    
    // Charge les grounds
    listTiles = new BufferedImage[7];
    sheet = ImageIO.read(Bitmaps.class.getResourceAsStream("/tiles/grounds.png"));
    listTiles[0] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listTiles[0].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 0, 32, 32, 64, null);//Herbes
    g.dispose();
    listTiles[1] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listTiles[1].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 32, 32, 64, 64, null);//Herbes
    g.dispose();
    listTiles[2] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listTiles[2].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 64, 32, 96, 64, null);//Herbes
    g.dispose();
    listTiles[3] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listTiles[3].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 192,96,224, 128, null);//Lave 1
    g.dispose();
    listTiles[4] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listTiles[4].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 224,196,256, 128, null);//Lave 2
    g.dispose();
    listTiles[5] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
    g = listTiles[5].getGraphics();
    g.drawImage(sheet, 0, 0, 32, 32, 256,96,288, 128, null);//Lave 3
    g.dispose();
  }
}

