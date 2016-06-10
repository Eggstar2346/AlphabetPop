import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
/**
 * Auto Generated Java Class.
 */
public class LevelAdvance extends JPanel{
  
private BufferedImage image;
  
          /**
 * This is the constructor that constructs the BufferedImage and checks where the user clicks so they can be directed 
 * to the corresponding page.  If the user clicks "Yes", the window is closed using a static method from the Main class.
 * If the user clicks "No", a static method from the Main class is used to bring the user to the menu.  This method 
 * also has a nested inner class.  MouseAdapter is used to see where the user has clicked.  A try catch block is used
 * to trap in case the image cannot be read in.  An if statement is used to determine where the user has clicked.
 * 
 * <p>
 * <b>Local variables: </b>
 * <p>
 * <b>xCoord </b> This int is used to know what the x-coordinate is of the location the user clicked.
 * <p>
 * <b>yCoord </b> This int is used to know what the y-coordinate is of the location the user clicked.
 */
  public LevelAdvance (int level)
  {
    System.out.println("YAS");
    try 
    {
      image = ImageIO.read(new File("LevelAdvance.jpg"));
      System.out.println("GOOD");
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    repaint();
    
    addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
      int xCoord = e.getX();
      int yCoord = e.getY();
      System.out.println(xCoord+ "      "+yCoord);
      if (yCoord>=277&&yCoord<=472)
      {
        if (xCoord>=175&&xCoord<=575)
        {
          System.out.println("mainmenu");
          Main.switchMenu(0);
        }
        else 
        {
          if (xCoord>=630&&xCoord<=1030)
          {
            System.out.println("nextlvl");
            Main.switchMenu(level);
          }
        }
      }
    }
});
  }
  
  
        /**
* This is the method that paints components on the frame.  It calls the super's paintComponent method, passing in
* g, and draws the image.
* 
* @param g Graphics passed in to allow painting on the frame.
*/ 
   public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.drawImage(image, 0, 0, null);
    System.out.println("YAY");
  }
  
}
