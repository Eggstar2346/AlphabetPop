import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/** @author Esther Yoo
  * @author Chua Hock-Chuan for original graphics code, modifed by Esther Yoo.
  * @version 1.1 06.2.16
  * 
  * The Instructions class is a JPanel that goes into a Powerpoint-resembling system
  * where users can navigate through the different "slides" to learn how to play the game.
  *
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>instruct</b> A BufferedImage variable that refers to the background image used for the instructions.
  * <p>
  * <b>choice</b> An integer variable that takes the user's choice and uses it to switch between Instructions, Play,
  * Highscores, and Exit.
  * <p>
  */
public class Instructions extends JPanel {
  
  private BufferedImage instruct;
  private int choice;
  
  
  public Instructions ()
  {
    choice=0;
    System.out.println("YAS");
    try 
    {
      instruct = ImageIO.read(new File("placeholder.jpg"));
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
            System.out.println("Instructions");
            choice = 1;
          }
          else if (yCoord>=260&&yCoord<=309)
          {
            System.out.println("Play");
            choice = 2;
            Main.switchMenu(4);
          } 
          else if (yCoord>=363&&yCoord<=412)
          {
            System.out.println("High Scores");
            choice = 3;
          }
          else 
          {
            if (yCoord>=462&&yCoord<=511)
            {
              System.out.println("Exit");
              choice = 4;
              Main.switchMenu(5);
            }
          }
        }
        Main.switchMenu(0);
      }
    });
  }
  
  
  /**
   * This is the method that paints components on the frame.
   * 
   * First, the super's paintComponent method is called (partial overriding).<p>
   * Then, the background image is draw onto the panel.<p>
   * 
   * @param g Graphics passed in to allow painting on the frame.
   */ 
  @Override
  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(instruct, 0, 0, null);
  }
  
}
