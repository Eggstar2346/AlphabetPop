import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/**<b> Version Information: </b>
  * <p>
  * <b>Author</b> Samantha Unger
  * <b>Version #</b> 1
  * <b>Date</b> 06.01.16
  * <b>Time Spent</b> 1 hour
  * 
  * <b>Author</b> Esther Yoo
  * <b>Version #</b> 2
  * <b>Date</b> 06.05.16
  * <b>Time Spent</b> 1 hour  
  * 
  * @author Samantha Unger
  * @author Esther Yoo
  * @version 2 06.05.16
  * 
  * The Instructions class is a JPanel that goes into a Powerpoint-resembling system
  * where users can navigate through the different "slides" to learn how to play the game.
  *
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>currentSlide</b> An integer variable used to keep track of which slide the user is on.
  */
public class Instructions extends JPanel 
{
  private int currentSlide;
  
  /**
   * The class constructor contains all the setup required for the Instructions.
   * 
   * First, the background image (initially at slide 0) is drawn to the background. <p>
   * Then, a mouseListener is added. If the mouse click was within certain coordinates (as determined by if-statements),
   * the slides will move forward. If the mouse click was at a certain different set of coordinates,
   * the slides will move backward.<p>
   * Users may go back by pressing "Backward" at the first slide, or "Forward" at the last slide.<p>
   * Lastly, certain sound effects were added to Instructions for further enhancement and enjoyability.
   * These are specified in an if-statement and are located at the end of the code. <p>
   */
  public Instructions()
  {
    repaint();
    
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int xCoord = e.getX();
        int yCoord = e.getY();
        
        if (yCoord>=0&&yCoord<=50)
        {
          if (xCoord>=0&&xCoord<=150)
          {
            if (currentSlide==0)
              Main.switchMenu(0);
            else
              currentSlide--;
          }
          else 
          {
            if (xCoord>=1050&&xCoord<=1200)
            {
              if (currentSlide == 20)
                Main.switchMenu(0);
              else
                currentSlide++;
            }
          }
        }
        
        if (currentSlide == 2)
          AudioRecordings.alphabet[0].start();
        if (currentSlide == 3)
        {
          AudioRecordings.alphabet[0].stop();
          AudioRecordings.effects[0].start();
        }
        if (currentSlide == 4)
        {
          AudioRecordings.effects[0].stop();
          AudioRecordings.effects[1].start();
        }
        
        repaint();
        revalidate();
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
    g.drawImage(Images.instructions[currentSlide], 0, 0, null);
    g.setColor(Colors.letters);
    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
    g.drawString("Alphabet Pop", 375, 70);
    g.setColor(Color.black);
    g.fillRect(1050, 0, 150, 50);
    g.fillRect(0,0,150,50);
    g.setColor(Color.white);
    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
    g.drawString("Backwards", 25, 30);
    g.drawString("Forwards", 1060, 30);
  }
  
}
