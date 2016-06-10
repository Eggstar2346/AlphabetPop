import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

/** The PauseScreen class is used to display the pause screen.
 * 
 * 
 * <p>
 * <b> Version Information: </b>
 * <p>
 * <b>Author</b> Esther Yoo
 * <b>Version #</b> 1
 * <b>Date</b> 06.10.16
 * <b>Time Spent</b> 20 minutes
 * 
 * 
 *
 * 
 * 
 * 
 * @author Esther Yoo
 * @version 1 06.10.16
 */

public class PauseScreen extends JPanel
{
   /**
 * This is the constructor that revalidates and repaints.
 */
  public PauseScreen()
  {
    revalidate();
    repaint();
  }
  

        /**
* This is the method that paints components on the frame.  It calls the super's paintComponent method, passing in
* g, and draws the image.
* 
* @param g Graphics passed in to allow painting on the frame.
*/ 
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(Images.screens[0],0,0,null);
    g.setColor(Color.white);
    g.fillRect(500,210,50,50);
    g.drawString("Resume",510,790);
  }
}