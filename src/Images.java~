import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/** <b> Version Information: </b>
  * <p>
  * <b>Author</b> Esther Yoo
  * <b>Version #</b> 1
  * <b>Date</b> 06.01.16
  * <b>Time Spent</b> 1 hour
  * 
  * @author Esther Yoo
  * @version 1 06.01.16
  * 
  * The Images class loads all the images we will use for our game and puts them in static arrays, 
  * making them easily accessible.
  * 
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>screens</b> A static BufferedImage array that stores references to all the program screens.
  * <p>
  * <b>levels</b> A static BufferedImage array that stores references to all of the levels screens".
  * <p>
  * <b>instructions</b> A static Clip array that stores references to all of the instructions screens.
  */
public class Images
{
  static BufferedImage [] screens = new BufferedImage [5];
  static BufferedImage [] levels = new BufferedImage [3];
  static BufferedImage [] instructions = new BufferedImage [20];
  
  /**
   * This constructor loads all of the audio clips into the correct arrays.
   * 
   * The try-block is necessary to catch any IOException problems what may arise.
   * The for-loops load in the images to their approproate static methods one by one.
   */
  public Images()
  {
    try 
    {
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