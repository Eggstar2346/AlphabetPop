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
  * <b>Author</b> Samantha Unger
  * <b>Version #</b> 1
  * <b>Date</b> 05.30.16
  * <b>Time Spent</b> 1.5 hours
  * <p>
  * <b>Author</b> Samantha Unger
  * <b>Version #</b> 1.1
  * <b>Date</b> 06.04.16
  * <b>Time Spent</b> 1 hour
  * <b>What Was Changed</b> The generateSpeed() and getLevel() methods were added.
  * <p>
  * <b>Author</b> Samantha Unger
  * <b>Version #</b> 1.1
  * <b>Date</b> 06.04.16
  * <b>Time Spent</b> 1 hour
  * <b>What Was Changed</b> Audio added and overall game functionality improved.
  * 
  * @author Samantha Unger
  * @author Esther Yoo
  * @version 1.2 06.04.16
  * 
  * The LevelOne class is a Level (JPanel) that contains all the setup for the first level of the game.
  * It can be accessed by the user by going to menu, clicking on "Play", and choosing the "Easy" level.
  */
public class LevelOne extends Levels {
  
 /**
   * The class constructor contains all the setup required for Level 1.
   * 
   * Assigns appropriate values for Level 1 to variables inherited from Levels <p>
   * The volume is adjusted and the background music is started.<p>
   * Next, GameTimer is instantiated and the timer is started.<p>
   * In the for-loop, each element in the array, letters, is assigned a character from the chosen word.<p>
   * Then, in the next for-loop, the starting coordinates of the bubbles, their speed, and their angles 
   * are set so that the bubbles display nicely on the panel.<p>
   * The Levels class's instance variable, temp, is then assigned a value according to the first letter of the word
   * chosen. Then, the method that plays the audio clip that plays the letter corresponding to the temp letter is started.<p>
   * Lastly, the background image is loaded in and startup() is called, which checks whether the user's input is 
   * correct or incorrect, and outputs the results accordingly.<p>
   * 
   * @param x int that stores the screen width
   * @param y int that stores the screen height
   */
  public LevelOne(int x, int y)
  {
    super(x, y);
    background = 1;
    letters = new char [3];
    readWords(".//resources//Level1.txt");
    word = words.get(0).toUpperCase();
    
    AudioRecordings.volume(-15.0f, AudioRecordings.background[1]);
    AudioRecordings.background[1].loop(Clip.LOOP_CONTINUOUSLY);
    t = new GameTimer();
    t.start();
    
    for (int q = 0; q < word.length(); q++)
    {
      letters[q] = word.charAt(q);
    }

    for (int z = 0 ; z < 26; z ++)
    {
      ball[z] = new Ball(50+(z%9)*(2*radius+30), 50+(z/9)*(2*radius+30), radius, 0, 0, Colors.bubbles, (char)(65+z), false);
    }
    
    temp = letters[currentLetter];
    AudioRecordings.playLevelsOneTwo(temp, letters[currentLetter]);
    box = new ContainerBox(0, 0, canvasWidth, canvasHeight, "underwater2.jpg");
    startup();
  }
  
  
  public int generateSpeed()
  {
    return 0;
  }
  
  public int getLevel()
  {
    return 1;
  }
}
