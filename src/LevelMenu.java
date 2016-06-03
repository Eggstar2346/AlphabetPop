import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/* The LevelMenu class loads the Levels image and displays it on the screen.   It allows the user to select
 * which level of the game they would like to go to and takes them there.
 * 
 * 
 * <p>
 * <b> Version Information: </b>
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1
 * <b>Date</b> 06.01.16
 * <b>Time Spent</b> 1 hour
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1.1
 * <b>Date</b> 06.02.16
 * <b>Time Spent</b> 1 hour
 * <b>What Was Changed</b> The constructor is now coded to use the static method found within the Main class.  
 * Unnecessary methods related to detecting the mouse location were also removed, along with a "choice" variable that
 * indicated where the user clicked.
 * 
 * 
 * <p>
 * <b> Instance Variables: </b>
 * <p>
 * <b>menu</b> This creates an instance of a BufferedImage that is used to display the level selection menu.
 * 
 * 
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1 05.19.16
 */

public class LevelMenu extends JPanel
{
  private BufferedImage menu;
  
 /**
 * This is the constructor that constructs the BufferedImage and checks where the user clicks so they can be directed 
 * to the corresponding page.  Based on what the user clicks, a different value is passed into a static method from
 * the Main class.  This method also has a nested inner class.  MouseAdapter is used to see where the user has clicked.  
 * A try catch block is used to trap in case the image cannot be read in.  An if statement is used to determine where
 * the user has clicked.
 * 
 * <p>
 * <b>Local variables: </b>
 * <p>
 * <b>xCoord </b> This int is used to know what the x-coordinate is of the location the user clicked.
 * <p>
 * <b>yCoord </b> This int is used to know what the y-coordinate is of the location the user clicked.
 */
  public LevelMenu ()
  {
    System.out.println("YAS");
    try 
    {
      menu = ImageIO.read(new File("Levels.jpg"));
      System.out.println("GOOD");
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    repaint();
    
    addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
      int xCoord = e.getX();
      int yCoord = e.getY();
      System.out.println(xCoord+ "      "+yCoord);
      if (xCoord>=217&&xCoord<=1016)
      {
        if (yCoord>=162&&yCoord<=211)
        {
          System.out.println("Level One");
          Main.switchMenu(1);
        }
        else if (yCoord>=260&&yCoord<=309)
        {
          System.out.println("Level Two");
          Main.switchMenu(2);
        } 
        else if (yCoord>=363&&yCoord<=412)
        {
          System.out.println("Level Three");
          Main.switchMenu(3);
        }
        else 
        {
          if (yCoord>=462&&yCoord<=511)
          {
            System.out.println("Back");
            Main.switchMenu(0);
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
    g.drawImage(menu, 0, 0, null);
    System.out.println("YAY");
  }
}
