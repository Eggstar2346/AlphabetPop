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

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.ArrayList;

/* The DisplayTime class displays a message that shows how long the user spent on the level.
 * 
 * 
 * <p>
 * <b> Version Information: </b>
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1
 * <b>Date</b> 06.04.16
 * <b>Time Spent</b> 1.5 hours
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
 * @version 2 06.04.16
 */
public class DisplayTime extends JPanel {
  
  private int round1, round2, round3;
  private BufferedImage background;
  
    public DisplayTime (int newRound1, int newRound2, int newRound3)
    {
    System.out.println("YAS");
    round1=newRound1;
    round2=newRound2;
    round3=newRound3;
    try 
    {
      background = ImageIO.read(new File("background.jpg"));
      System.out.println("GOOD");
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
            revalidate();
          repaint();
          




    
    addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
      int xCoord = e.getX();
      int yCoord = e.getY();
      System.out.println(xCoord+ "      "+yCoord);
      Main.switchMenu(0);
        }
      }
     );
  }
  
  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    //g.drawImage(background, 0, 0, null);
    g.setFont(new Font("Courier New", Font.PLAIN, 12));
    g.drawString("You completed the first level!", 0, 50);
    g.drawString("You completed round 1 in " + round1 + " seconds!", 0, 100);
    g.drawString("You completed round 2 in " + round2 + " seconds!", 0, 150);
    g.drawString("You completed round 3 in " + round3 + " seconds!", 0, 200);
    g.drawString("This is a total of " + (round1+round2+round3) + " seconds!", 0, 250);
    System.out.println("YAY");
  }
  
}
