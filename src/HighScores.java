import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/**
 * Auto Generated Java Class.
 */
public class HighScores extends JPanel {
  
  private BufferedImage background;
  private String[]name;
  private String[]highScore;
  private String[]gameType;
  
  public HighScores ()
  {
    BufferedReader input;
    System.out.println("YAS");
    try 
    {
      background = ImageIO.read(new File("highscoresback.jpg"));
      System.out.println("GOOD");
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    repaint();
    try
    {
      input = new BufferedReader (new FileReader ("highscores.ges"));
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
        System.out.println(xCoord+ "      "+yCoord);
        if (yCoord>=550&&yCoord<=619)
        {
          if (xCoord>=84&&xCoord<=275)
          {
            System.out.println("Back");
            Main.switchMenu(0);
          }
          else 
          {
            if (xCoord>=617&&xCoord<=808)
            {
              System.out.println("Print");
              new PrintFile(name,highScore,gameType);
            }
          }
        }
      }
    });
  }
  
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
  
  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, null);
    g.setFont(new Font("Comic Sans", Font.PLAIN, 48));
    g.drawString("Name", 90, 150);
    g.drawString("Score", 500, 150);
    g.drawString("Level", 1000, 150);
    g.setFont(new Font("Comic Sans", Font.PLAIN, 30));
    for (int x = 0 ; x < name.length ; x++)
    {
      g.drawString (name[x],90,180+x*40);
      g.drawString (highScore[x],500,180+x*40);
      if (gameType[x].equals("1"))
        g.drawString ("Easy",1000,180+x*40);
      else if (gameType[x].equals("2"))
        g.drawString ("Medium",1000,180+x*40);
      else
        g.drawString ("Hard",1000,180+x*40);
    }
    System.out.println("YAY");
  }
    
}
