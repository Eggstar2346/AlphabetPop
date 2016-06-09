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

/** <b> Version Information: </b>
  * <p>
  * <b>Author</b> Esther Yoo, Samantha Unger
  * <b>Version #</b> 1
  * <b>Date</b> 05.27.16
  * <b>Time Spent</b> 2 hours
  * <p>
  * <b>Author</b> Samantha Unger
  * <b>Version #</b> 1.1
  * <b>Date</b> 06.04.16
  * <b>Time Spent</b> 5 minutes
  * <b>What Was Changed</b> The generateSpeed() and getLevel() methods were added.
  * 
  * 
  * @author Esther Yoo
  * @author Samantha Unger
  * @version 1.1 06.04.16
  * 
  * The LevelTwo class is a Level (JPanel) that contains all the setup for the third level of the game.
  * It can be accessed by the user by going to menu, clicking on "Play", and choosing the "Medium" level.
  */
public class LevelTwo extends Levels 
{
  /**
   * The class constructor contains all the setup required for Level 2.
   * 
   * Assigns appropriate values for Level 2 to variables inherited from Levels <p>
   * The volume is adjusted and the background music is started.<p>
   * Next, GameTimer is instantiated and the timer is started.<p>
   * In the for-loop, each element in the array, letters, is assigned a character from the chosen word.<p>
   * Then, in the next for-loop, the starting coordinates of the bubbles, their speed, and their angles 
   * are all determined randomly.<p>
   * The audio clip that plays the letter corresponding to the current letter is started.<p>
   * Lastly, startup() is called, which checks whether the user's input is correct or incorrect, and outputs the
   * results accordingly.
   * 
   * @param x int that stores the screen width
   * @param y int that stores the screen height
   */
  public LevelTwo(int x, int y)
  {
    super(x, y);
    background = 2;
    letters = new char [4];
    readWords("Level2.txt");
    word = words.get(0).toUpperCase();
    
    AudioRecordings.volume(-15.0f, AudioRecordings.background[5]);
    AudioRecordings.background[5].loop(Clip.LOOP_CONTINUOUSLY);
    t = new GameTimer();
    t.start();
    
    for (int q = 0; q < word.length(); q++)
    {
      letters[q] = word.charAt(q);
    }
    Random rand = new Random();
    for (int z = 0 ; z < word.length(); z ++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (3 - 1) + 1) + 1;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, letters[z], false);
    }
    
    for (int z = word.length(); z < 26; z++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (3 - 1) + 1) + 1;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, (char)(65+(int)(Math.random() * (25)) + 1), false);
    }
    box = new ContainerBox(0, 0, canvasWidth, canvasHeight, "grass.jpg", Color.BLACK);
    startup();
    AudioRecordings.alphabet[temp].stop();
    AudioRecordings.alphabet[letters[currentLetter]-65].setMicrosecondPosition(0);
    AudioRecordings.alphabet[letters[currentLetter]-65].start();
    temp = letters[currentLetter]-65;
  }
  
  public int generateSpeed()
  {
    return (int)(Math.random() * (3 - 1) + 1) + 1;
  }
  public int getLevel()
  {
    return 2;
  }
}
