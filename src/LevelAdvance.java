/**
 * Auto Generated Java Class.
 */
public class LevelAdvance {
  
private BufferedImage image;
  
          /**
 * This is the constructor that constructs the BufferedImage and checks where the user clicks so they can be directed 
 * to the corresponding page.  If the user clicks "Yes", the window is closed using a static method from the Main class.
 * If the user clicks "No", a static method from the Main class is used to bring the user to the menu.  This method 
 * also has a nested inner class.  MouseAdapter is used to see where the user has clicked.  A try catch block is used
 * to trap in case the image cannot be read in.  An if statement is used to determine where the user has clicked.
 * 
 * <p>
 * <b>Local variables: </b>
 * <p>
 * <b>xCoord </b> This int is used to know what the x-coordinate is of the location the user clicked.
 * <p>
 * <b>yCoord </b> This int is used to know what the y-coordinate is of the location the user clicked.
 */
  public LevelAdvance ()
  {
    System.out.println("YAS");
    try 
    {
      image = ImageIO.read(new File("Level.jpg"));
      System.out.println("GOOD");
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    repaint();
    
    addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
      int xCoord = e.getX();
      int yCoord = e.getY();
      System.out.println(xCoord+ "      "+yCoord);
      if (xCoord>=217&&xCoord<=1016)
      {
        if (yCoord>=162&&yCoord<=211)
        {
          System.out.println("Yes");
          Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
        }
        else 
        {
          if (yCoord>=363&&yCoord<=412)
          {
            System.out.println("No");
            Main.switchMenu(0);
          }
        }
      }
    }
});
  }
  
  
        /**
* This is the method that paints components on the frame.  It calls the super's paintComponent method, passing in
* g, and draws the image.
* 
* @param g Graphics passed in to allow painting on the frame.
*/ 
   public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.drawImage(image, 0, 0, null);
    System.out.println("YAY");
  }
  
}
