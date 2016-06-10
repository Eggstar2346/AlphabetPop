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
  * @author Samantha Unger
  * @version 1.1 06.1.16
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
  */
public class Instructions extends JPanel {
  
  private BufferedImage instruct;
  private int choice;
  private int currentSlide;
  
  
  public Instructions()
  {
    choice=0;
    repaint();
    //repaint();
    
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int xCoord = e.getX();
        int yCoord = e.getY();
        System.out.println(xCoord+ "      "+yCoord);
        currentSlide++;
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
        //System.out.println(currentSlide);
        if (currentSlide == 20)
          Main.switchMenu(choice);
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
    //draw instructions background
    g.drawImage(Images.instructions[currentSlide], 0, 0, null);
    //draw title
    g.setColor(Colors.letters);
    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
    g.drawString("Alphabet Pop", 375, 70);
    //draw back/forward buttons
    g.setColor(Color.black);
    g.fillRect(1035, 0, 150, 50);
    g.fillRect(0,0,150,50);
    g.setColor(Color.white);
    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
    g.drawString("Backwards", 25, 30);
    g.drawString("Forwards", 1060, 30);
  }
  
}
