import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
/** The LevelAdvance class loads the level advance image and displays it on the screen.   It allows the user to select
 * whether they would like to advance or go to the menu.
 *
 * 
 * <p>
 * <b> Version Information: </b>
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1
 * <b>Date</b> 06.08.16
 * <b>Time Spent</b> 20 minutes
 * 
 * 
 * <p>
 * <b> Instance Variables: </b>
 * <p>
 * <b>image</b> This creates an instance of a BufferedImage that is used to display the message asking the user if they
 * would like to exit.
 * 
 * @author Samantha Unger
 * @version 1 06.08.16
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
 * 
 * @param level int that represents the level
 */
  public LevelAdvance (int level)
  {
    try 
    {
      image = ImageIO.read(new File(".//resources//LevelAdvance.jpg"));
    } 
    catch (IOException e) 
    {
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
          Main.switchMenu(0);
        }
        else 
        {
          if (xCoord>=630&&xCoord<=1030)
          {
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
  }
  
}
