import javax.swing.JFrame;
import java.awt.event.*;
import java.io.*;


/**
 * 
 * <p>
 * <b> Version Information: </b>
 * <p>
 * <b>Author</b> Esther Yoo
 * <b>Version #</b> 1
 * <b>Date</b> 05.27.16
 * <b>Time Spent</b> 2 hours 
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1.1
 * <b>Date</b> 05.31.16
 * <b>Time Spent</b> 2 hours
 * <b>What Was Changed</b> The code organization was altered and nested mouse listeners were inserted into the main.
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 2
 * <b>Date</b> 06.02.16
 * <b>Time Spent</b> 2 hours
 * <b>What Was Changed</b> The code organization was improved by removing previous additions and the switchMenu() method 
 * was added.
 * 
 * <p>
 * <b> Instance Variables: </b>
 * <p>
 * <b>frame</b> This static variable stores the instance of the frame.
 * 
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 2 06.02.16
 */
public class Main {
  static JFrame frame;
  
    /**
   * The static switch menu method is used to remove everything on the JFrame and add a different JPanel to the frame.
   * An if structure is used to select the right panel to add.
   * 
   * @param choice int that indicates the correct panel to add
   */
  public static void switchMenu(int choice)
  {
    frame.getContentPane().removeAll();
    //AudioRecordings.background[currentLevel()].stop();
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
  
    /**
   * This main is used to run the program.  A nested thread is found within it
   * 
   * @param args  String array that allows command line parameters to be used when executing the program
   */
  public static void main(String[] args) {
    // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
    new AudioRecordings();
    new Images();
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
          /**
   * The run method runs the program by constructing the JFrame, and setting its visibility, size, default close 
   * operation and adding the splashscreen.
   */
      public void run() {
        frame = new JFrame("Alphabet Pop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainMenu()); //new Splashscreen2());//this should be splashscreen but i dont want it to play every single time
//        MainMenu m = new MainMenu();
//        frame.add(m);
        frame.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());
            if (e.getKeyCode() == KeyEvent.VK_F1)
            {
              String progpath = new String ("hh.exe AlphabetPopHelp.chm");
              try
              {
                Runtime.getRuntime ( ).exec (progpath);
              }
              catch (IOException easasads)
              {
                System.out.println("Doesn't work :/");
                //messageDialog ("Couldn't find Help File");
              }
            }
          }
        });
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200,650);
      }
    });
  }
}