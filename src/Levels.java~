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

/**
 * 
 * <p>
 * <b> Version Information: </b>
 * <p>
 * <b>Author</b> Esther Yoo
 * <b>Version #</b> 1
 * <b>Date</b> 05.31.16
 * <b>Time Spent</b> 3 hours
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1.1
 * <b>Date</b> 06.02.16
 * <b>Time Spent</b> 5 hours
 * <b>What Was Changed</b> The code organization was improved and startup() method was created.  Some problems involving
 * file IO were fixed.
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1.2
 * <b>Date</b> 06.05.16
 * <b>Time Spent</b> 1 hour
 * <b>What Was Changed</b> The code now properly displays the letters.  Brackets within the LettersCanvas class had to 
 * be moved to the correct location.
 * 
 * 
 * 
 * 
 * <p>
 * <b> Instance Variables: </b>
 * <p>
 * <b>ball</b> This creates an array of Ball objects that are used as the bubbles.
 * <p>
 * <b>UPDATE_RATE</b> This final int is used to store the update rate.
 * <p>
 * <b>ball</b> This creates an array of Ball objects that are used as the bubbles.
 * <p>
 * <b>NUM_BUBBLES</b> This final int stores the number of bubbles to be used.
 * <p>
 * <b>word</b> This String stores the word the user must spell.
 * <p>
 * <b>words</b> This ArrayList stores all of the words from the file.
 * <p>
 * <b>box</b> This stores an instance of the ContainerBox class for putting the bubbles.
 * <p>
 * <b>box2</b> This stores an instance of the ContainerBox class for putting the bubbles.
 * <p>
 * <b>canvas</b> This creates an instance of the DrawCanvas class for drawing the box and bubbles on.
 * <p>
 * <b>canvas2</b> This creates an instance of the DrawLetters class for drawing the letters on.
 * <p>
 * <b>canvasWidth</b> This int stores the width of the canvas.
 * <p>
 * <b>canvasHeight</b> This int stores the height of the canvas.
 * <p>
 * <b>xCoord</b> This int stores the x-coordinate of where the user presses.
 * <p>
 * <b>yCoord</b> This int stores the y-coordinate of where the user presses.
 * <p>
 * <b>radius</b> This int stores the radius size for the bubbles.
 * <p>
 * <b>x</b> This int is not used in the current version and may be removed in future versions.
 * <p>
 * <b>y</b> This int is not used in the current version and may be removed in future versions.
 * <p>
 * <b>speed</b> This int is not used in the current version and may be removed in future versions.
 * <p>
 * <b>angleInDegree</b> This int is not used in the current version and may be removed in future versions.
 * <p>
 * <b>background</b> This int is not used in the current version and may be removed in future versions.
 * <p>
 * <b>letters</b> This char array stores the letters of the current word to be spelled.
 * <p>
 * <b>currentLetter</b> This int stores the index of the current letter that the user is finding.
 * <p>
 * <b>clip</b> This Clip is not used in the current version and may be removed in future versions.
 * <p>
 * <b>music</b> This Clip is not used in the current version and may be removed in future versions.
 * <p>
 * <b>audio</b> This Clip array stores the music.
 * <p>
 * <b>alphabet</b> This Clip array stores the sound of the letters.
 * <p>
 * <b>click</b> This Clip array stores the sounds to be played when the user clicks.
 * <p>
 * <b>pics</b> This array of BufferedImage objects stores the background images.
 * <p>
 * <b>t</b> This GameTimer is used to time the game.
 * <p>
 * <b>round1Time</b> This int stores the time spent on the first round.
 * <p>
 * <b>round2Time</b> This int stores the time spent on the second round.
 * <p>
 * <b>round3Time</b> This int stores the time spent on the third round.
 * 
 * 
 * 
 * @author Chua Hock-Chuan for original graphics code, modifed by Esther Yoo, Samantha Unger
 * @version 1.2 06.05.16
 */
public abstract class Levels extends JPanel {
  
  protected Ball[] ball = new Ball[26];
  private static final int UPDATE_RATE = 30;  // Frames per second (fps)
  private static final int NUM_BUBBLES = 26;
  String word;
  protected ArrayList<String>words;

 ContainerBox box;  // The container rectangular box
  private ContainerBox box2;
  
  private DrawCanvas canvas; // Custom canvas for drawing the box/ball
  private DrawLetters canvas2;
  protected int canvasWidth;
  protected int canvasHeight;
  int xCoord;
  int yCoord;
  
  int radius = 50;
  int x;
  int y;
  int speed;
  int angleInDegree;
  
  int background;
  
  char [] letters;
  int currentLetter;
  Clip clip;
  Clip music;
  
  Clip[] audio = new Clip[8];
  Clip[] alphabet = new Clip[26];
  Clip[] click = new Clip[3];
  
  BufferedImage [] pics = new BufferedImage [8];
  
  protected GameTimer t;
  
  Thread gameThread;
  
  int currentWord;
  int[] roundTimes = new int[3];
  
  boolean showRoundDone = false;
  
    /**
   * The readWords method reads the words in from a file to an ArrayList and shuffles the order of the elements in the
   * ArrayList.
   * 
   * @param file String that stores the name of the file to read the words in from 
   */
  public void readWords(String file)
  {
    BufferedReader input;
    int randNum;
    String tempString;
    words=new ArrayList<String>();      
    
    try
    {

      String fileName = file;
      input = new BufferedReader (new FileReader (fileName));
      System.out.println("OK");
      if (!input.readLine().equals("This is a Green Eggs & Sam file."))
      {
        JOptionPane.showMessageDialog (this, "This is not a .GSE file!", "Incompatible File Type", JOptionPane.ERROR_MESSAGE);
      }
      while (true)
      {
        tempString=input.readLine();
        System.out.println(tempString);
        if (tempString!=null)
        {
          System.out.println("W");
        words.add(tempString);
        System.out.println("YES");
        }
        else
        {
          break;
        }
      }
    }
    catch (FileNotFoundException l)
    {
      System.out.println("BAD");
    }
    catch (IOException q)
    {
      System.out.println("Open File IO Error");
    }
    catch (Exception e)
    {
      System.out.println("Open Error");
    }
    
    for (int x=words.size()-1; x>0;x--)
    {
      randNum=(int)(Math.random()*x);
      if (randNum!=x)
      {
        tempString=words.get(x);
        words.set(x,words.get(randNum));
        words.set(randNum, tempString);
      }
    }
  }
  
  /**
   * This constructor sets the value of of the canvasHeight, canvasWidth and calls the loadAudio method.
   * 
   * @param width int that contains the screen width
   * @param height int that contains the screen height
   */
  public Levels(int width, int height) {

    canvasWidth = width;
    canvasHeight = height;
    //loadAudio();

  }
  
    /**
   * This method constructs the necessary objects to play the game.  A nested MouseAdapter class is necessary so that
   * the user's click location can be taken.  A component listener is added to the screen.  A for loop is used to 
   * check each letter.  If statements are used to check letters.  The gameStart() method is called.
   */
  public void startup()
  {
    //box = new ContainerBox(0, 0, canvasWidth, canvasHeight, "grass2.jpg", Color.BLACK);
    
    canvas = new DrawCanvas();
    canvas2 = new DrawLetters();
    this.setLayout(new BorderLayout());
    this.add(canvas, BorderLayout.CENTER);
    this.add(canvas2, BorderLayout.SOUTH);

    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        

        xCoord = e.getX();
        yCoord = e.getY();

        
        System.out.println("XCoord: " + xCoord+ "      " + "YCoord" +yCoord);
        
        for (int z = NUM_BUBBLES-1;z>=0;z--)
        {
          if (Math.sqrt(Math.pow(xCoord-ball[z].returnHorizontalCenter(),2)+Math.pow(yCoord-ball[z].returnVerticalCenter(),2))<=50 && !ball[z].getWasClicked())
          {
            if (ball[z].getLetter() == letters[currentLetter])
            {
              AudioRecordings.effects[0].setMicrosecondPosition(0);
              AudioRecordings.effects[0].start();
              
              //ball[z].setColor(Color.green);
              ball[z].setWasClicked(true);
              ball[z].setSpeed(0);
              ball[z].setRadius(-100);
              ball[z].setLocation(-100,-100);
              currentLetter++;
              if (currentLetter <= letters.length-1)
              {
                AudioRecordings.alphabet[letters[currentLetter]-65].setMicrosecondPosition(0);
                AudioRecordings.alphabet[letters[currentLetter]-65].start();
              }
            }
            else
            {
              AudioRecordings.effects[1].setMicrosecondPosition(0);
              AudioRecordings.effects[1].start();
            }
            if (currentLetter > letters.length-1)
            {
              currentLetter = 0;
              roundTimes[currentWord]=t.getTimeElapsed();
              if (currentWord==2)
              {
                AudioRecordings.background[2].stop();
                System.out.println(roundTimes[0]+"  "+roundTimes[1]+"   "+roundTimes[2]);
                //Main.switchMenu(0);
                Main.frame.getContentPane().removeAll();
                Main.frame.add(new DisplayTime(roundTimes[0], roundTimes[1], roundTimes[2]));
                Main.frame.repaint();
                Main.frame.revalidate();
                return;
              }
              else
              {
                Main.frame.add(new DisplayRounds(currentWord, getLevel()));
                currentWord++;
                word = words.get(currentWord).toUpperCase();
                t.setTimeElapsed(0);
                setBubbles();
                AudioRecordings.alphabet[letters[currentLetter]-65].setMicrosecondPosition(0);
                AudioRecordings.alphabet[letters[currentLetter]-65].start();
              }
            }
            System.out.println("This is bubble number: " + currentLetter);
            System.out.println("Time elapsed is "+ t.getTimeElapsed());

            break;
          }
        }
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
        //box2.set(0, 0, 100, 100);
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
   * This method updates the game objects, with proper collision detection and response. It uses a for loop to update
   * each object.
   */
  public void gameUpdate() {
    for (int z = 0; z < 26; z++)
    {
      ball[z].moveOneStepWithCollisionDetection(box);
    }
    //ball[0].moveOneStepWithCollisionDetection(box);
  }
  
  /** This inner class is a custom drawing panel for the bouncing ball. It overrides the paintComponent() method and 
    * uses for loops to draw each bubble.
   */
  class DrawCanvas extends JPanel {
      /**
   * This method paints components on the screen.  It uses a for loop to draw each bubble.
   * @param g Graphics passed in to allow painting on the frame.
   */
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background
      // Draw the box and the ball
      //draw(g);
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
    
    /** This method is overriden to get the preferred size of the component. 
      * @return Dimension that indicates the preferred size
      */
    @Override
    public Dimension getPreferredSize() {
      return (new Dimension(canvasWidth, canvasHeight));
    }
  }
  
    /** This inner class is a custom drawing panel for the letters. It overrides the paintComponent() method and 
    * uses for loops to draw each bubble.
   */
  class DrawLetters extends JPanel {
          /**
   * This method paints components on the screen. 
   * @param g Graphics passed in to allow painting on the frame.
   */
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background
      
      g.setColor(Colors.boxes);
      for (int x = 0; x < letters.length; x++)
      {
        g.fillRect((x*110) + 300, 0, 100,100);
      }
      g.setFont(new Font("Courier New", Font.PLAIN, 40));
      g.setColor(Colors.letters);
      for (int x = -1; x < currentLetter; x++)
      {
        if (x != -1)
          g.drawString("" + letters[x], (x*100) + 350, 50);
      }
      // Draw the box and the ball
      g.setColor(Color.black);
      g.setFont(new Font("Courier New", Font.PLAIN, 12));
      g.drawString("Time: " + t.getTimeElapsed(), 0, 50);
      BufferedImage back = null;
      }
    
        /** This method is overriden to get the preferred size of the component. 
      * @return Dimension that indicates the preferred size
      */
    @Override
    public Dimension getPreferredSize() {
      return (new Dimension(100, 100));
    }
  }
  

  
  public void setBubbles()
  {
    if (getLevel()!=1)
    {
      Random rand = new Random();
      for (int q = 0; q < word.length(); q++)
      {
        letters[q] = word.charAt(q);
        ball[q].setLocation(rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10,rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10);
        ball[q].setSpeed(generateSpeed());
        //angleInDegree = rand.nextInt(360);
        ball[q].setRadius(radius);
        if (getLevel() == 2)
          ball[q].setSpeed( (int)(Math.random() * (3 - 1) + 1) + 1);
        else
          ball[q].setSpeed( (int)(Math.random() * (8 - 1) + 1) + 1);
        System.out.println(letters[q]);
        ball[q].setLetter(letters[q]);
        ball[q].setWasClicked(false);
      }
      for (int z = word.length(); z < 26; z++)
      {
        ball[z].setLocation(rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10,rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10);
        ball[z].setSpeed(generateSpeed());
        //angleInDegree = rand.nextInt(360);
        ball[z].setRadius(radius);
        if (getLevel() == 2)
          ball[z].setSpeed( (int)(Math.random() * (3 - 1) + 1) + 1);
        else
          ball[z].setSpeed( (int)(Math.random() * (8 - 1) + 1) + 1);
        ball[z].setLetter((char)(65+(int)(Math.random() * (25)) + 1));
        ball[z].setWasClicked(false);
      }
    }
    else
    {
      for (int q = 0; q < word.length(); q++)
      {
        letters[q] = word.charAt(q);
      }
      for (int z = 0 ; z < 26; z ++)
      {
        ball[z].setLocation(50+(z%9)*(2*radius+30), 50+(z/9)*(2*radius+30));
        ball[z].setRadius(radius);
        ball[z].setWasClicked(false);
      }
    }
  }
   
   public abstract int generateSpeed();
   public abstract int getLevel();
}
  