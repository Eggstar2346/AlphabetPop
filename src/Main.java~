import javax.swing.JFrame;
import java.awt.event.*;


/**
 * Main Program for running the bouncing ball as a standalone application.
 */
public class Main {
  static JFrame frame;
  
  public static void switchMenu(int choice)
  {
    frame.getContentPane().removeAll();
    if (choice==0)
    {
      frame.add (new MainMenu());
    }
    else if (choice==1)
    {
      frame.add (new LevelOne(1200,550));
    }
    else if (choice==2)
    {
      frame.add (new LevelTwo(1200,550));
    }
    else if (choice==3)
    {
      frame.add (new LevelThree(1200,550));
    }
    else if (choice==4)
    {
      frame.add (new LevelMenu());
    }
    else if (choice==5)
    {
      frame.add(new ExitConfirm());
    }
    else if (choice==6)
    {
      frame.add(new Instructions());
    }
    frame.revalidate();
  }
  
  public static void main(String[] args) {
    // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        frame = new JFrame("A World of Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Splashscreen2());
//        MainMenu m = new MainMenu();
//        frame.add(m);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200,650);
      }
    });
  }
}