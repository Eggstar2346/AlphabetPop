import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/** <b> Version Information: </b>
  * <p>
  * <b>Author</b> Samantha Unger
  * <b>Version #</b> 1
  * <b>Date</b> 06.01.16
  * <b>Time Spent</b> 2 hours
  * 
  * @author Samantha Unger
  * @version 1 06.08.16
  * 
  * The HighScores class is used to display the high scores on the screen.  At the bottom, the user has an option to
  * print or go back to the main menu.
  * 
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>background</b> This BufferedImage is used as the background.
  * <p>
  * <b>name</b> This array of Strings stores the names associated with the high scores.
  * <p>
  * <b>highScore</b> This array of Strings stores the high scores.
  * <p>
  * <b>gameType</b> This array of Strings stores the type of game associated with the high scores.
  */
public class HighScores extends JPanel {
  
  private BufferedImage background;
  private String[]name;
  private String[]highScore;
  private String[]gameType;
  
            /**
 * This method is the constructor for the class.  It uses a try block while reading in the background for high scores.
 * It also has a mouse listener inside the class.
 */   
  public HighScores ()
  {
    BufferedReader input;
    try 
    {
      background = ImageIO.read(new File(".//resources//highscoresback.jpg"));
    } 
    catch (IOException e) 
    {
    } 
    repaint();
    try
    {
      input = new BufferedReader (new FileReader (".//resources//highscores.ges"));
      input.readLine();
      int numberOfScores = Integer.parseInt (input.readLine ());
      name = new String [numberOfScores];
      highScore = new String [numberOfScores];
      gameType = new String [numberOfScores];
      for (int x = 0 ; x < numberOfScores ; x++)
      {
        name [x] = input.readLine ();
        highScore [x] = input.readLine ();
        gameType [x] = input.readLine ();
      }
    }
    catch (IOException e)
    {
    }
    catch (NumberFormatException n)
    {
    }
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int xCoord = e.getX();
        int yCoord = e.getY();
        if (yCoord>=550&&yCoord<=619)
        {
          if (xCoord>=84&&xCoord<=275)
          {
            Main.switchMenu(0);
          }
          else 
          {
            if (xCoord>=617&&xCoord<=808)
            {
              new PrintFile(name,highScore,gameType);
            }
          }
        }
      }
    });
  }
              /**
 * This static method uses a try catch to read in a file and check for the header.  It returns false if the file is
 * not valid and true if it is.
 * @return true if the file is valid and false if the file is not
 */   
  public static boolean checkScoreFile()
  {
    BufferedReader input;
    try
    {
      input = new BufferedReader (new FileReader ("highscores.ges"));
      if ((input.readLine ()).equals ("This is the high score file."))
      {
        return true;
      }
    }
    catch (IOException e)
    {
    }
    return false;
  }
  
    /**
   * This is the method that paints components on the frame.
   * 
   * First, the super's paintComponent method is called.
   * Then, the background image is drawn onto the panel.
   * 
   * @param g Graphics passed in to allow painting on the frame.
   */ 
  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, null);
    g.setFont(new Font("Comic Sans", Font.PLAIN, 48));
    g.drawString("Name", 90, 120);
    g.drawString("Score", 500, 120);
    g.drawString("Level", 1000, 120);
    g.setFont(new Font("Comic Sans", Font.PLAIN, 30));
    for (int x = 0 ; x < name.length ; x++)
    {
      g.drawString (name[x],90,150+x*40);
      g.drawString (highScore[x],500,150+x*40);
      if (gameType[x].equals("1"))
        g.drawString ("Easy",1000,150+x*40);
      else if (gameType[x].equals("2"))
        g.drawString ("Medium",1000,150+x*40);
      else
        g.drawString ("Hard",1000,150+x*40);
    }
  }
    
}
