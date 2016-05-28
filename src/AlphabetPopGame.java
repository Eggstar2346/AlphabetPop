import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
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
     
      levelTwo();
      // Init the Container Box to fill the screen
      box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.GREEN);
     
      // Init the custom drawing panel for drawing the game
      canvas = new DrawCanvas();
      this.setLayout(new BorderLayout());
      this.add(canvas, BorderLayout.CENTER);
      
      addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int xCoord = e.getX();
        int yCoord = e.getY();
        System.out.println("XCoord: " + xCoord+ "      " + "YCoord" +yCoord);
        for (int z = NUM_BUBBLES-1;z>=0;z--)
        {
//          System.out.println(Math.sqrt(Math.pow(xCoord-ball[z].x,2)+Math.pow(yCoord-ball[z].y,2)));
//          System.out.println("Horizontal center: " + ball[z].returnHorizontalCenter());
          if (Math.sqrt(Math.pow(xCoord-ball[z].returnHorizontalCenter(),2)+Math.pow(yCoord-ball[z].returnVerticalCenter(),2))<=50 && !ball[z].getWasClicked())
          {
           ball[z].setColor(Color.green);
           ball[z].setWasClicked(true);
           System.out.println("This is bubble number: " + z);
           //erase bubble
           //ball[z].setColor(Color.black, Color.black, Color.black);
           ball[z].setSpeed(0);
           ball[z].setRadius(-100);
           ball[z].setLocation(-100,-100);
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
         }
      });
  
      // Start the ball bouncing
      gameStart();
   }
   
   /** Start the ball bouncing. */
   public void gameStart() {
      // Run the game logic in its own thread.
      Thread gameThread = new Thread() {
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
      gameThread.start();  // Invoke GaemThread.run()
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
    //add(bubbles[0]);
    
  }
  
  public void levelTwo()
  {
    // Init the ball at a random location (inside the box) and moveAngle
      Random rand = new Random();
      //ball[0] = new Ball(x, y, radius, speed, 227, Color.RED, "A", false);
      for (int z = 0 ; z < 26 ; z ++)
      {
        x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
        y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
        speed = (int)(Math.random() * (8 - 1) + 1) + 1;
        //speed = 0;
        angleInDegree = rand.nextInt(360);
        ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, ""+ (char)(65+z), false);
        //add(bubbles[x]);
      }
  }
  
  public void levelThree()
  {
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
