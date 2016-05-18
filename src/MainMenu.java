import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;


public class MainMenu extends JPanel implements MouseListener
{
  private BufferedImage menu;
  
  public MainMenu ()
  {
    try 
    {
      menu = ImageIO.read(new File("MainMenu.jpg"));
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    repaint();
    System.out.println("YOLO");
  }
  
   public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.drawImage(menu, 0, 0, null);
  }
  
  public void mouseClicked (MouseEvent e)
  {
    System.out.println("1");
    int xCoord = e.getX();
    int yCoord = e.getY();
    System.out.println(xCoord+ "      "+yCoord);
  }
  
  public void mouseExited (MouseEvent e)
  {
    System.out.println("2");
  }
  
  public void mouseEntered (MouseEvent e)
  {
    System.out.println("3");
  }
  
  public void mouseReleased (MouseEvent e)
  {
    System.out.println("4");
  }
  
  public void mousePressed (MouseEvent e)
  {
    System.out.println("5");
  }
}