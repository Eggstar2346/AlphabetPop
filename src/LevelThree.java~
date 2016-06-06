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
  * <b>Time Spent</b> 4 hours
  * <p>
  * <b>Author</b> Samantha Unger
  * <b>Version #</b> 1.1
  * <b>Date</b> 06.04.16
  * <b>Time Spent</b> 10 minutes
  * <b>What Was Changed</b> The generateSpeed() and getLevel() methods were added.
  * 
  * 
  * @author Esther Yoo
  * @author Samantha Unger
  * @version 1.1 06.04.16
  * 
  * The LevelThree class is a Level (JPanel) that contains all the setup for the third level of the game.
  * It can be accessed by the user by going to menu, clicking on "Play", and choosing the "Hard" level.
  */
public class LevelThree extends Levels 
{
  /**
   * The class constructor contains all the setup required for Level 3.
   * 
   * Assigns appropriate values for Level 3 to variables inherited from Levels <p>
   * The volume is adjusted and the background music is started.<p>
   * Next, GameTimer is instantiated and the timer is started.<p>
   * In the for-loop, each element in the array, letters, is assigned a character from the chosen word.<p>
   * Then, in the next for-loop, the starting coordinates of the required bubbles (ones that are part of the word and
   * therefore must definitely come up), their speed, and their angles are all determined randomly.<p>
   * In the next for-loop, the starting coordinates of extra bubbles, their speed, and their angles are all 
   * determined randomly as well.<p>
   * The audio clip that plays the letter corresponding to the current letter is started.<p>
   * Lastly, startup() is called, which checks whether the user's input is correct or incorrect, and outputs the
   * results accordingly.
   * 
   * @param x int that stores the screen width
   * @param y int that stores the screen height
   */
  public LevelThree(int x, int y)
  {
    super(x, y);
    background = 3;
    letters = new char [5];
    readWords("Level3.txt");
    word = words.get(0).toUpperCase();
    
    AudioRecordings.volume(-15.0f, AudioRecordings.background[3]);
    AudioRecordings.background[3].loop(Clip.LOOP_CONTINUOUSLY);
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
      speed = (int)(Math.random() * (8-1) + 1) + 1;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, letters[z], false);
    }
    
    for (int z = word.length(); z < 26; z++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (8 - 1) + 1) + 1;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, (char)(65+(int)(Math.random() * (25)) + 1), false);
    }
    AudioRecordings.alphabet[letters[currentLetter]-65].start();
    box = new ContainerBox(0, 0, canvasWidth, canvasHeight, "house2.jpg", Color.BLACK);
    startup();
  }
  
  public int generateSpeed()
  {
    return (int)(Math.random() * (8 - 1) + 1) + 1;
  }
  public int getLevel()
  {
    return 3;
  }
}
