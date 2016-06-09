import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/* The MainMenu class loads the MainMenu image and displays it on the screen.   It allows the user to select
 * which page in the game they would like to go to and takes them there.
 * 
 * 
 * <p>
 * <b> Version Information: </b>
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1
 * <b>Date</b> 05.19.16
 * <b>Time Spent</b> 1.5 hours
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 2
 * <b>Date</b> 06.01.16
 * <b>Time Spent</b> 1.5 hours
 * <b>What Was Changed</b> The choice variable was removed and the class now makes use of the static menuSwitch method
 * from the Main class.
 * 
 * 
 * 
 * <p>
 * <b> Instance Variables: </b>
 * <p>
 * <b>image</b> This creates an instance of a BufferedImage that is used to display the menu.
 * 
 * 
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 2 06.1.16
 */

public class MainMenu extends JPanel
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
  public MainMenu ()
  {
    System.out.println("YAS");
    try 
    {
      menu = ImageIO.read(new File("MainMenu.jpg"));
      System.out.println("GOOD");
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    repaint();
    
    addKeyListener(new KeyAdapter() { //this wont work for some reason
          @Override
          public void keyTyped(KeyEvent e) {
            System.out.println(e.getKeyChar());
            if (e.getKeyChar() == KeyEvent.VK_F1)
            {
              String progpath = new String ("hh.exe AlphabetPopHelp.chm");
              try
              {
                Runtime.getRuntime ( ).exec (progpath);
              }
              catch (IOException easasads)
              {
                System.out.println("Doesn't work :/");
                //messageDialog ("Couldn't find Help File");
              }
            }
          }
        });
    
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
          System.out.println("Instructions");
          Main.switchMenu(6);
        }
        else if (yCoord>=260&&yCoord<=309)
        {
          System.out.println("Play");
          Main.switchMenu(4);
        } 
        else if (yCoord>=363&&yCoord<=412)
        {
          System.out.println("High Scores");
          Main.switchMenu(7);
        }
        else 
        {
          if (yCoord>=462&&yCoord<=511)
          {
            System.out.println("Exit");
            Main.switchMenu(5);
          }
        }
      }
    }
});
  }
  
  
  
        /**
* This is the method that paints components on the frame.
* 
* @param g Graphics passed in to allow painting on the frame.
*/ 
   public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(menu, 0, 0, null);
    System.out.println("YAY");
  }

}
