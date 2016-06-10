import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Images
{
  static BufferedImage [] screens = new BufferedImage [5];
  static BufferedImage [] levels = new BufferedImage [3];
  static BufferedImage [] rounds = new BufferedImage [3];
  static BufferedImage [] components = new BufferedImage [20];
  static BufferedImage [] instructions = new BufferedImage [20];
  
  public Images()
  {
    try 
    {
      //load screens
      
      //load rounds
//      for (int x = 0; x < rounds.length; x++)
//      {
//        rounds[x] = ImageIO.read(new File("Round" + (x+1) + ".jpg"));
//      }
      //load instructions
      screens[0] = ImageIO.read(new File(".//resources//PauseScreen.jpg"));
      for (int x = 0; x < instructions.length; x++)
      {
        instructions[x] = ImageIO.read(new File(".//resources//InstructionsBack" + (x+1) + ".jpg"));
        System.out.println("WHOOOOOOOOOOOOOO");
      }
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO wayyy");
    }
  }
}