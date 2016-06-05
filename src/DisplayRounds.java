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

public class DisplayRounds extends JPanel
{
  private BufferedImage background;
  private ContainerBox box;
  //private int currentLevel;
  
  public DisplayRounds (int currentWord, int currentLevel)
  {
    System.out.println("IS THIS WORKING OR NO");
    box = new ContainerBox(0, 0, 1200,650, ("Round" + currentWord+1 + "Back.jpg"), Color.BLACK);
//    try 
//    {
//      background = ImageIO.read(new File("Round" + currentWord+1 + "Back.jpg"));
//      System.out.println(background.toString());
//    } 
//    catch (IOException e) 
//    {
//    }
    
   // repaint();
    //revalidate();
    
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int xCoord = e.getX();
        int yCoord = e.getY();
        System.out.println(xCoord+ "      "+yCoord);
        Main.switchMenu(currentLevel);
      }
    }
    );
  }
  
  @Override
  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    box.draw(g);
    //g.drawImage(background, 0, 0, null);
//    g.setFont(new Font("Courier New", Font.PLAIN, 12));
//    g.drawString("You completed the first level!", 0, 50);
//    g.drawString("You completed round 1 in " + round1 + " seconds!", 0, 100);
//    g.drawString("You completed round 2 in " + round2 + " seconds!", 0, 150);
//    g.drawString("You completed round 3 in " + round3 + " seconds!", 0, 200);
//    g.drawString("This is a total of " + (round1+round2+round3) + " seconds!", 0, 250);
    System.out.println("It's supposed to be working...");
  }
}