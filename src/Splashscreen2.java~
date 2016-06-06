import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import javax.sound.sampled.*;
import javax.swing.*;

/** <b> Version Information: </b>
  * <p>
  * <b>Author</b> Esther Yoo
  * <b>Version #</b> 1
  * <b>Date</b> 06.02.16
  * <b>Time Spent</b> 3 hours
  * 
  * 
  * @author Esther Yoo
  * @author Chua Hock-Chuan for original graphics code, modifed by Esther Yoo.
  * @version 1.1 06.2.16
  * 
  * The Splashscreen2 class is a JPanel that shows a cute opening
  * screen when the user first opens the game. It starts out with
  * bubbles spelling the word "Alphabet Pop", which then disperse
  * randomly. The bubbles then pop in order to spell out "Alphabet Pop"
  * at the top of the screen before moving to the main menu screen.
  *
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>splash</b> A BufferedImage variable that refers to the background image used in the splashscreen.
  * <p>
  * <b>title</b> A String variable that contains the word "Alphabet Pop" (makes processing easier).
  * <p>
  * <b>introBubble</b> An array of Balls that later contains the bubbles corresponding to each letter in title.
  * <p>
  * <b>gameThread</b> A Thread variable that allows the bubbles to all move at once.
  * <p>
  * <b>box</b> A ContainerBox variable that represents the box in which all the components are contained.
  * <p>
  * <b>t</b> A GameTimer variable that regulates the popping of the bubbles and notifies when to move on to the main menu.
  * <p>
  * <b>currentLetter</b> An integer variable that keeps track of which letter index is to be popped next.
  * <p>
  * <b>bubblePop</b> A Clip variable that refers to the bubble-popping audio clip.
  */

public class Splashscreen2 extends JPanel
{
  private BufferedImage splash;
  private String title = "Alphabet Pop".toUpperCase();
  private Ball[] introBubble = new Ball [title.length()];
  Thread gameThread;
  private ContainerBox box;
  private GameTimer t; //= new GameTimer();
  private int currentLetter;
  private Clip bubblePop;
  private Clip background;
  
  /**
   * The class constructor first creates the ContainerBox, with the appropriate image
   * ("SplashscreenBack.jpg") as its background.
   * 
   * Creates the box object.<p>
   * The for-loop instantiates all the bubbles needed in the splashscreen and stores them in the introBubble array.<p>
   * Next, GameTimer is instantiated, timeElapsed is set to 1 (for processing reasons), and the timer is started.<p>
   * The try-catch statement loads the bubble-popping audio clip and references to Clip variable bubblePop.<p>
   * Lastly, the game Thread is started.
   */
  public Splashscreen2() 
  { 
    box = new ContainerBox(0, 0, 1200,650, "SplashscreenBack.jpg", Color.BLACK);
    for (int x = 0; x < title.length(); x++)
    {
      if (title.charAt(x) != ' ')
        introBubble[x] = new Ball (90+x*90, 300,50, 2, (float)(Math.random()*360), Colors.bubbles, (char)((title.charAt(x))), false);
    }
    t = new GameTimer();
    t.setTimeElapsed(1);
    t.start();
    try
    {
      bubblePop = AudioSystem.getClip();
      File popClip = new File("Music_5.wav");
      AudioInputStream popClipStream = AudioSystem.getAudioInputStream(popClip);
      bubblePop.open(popClipStream);
      background = AudioSystem.getClip();
      File backgroundClip = new File("Music_9.wav");
      AudioInputStream backgroundClipStream = AudioSystem.getAudioInputStream(backgroundClip);
      background.open(backgroundClipStream);
    }
    catch (UnsupportedAudioFileException q) {
      q.printStackTrace();
    } catch (IOException q) {
      q.printStackTrace();
    } catch (LineUnavailableException q) {
      q.printStackTrace();
    }
    gameStart();
    background.start();
  }
  
  /** The gameStart method runs all the bubbles at the same time.
    * 
    * First, Thread is instantiated.<p>
    * Then, the run method is nested inside and, in a while loop, calls gameUpdate(), repaint() 
    * (invoking paintComponent(Graphics g)). The try-catch statement contains a Thread.sleep, 
    * which serves to delay the animation and give other threads a chance.<p>
    * Lastly, gameThread.start() is called, invoking GameThread.run().
    */
  public void gameStart() {
    gameThread = new Thread() {
      public void run() {
        while (true) {
          gameUpdate();
          repaint();
          try {
            Thread.sleep(1000 / 30);
          } catch (InterruptedException ex) {}
        }
      }
    };
    gameThread.start();
  }
  
  /** The gameUpdate method controls the movement of the bubbles.
    * 
    * The for-loop goes through each of the bubble objects and ensures none of them go outside
    * the bounds of the box.<p>
    * The first if statement (outside the for-loop) checks if the time elapsed is divisible by 3. If it is, it checks
    * whether currentLetter is 8 (a space character). If it is, it adds 1 to currentLetter.<p>
    * Next, it checks if currentLetter is less than the number of characters in title. If it is,
    * the bubble's speed is set to 0 (doesn't move), its' radius is set to -100 (for processing reasons),
    * and its' location is set to -100, -100 (offscreen). The audio clip of the bubble popping sound
    * is reset back to time 0 and played. Then, currentLetter is incremented by 1.<p>
    * Lastly, the last if statement checks if timeElapsed is 38, and if it is, the splashscreen is exited and the program
    * goes to the main menu screen.
    */
  public void gameUpdate() {
    for (int z = 0; z < title.length(); z++)
    {
      if (title.charAt(z) != ' ')
        introBubble[z].moveOneStepWithCollisionDetection(box);
    }
    if (t.getTimeElapsed()%3 == 0)
    {
      if (currentLetter == 8)
        currentLetter++;
      if (currentLetter < title.length())
      {
        introBubble[currentLetter].setSpeed(0);
        introBubble[currentLetter].setRadius(-100);
        introBubble[currentLetter].setLocation(-100,-100);
        bubblePop.setMicrosecondPosition(0);
        bubblePop.start();
        t.setTimeElapsed(t.getTimeElapsed() + 1);
        currentLetter++;
      }
    }
    
    if (t.getTimeElapsed()==38)
      Main.switchMenu(0);    
  }
  
  /** The paintComponent method draws all the components (bubble, letters) on the screen.
    * 
    * First, the super's paintComponent method is called (partial overriding).<p>
    * Next, the ContainerBox (box) is drawn.<p>
    * The for-loop is used to draw every single bubble held in the array, introBubble.<p>
    * Next, the font and colour are set for letters.<p>
    * The second for-loop is used to draw every letter up to currentLetter. The letters must be
    * repeatedly redrawn due to the fact that paintComponent is called constantly, and all components
    * this method must be constantly updating.
    * 
    * @param g This parameter pass is used to access the Graphics class.
    */
  @Override
  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    box.draw(g);
    for (int z = 0; z < title.length(); z++)
    {
      if (title.charAt(z) != ' ')
        introBubble[z].draw(g);
    }
    g.setFont(new Font("Courier New", Font.PLAIN, 40));
    g.setColor(Colors.letters);
    for (int x = 0; x < currentLetter; x++)
    {
      if (currentLetter != 0)
      {
        g.drawString("" + title.charAt(x), (x*100) + 10, 50);
      }
    }
  }
}
