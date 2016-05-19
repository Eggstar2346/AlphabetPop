import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;



public class LevelOne extends JPanel {

  private BufferedImage background;
  private Bubble[] bubbles;
  
  public LevelOne()
  {
    bubbles = new Bubble[26];
    for (int x = 0 ; x < 26 ; x ++)
    {
      bubbles[x] = new Bubble (""+ ((char)NUM+x), int startX RANDNUM, int startY RANDNUM, false);
    }
    
    try 
    {
      background = ImageIO.read(new File("LevelOneBackground.jpg"));
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    repaint();
    
    addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
      int xCoord = e.getX();
      int yCoord = e.getY();
      System.out.println(xCoord+ "      "+yCoord);
      if (xCoord>=217&&xCoord<=1016)
      {
        if (yCoord>=162&&yCoord<=211)
        {
          System.out.println("Instructions");
        }
        else if (yCoord>=260&&yCoord<=309)
        {
          System.out.println("Play");
        } 
        else if (yCoord>=363&&yCoord<=412)
        {
          System.out.println("High Scores");
        }
        else 
        {
          if (yCoord>=462&&yCoord<=511)
          {
            System.out.println("Exit");
          }
        }
      }
    }
});
  }

  
   public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.drawImage(background, 0, 0, null);
  }  
  
  
}
