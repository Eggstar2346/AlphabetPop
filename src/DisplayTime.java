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
  
  private int round1, round2, round3, score, level;
  private BufferedImage background;
  
  public DisplayTime (int newRound1, int newRound2, int newRound3, int newLevel)
  {
    System.out.println("YAS");
    round1=newRound1;
    round2=newRound2;
    round3=newRound3;
    level=newLevel;
    //score=(int)(level/(round1+round2+round3)*10000);
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
    
    
    
    
    
    
//    addMouseListener(new MouseAdapter() {
//    @Override
//    public void mouseClicked(MouseEvent e) {
//      int xCoord = e.getX();
//      int yCoord = e.getY();
//      System.out.println(xCoord+ "      "+yCoord);
//      Main.switchMenu(0);
//        }
//      }
//     );
    
    
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
  
  private int optionPane (String message, int optionType)
  {
    return JOptionPane.showConfirmDialog(null, message, "Name Length Error",optionType,JOptionPane.WARNING_MESSAGE);
  }
  
  
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
