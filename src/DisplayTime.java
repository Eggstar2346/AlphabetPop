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
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1.1
 * <b>Date</b> 06.08.16
 * <b>Time Spent</b> 2 hours
 * <b>What Was Changed</b> The visual appearance was improved.  This included the addition of the buttonPanel JPanel
 * within the constructor.
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1.2
 * <b>Date</b> 06.09.16
 * <b>Time Spent</b> 2 hours
 * <b>What Was Changed</b> The high scores are now saved and the user can be directed to the LevelAdvance panel if they
 * have just completed the easy or medium level.
 * 
 * <p>
 * <b> Instance Variables: </b>
 * <p>
 * <b>round1</b> This int is used to store the number of seconds it took the user to finish round 1.
 * <p>
 * <b>round2/b> This int is used to store the number of seconds it took the user to finish round 2. 
 * <p>
 * <b>round3</b> This int is used to store the number of seconds it takes the user to finish round 3.
 * <p>
 * <b>score</b> This int is used to store user's calculated score.
 * <p>
 * <b>level</b> This int is used to store the level that the user just completed.
 * <p>
 * <b>background</b> This BufferedImage is used as the background.
 * 
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1.2 06.09.16
 */
public class DisplayTime extends JPanel {
  
  private int round1, round2, round3, score, level;
  private BufferedImage background;
  
  /**
   * The class constructor assigns all the values passed in its parameter to the appropriate instance variables.  It 
   * also calculates the user's score, reads in the background image (within a try block) and sets the panel layout.  A
   * JLabel and JButton are added to a JPanel that is added to the bottom of this JPanel. An ActionListener is added 
   * to the JButton and its inner ActionPerformed method is defined.  Within this ActionPerformed method, there are many
   * things taking place.  The input is being checked using an if statement to see if it is too many or too few 
   * characters.  If this is the case, the box is reset and a JOptionPane is used to inform the user.  If the user 
   * input is acceptable, the scores are saved to a file.  The scores in the file are read in and the user's score
   * is compared to these scores using an if statement.  If the user's score is greater than one of the scores, the 
   * other scores are shifted and the new score is saved in its place.  Try blocks are used to catch IOException and 
   * NumberFormatException, related to reading in from the file.  Lastly, if the user has just played level 3, they are
   * taken to the menu.  Otherwise, the components are removed from the JFrame in the Main class, and a LevelAdvance is
   * constructed and added to the JFrame.
   * 
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>buttonPanel </b> This JPanel is used to hold the JLabel, JButton and JTextField.
   * <p>
   * <b>enterValue </b> This JLabel is used to display a request for the user's name.
   * <p>
   * <b>continueButton </b> This JButton is used to allow the user to continue.
   * <p>
   * <b>inputField </b> This JTextField is used to allow the user to input their name.
   * <p>
   * <b>input </b> This BufferedReader is used to read in from the file.
   * <p>
   * <b>output </b> This PrintWriter is used to output to the file. 
   * 
   * 
   * @param newRound1 This int is used to store the number of seconds the user took on round 1.
   * @param newRound2 This int is used to store the number of seconds the user took on round 2.
   * @param newRound3 This int is used to store the number of seconds the user took on round 3.
   * @param newLevel This int is used to store the level the user played.
   */
  public DisplayTime (int newRound1, int newRound2, int newRound3, int newLevel)
  {
    System.out.println("YAS");
    round1=newRound1;
    round2=newRound2;
    round3=newRound3;
    level=newLevel;
    score=3600/((round1+round2+round3)/(3*level));
    System.out.println(score);
    try 
    {
      background = ImageIO.read(new File("bubblybackground.jpg"));
      System.out.println("GOOD");
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    setLayout(new BorderLayout());
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    add (buttonPanel, BorderLayout.SOUTH);
    revalidate();
    repaint();
    
    
    JLabel enterValue;
    enterValue= new JLabel ("What is your name?");
    enterValue.setFont(new Font ("Serif", Font.PLAIN, 16));
    buttonPanel.add (enterValue);
    JButton continueButton = new JButton ("Continue");
    JTextField inputField = new JTextField (20);
    buttonPanel.add (inputField);
    buttonPanel.add (continueButton);
    continueButton.addActionListener (new ActionListener ()
                                        {
      public void actionPerformed (ActionEvent e)
      {
        String userName = inputField.getText();
        if (userName.length () >= 1 && userName.length () <= 20)
        {
          int numberOfScores = 0;
          String[] name = new String [10];
          int[] highScore = new int [10];
          String[] gameType = new String [10];
          BufferedReader input;
          PrintWriter output;
          try
          {
            input = new BufferedReader (new FileReader ("highscores.ges"));
            String firstLine = input.readLine ();
            if (firstLine != null && firstLine.equals ("This is the high score file."))    //is this good?
            {
              numberOfScores = Integer.parseInt (input.readLine ());
              for (int x = 0 ; x < numberOfScores ; x++)
              {
                name [x] = input.readLine ();
                highScore [x] = Integer.parseInt (input.readLine ());
                gameType [x] = input.readLine ();
              }
              if (numberOfScores < 10)
              {
                numberOfScores++;
              }
              for (int x = 0 ; x < numberOfScores ; x++)
              {
                if (highScore [x] < score)
                {
                  for (int z = numberOfScores - 1 ; z > x ; z--)
                  {
                    highScore [z] = highScore [z - 1];
                    name [z] = name [z - 1];
                    gameType [z] = gameType [z - 1];
                  }
                  highScore [x] = score;
                  name [x] = userName;
                  gameType [x] = ""+level;
                  break;
                }
              }
            }
          }
          catch (IOException i)
          {
          }
          catch (NumberFormatException n)
          {
          }
          if (numberOfScores == 0)
          {
            numberOfScores++;
            highScore [0] = score;
            name [0] = userName;
            gameType [0] = ""+level;
          }
          try
          {
            output = new PrintWriter (new FileWriter ("highscores.ges"));
            output.println ("This is the high score file.");
            output.println (numberOfScores);
            for (int x = 0 ; x < numberOfScores ; x++)
            {
              output.println (name [x]);
              output.println (highScore [x]);
              output.println (gameType [x]);
            }
            output.close ();
          }
          catch (IOException i)
          {
          }
          if (level==3)
          {
            Main.switchMenu(0);
            return;
          }
          else
          {
            Main.frame.getContentPane().removeAll();
            Main.frame.add(new LevelAdvance(level+1));
            Main.frame.repaint();
            Main.frame.revalidate();
            return;
          }
        }
        if (userName.length () < 1)
        {
          optionPane ("That name is too short! Please enter a name that is between 1 and 20 characters.", JOptionPane.DEFAULT_OPTION);
          inputField.setText("");
          inputField.requestFocus();
        }
        else
        {
          optionPane ("That name is too long! Please enter a name that is between 1 and 20 characters.", JOptionPane.DEFAULT_OPTION);
          inputField.setText("");
          inputField.requestFocus();
        }
      }});
  }
  
  
  /**
   * This method is used to construct a JOptionPane with a given message and option type.
   * 
   * @param message This int is used to store the message to be displayed on the JOptionPane.
   * @param optionType This int is used to store the option type for the JOptionPane.
   */
  private int optionPane (String message, int optionType)
  {
    return JOptionPane.showConfirmDialog(null, message, "Name Length Error",optionType,JOptionPane.WARNING_MESSAGE);
  }
  
  /**
   * This method paints components on the screen, including the times for each round, the score, and the total seconds
   * taken. 
   * @param g Graphics is passed in to allow painting on the frame.
   */
  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, null);
    g.setFont(new Font("Comic Sans", Font.PLAIN, 48));
    g.drawString("You completed the first level!", 270, 90);
    g.drawString("This is a total of " + (round1+round2+round3) + " seconds!", 270, 400);
    g.setFont(new Font("Comic Sans", Font.PLAIN, 30));
    g.drawString("You completed Round 1 in " + round1 + " seconds!", 300, 200);
    g.drawString("You completed Round 2 in " + round2 + " seconds!", 300, 250);
    g.drawString("You completed Round 3 in " + round3 + " seconds!", 300, 300);
    g.setFont(new Font("Comic Sans", Font.PLAIN, 65));
    g.drawString("Your SCORE is " + score + "!",270,500);
    System.out.println("YAY");
  }
  
}
