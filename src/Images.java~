import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Images
{
  BufferedImage [] screens = new BufferedImage [5];
  BufferedImage [] levels = new BufferedImage [3];
  BufferedImage [] rounds = new BufferedImage [3];
  BufferedImage [] components = new BufferedImage [20];
  BufferedImage [] instructions = new BufferedImage [20];
  
  public void loadImage()
  {
    try 
    {
      //load screens
      
      //load rounds
      for (int x = 0; x < rounds.length; x++)
      {
        rounds[x] = ImageIO.read(new File("Round" + (x+1) + ".jpg"));
      }
      //load instructions
      for (int x = 0; x < 3; x++)
      {
        instructions[x] = ImageIO.read(new File("InstructionsBack" + (x+1) + ".jpg"));
      }
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO wayyy");
    }
  }
}