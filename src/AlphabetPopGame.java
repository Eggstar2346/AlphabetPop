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

/** The AlphabetPopGame class will contain all the logistics for our game and bring the components of the game together.
  * 
  * @author Samantha Unger, Esther Yoo
  * @version 1 05.27.16
  */

public class AlphabetPopGame extends JPanel
{
  private Ball[] ball = new Ball[26];
  private static final int UPDATE_RATE = 30;  // Frames per second (fps)
  private static final int NUM_BUBBLES = 26;
  private String word;
  //private Ball ball;         // A single bouncing Ball's instance
  private ContainerBox box;  // The container rectangular box
  
  private DrawCanvas canvas; // Custom canvas for drawing the box/ball
  private int canvasWidth;
  private int canvasHeight;
  
  int radius = 50;
  int x;
  int y;
  int speed;
  int angleInDegree;
  
  char [] letters;
  int currentLetter;
  Clip clip;
  Clip music;
  
  Clip[] audio = new Clip[8];
  
  private GameTimer t;
  
  Thread gameThread;
  
  public void loadAudio()
  {
    try
    {
      for (int x = 0; x < 6; x++)
      {
        audio[x] = AudioSystem.getClip();
        File audioClip = new File("Music_" + (x+1) + ".wav");
        AudioInputStream audioClipStream = AudioSystem.getAudioInputStream(audioClip);
        audio[x].open(audioClipStream);
      }
    }
    catch (UnsupportedAudioFileException q) {
      q.printStackTrace();
    } catch (IOException q) {
      q.printStackTrace();
    } catch (LineUnavailableException q) {
      q.printStackTrace();
    }
  }
  
  public void volume(float volAdjust, int clipNum)
  {
    FloatControl gainControl = (FloatControl) audio[clipNum].getControl(FloatControl.Type.MASTER_GAIN);
    gainControl.setValue(volAdjust); // Reduce volume by 10 decibels.
  }
  
  public void loadAudio(String fileName, int loop, float volAdjust)
  {
      try
      {
        Clip clip = AudioSystem.getClip();
        File effect = new File(fileName + ".wav");
        AudioInputStream effectAudio = AudioSystem.getAudioInputStream(effect);
        clip.open(effectAudio);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(volAdjust); // Reduce volume by 10 decibels.
        if (loop == 0)
          clip.start();
        else
          clip.loop(Clip.LOOP_CONTINUOUSLY);
      }
      catch (UnsupportedAudioFileException q) {
        q.printStackTrace();
      } catch (IOException q) {
        q.printStackTrace();
      } catch (LineUnavailableException q) {
        q.printStackTrace();
      }
  }
  
  /**
   * Constructor to create the UI components and init the game objects.
   * Set the drawing canvas to fill the screen (given its width and height).
   * 
   * @param width : screen width
   * @param height : screen height
   */
  public AlphabetPopGame(int width, int height) {
    
    canvasWidth = width;
    canvasHeight = height;
    loadAudio();
    levelThree();
    // Init the Container Box to fill the screen
    box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.GREEN);
    
    // Init the custom drawing panel for drawing the game
    canvas = new DrawCanvas();
    this.setLayout(new BorderLayout());
    this.add(canvas, BorderLayout.CENTER);
    
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try{
        gameThread.wait();
        }
        catch (InterruptedException exception){}
        int xCoord = e.getX();
        int yCoord = e.getY();
        System.out.println("XCoord: " + xCoord+ "      " + "YCoord" +yCoord);
        
        for (int z = NUM_BUBBLES-1;z>=0;z--)
        {
//          System.out.println(Math.sqrt(Math.pow(xCoord-ball[z].x,2)+Math.pow(yCoord-ball[z].y,2)));
//          System.out.println("Horizontal center: " + ball[z].returnHorizontalCenter());
          if (Math.sqrt(Math.pow(xCoord-ball[z].returnHorizontalCenter(),2)+Math.pow(yCoord-ball[z].returnVerticalCenter(),2))<=50 && !ball[z].getWasClicked())
          {
            if (ball[z].getLetter() == letters[currentLetter])
            {
              loadAudio("Music_5",0,+5.0f);
              //volume(+6.0f, 4);
              //audio[4].loop(0);
              ball[z].setColor(Color.green);
              ball[z].setWasClicked(true);
              ball[z].setSpeed(0);
              ball[z].setRadius(-100);
              ball[z].setLocation(-100,-100);
              currentLetter++;
            }
            else
            {
              loadAudio("Music_7",0,+5.0f);
            }
            if (currentLetter > letters.length-1)
            {
              currentLetter = 0;
              audio[2].stop();
            }
            System.out.println("This is bubble number: " + currentLetter);
            System.out.println("Time elapsed is "+ t.getTimeElapsed());
            //erase bubble
            //ball[z].setColor(Color.black, Color.black, Color.black);
            break;
          }
        }
        gameThread.notify();
      }
    });
    
    
    
    // Handling window resize.
    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        Component c = (Component)e.getSource();
        Dimension dim = c.getSize();
        canvasWidth = dim.width;
        canvasHeight = dim.height;
        // Adjust the bounds of the container to fill the window
        box.set(0, 0, canvasWidth, canvasHeight);
      }
    });
    
    // Start the ball bouncing
    gameStart();
  }
  
  /** Start the ball bouncing. */
  public void gameStart() {
    // Run the game logic in its own thread.
    gameThread = new Thread() {
      public void run() {
        while (true) {
          // Execute one time-step for the game 
          gameUpdate();
          // Refresh the display
          repaint();
          // Delay and give other thread a chance
          try {
            Thread.sleep(1000 / UPDATE_RATE);
          } catch (InterruptedException ex) {}
        }
      }
    };
    gameThread.start();  // Invoke GameThread.run()
  }
  
  /** 
   * One game time-step. 
   * Update the game objects, with proper collision detection and response.
   */
  public void gameUpdate() {
    for (int z = 0; z < 26; z++)
    {
      ball[z].moveOneStepWithCollisionDetection(box);
    }
    //ball[0].moveOneStepWithCollisionDetection(box);
  }
  
  /** The custom drawing panel for the bouncing ball (inner class). */
  class DrawCanvas extends JPanel {
    /** Custom drawing codes */
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background
      // Draw the box and the ball
      box.draw(g);
      for (int z = 0; z < NUM_BUBBLES; z++)
      {
        ball[z].draw(g);
      }
      // Display ball's information
      g.setColor(Color.WHITE);
      g.setFont(new Font("Courier New", Font.PLAIN, 12));
      g.drawString("Ball " + ball.toString(), 20, 30);
    }
    
    /** Called back to get the preferred size of the component. */
    @Override
    public Dimension getPreferredSize() {
      return (new Dimension(canvasWidth, canvasHeight));
    }
  }
  
  public AlphabetPopGame() 
  { 
  }
  
  public void levelOne()
  {
    letters = new char [3];
  }
  
  public void levelTwo()
  {
    letters = new char [4];
    // Init the ball at a random location (inside the box) and moveAngle
    Random rand = new Random();
    //ball[0] = new Ball(x, y, radius, speed, 227, Color.RED, "A", false);
    for (int z = 0 ; z < 26 ; z ++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (3 - 1) + 1) + 1;
      //speed = 0;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, (char)(65+z), false);
    }
  }
  
  public void levelThree()
  {
    //loadAudio("Music_3",1,-10.0f);
    volume(-15.0f, 2);
    audio[2].loop(Clip.LOOP_CONTINUOUSLY);
    t = new GameTimer();
    t.start();
    BufferedReader input;
    try
    {
      File temp;
      String fileName = "Words.txt";
      input = new BufferedReader (new FileReader (fileName));
      if (!input.readLine().equals("This is a Green Eggs & Sam file."))
      {
        JOptionPane.showMessageDialog (this, "This is not a .GSE file!", "Incompatible File Type", JOptionPane.ERROR_MESSAGE);
//        input = new BufferedReader(new FileReader(temp));
//        fileName = temp;
      }
      //read in the word
      for (int z = 0; z < (int)(Math.random() * 7) + 22; z++)
      {
        input.readLine();
      }
      word = input.readLine();
      word = word.toUpperCase();
      System.out.println(word);
    }
    catch (IOException q)
    {
      System.out.println("Open File IO Error");
    }
    catch (Exception e)
    {
      System.out.println("Open Error");
    }
    letters = new char [word.length()];
    for (int x = 0; x < word.length(); x++)
    {
      letters[x] = word.charAt(x);
    }
    // Init the ball at a random location (inside the box) and moveAngle
    Random rand = new Random();
    for (int z = 0 ; z < word.length(); z ++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (7 - 4) + 1) + 4;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, letters[z], false);
    }
    for (int z = word.length(); z < 26; z++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (8 - 1) + 1) + 1;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, (char)(65+(int)(Math.random() * (25)) + 1), false);
    }
  }
  
  public void highScores()
  {
  }
  
  public void mainMenu()
  {
  }
  
  public void levelSelectMenu()
  {
  }
  
  public void splashScreen()
  {
  }
  
  public void exitConfirm()
  {
  }
  
  public void quitGameConfirm()
  {
  }
  
  public void printScores()
  {
  }
  
  public void instructions()
  {
  }
  
  public void resultScreen()
  {
  }
}
