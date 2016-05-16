import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/** A demonstration of simple animation in a JPanel.
  * Uses Java Timer objects to do a delayed repainting of a panel
  * to create an animation effect.  Requires file spot.gif in the
  * same folder.
  *
  * <p>
  * Note that there are two kinds of animation going on here:
  * 1) The "dancing" of Spot himself (which is not because of my
  *    code, but rather because the spot.gif file is an animated 
  *    GIF image that I downloaded off the web)
  * 2) Spot moving across the screen, which IS because of my code.
  *
  * @author Martin Stepp
  * @version Thursday, November 9, 2000
  */
public class AnimationDemo extends JFrame implements ActionListener {
 private JButton goButton = null;
 private AnimationPanel animatedPane = null;
 
 /** Runs the program. */
 public static void main(String[] args) {
  AnimationDemo demo = new AnimationDemo();
  demo.show();
 }
 
 
 /** Constructs a new animation frame, sets up events, and does layout. */
 public AnimationDemo() {
  super("CS335 Marty's Animation Demo");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  animatedPane = new AnimationPanel("spot.gif");
  goButton = new JButton("Go");
  goButton.addActionListener(this);
  JLabel infoLabel = new JLabel("Set the two endpoints, then click the button!");
  
  // layout
  JPanel contentPane = new JPanel(new BorderLayout());
  contentPane.add(goButton, BorderLayout.NORTH);
  contentPane.add(animatedPane, BorderLayout.CENTER);
  contentPane.add(infoLabel, BorderLayout.SOUTH);
  setContentPane(contentPane);
  
  pack();  // resize frame so its size is "just right"
  show();
 }
 
 
 public void actionPerformed(ActionEvent event) {
  animatedPane.animate();

  if (goButton.getText().equals("Go"))
   goButton.setText("Reset");
  else
   goButton.setText("Go");
 }
}



/** A JPanel that draws an animated picture when so instructed. */
class AnimationPanel extends JPanel {
 private static final int NUM_MILLISECONDS = 10;
 
 private Point   myStartPoint, myEndPoint;
 private int     myPercentage;
 private boolean myToggle;
 private boolean myIsAnimated;
 private Image   myImage;
 private int     myImageWidth, myImageHeight;
 private Timer   myTimer;

 /** Constructs a new AnimationPanel for the image with the given file name.
   *
   * @param fileName the file name of the image to load.
   */
 public AnimationPanel(String fileName) {
  Dimension size = new Dimension(myImageWidth + 400, myImageHeight + 200);
  setPreferredSize(size);
  setBackground(Color.white);
  
  myStartPoint = new Point(0, 0);
  myEndPoint   = new Point(size.width - 50, size.height - 50);
  myPercentage = 0;
  myToggle     = false;
  myIsAnimated = false;
  
  // set up the image to animate (in this case, the 7-Up Spot)
  myImage = Toolkit.getDefaultToolkit().getImage(fileName);
  MediaTracker mt = new MediaTracker(this);
  mt.addImage(myImage, 0);
  try {
   mt.waitForAll();
  } catch (InterruptedException ie) {
   System.out.println("Error while loading image: " + ie);
  }
  
  myImageWidth  = myImage.getWidth(this);
  myImageHeight = myImage.getHeight(this);
  
  // set up a Timer to repaint every 10 milliseconds.
  //
  // When passed an int number of milliseconds and an ActionListener,
  // the Timer fires ActionEvents at the given intervals
  // (in this case, every 10 ms) from the time .start() is
  // called until the time .stop() is called.
  //
  ActionListener updater = new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    myPercentage++;
    if (myPercentage >= 100)
     myTimer.stop();
    repaint();
   }
  };
  myTimer = new Timer(NUM_MILLISECONDS, updater);
  
  // set up a MouseListener to change the start and end points
  MouseListener clicker = new MouseAdapter() {
   /** Stops animation and resets either start or end point. */
   public void mousePressed(MouseEvent event) {
    if (myToggle)
     myStartPoint = event.getPoint();
    else
     myEndPoint = event.getPoint();

    myToggle = !myToggle;
    myIsAnimated = false;
    myTimer.stop();
    myPercentage = 0;
    repaint();
   }
  };
  addMouseListener(clicker);
 }


 /** Paints this AnimationPanel on the screen.
   *
   * @param g the graphical context of the panel.
   */
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  
  // get difference between start and end points to see how
  // far I need to move Spot
  int xDiff = myEndPoint.x - myStartPoint.x;
  int yDiff = myEndPoint.y - myStartPoint.y;
  
  // draw Spot!
  g.drawImage(myImage,
   myStartPoint.x + xDiff * myPercentage / 100,
   myStartPoint.y + yDiff * myPercentage / 100,
   this
  );

  // draw Start and End Strings at start and end points (offset a bit)
  g.drawString("Start",
   myStartPoint.x + myImageWidth / 2,
   myStartPoint.y + myImageWidth / 2
  );
  g.drawString("End",
   myEndPoint.x + myImageWidth / 2,
   myEndPoint.y + myImageWidth / 2
  );
  
  if (myIsAnimated  &&  myPercentage < 100) {
   // draw "look at him go" in center of panel
   String message = "Look at him go!";
   Dimension size = getSize();
   Font font = getFont();
   FontMetrics fm = getFontMetrics(font);
   int x = (size.width - fm.stringWidth(message)) / 2;
   int y = (size.height - font.getSize()) / 2;;
   
   g.drawString(message, x, y);
  }
 }


 /** Instructs this AnimationPanel to restart its animation sequence. */
 public void animate() {
  myPercentage = 0;
  myIsAnimated = !myIsAnimated;
  
  if (myIsAnimated)
   myTimer.start();
  else
   myTimer.stop();
 }
}