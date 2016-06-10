import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/** <b> Version Information: </b>
  * <p>
  * <b>Author</b> Chua Hock-Chuan, Esther Yoo
  * <b>Version #</b> 1
  * <b>Date</b> 05.27.16
  * <b>Time Spent</b> 1 hour
  * 
  * 
  * @author Esther Yoo
  * @author Chua Hock-Chuan
  * @version 1.1 05.27.16
  * 
  * The ContainerBox class is a regular container box that contains components of the game.
  * It is used to set backgrounds and make the processing required for the bubbles to bounce 
  * off the walls easier.
  * 
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>minX</b> An integer variable that stores the minimum x-coordinate of the ContainerBox.
  * <p>
  * <b>maxX</b> An integer variable that stores the maximum x-coordinate of the ContainerBox.
  * <p>
  * <b>minY</b> An integer variable that stores the minimum y-coordinate of the ContainerBox.
  * <p>
  * <b>maxY</b> An integer variable that stores the maximum y-coordinate of the ContainerBox.
  * <p>
  * <b>imageName</b> A String variable that stores the name of the file containing the ContainerBox's background.
  * <p>
  * <b>colorBorder</b> A Color variable that stores the Color that will be used to colour the ContainerBox's border.
  * <p>
  * <b>pic</b> A BufferedImage variable that stores the background image.
  * <p>
  * <b>DEFAULT_COLOR_FILLED</b> A Color variable that stores default interior colour (black).
  * <p>
  * <b>DEFAULT_COLOR_BORDER</b> A Color variable that stores default border colour (yellow).
  */
public class ContainerBox {
  int minX, maxX, minY, maxY;
  private String imageName;
  private BufferedImage pic;
  private static final Color DEFAULT_COLOR_FILLED = Color.BLACK;
  private static final Color DEFAULT_COLOR_BORDER = Color.YELLOW;
  
  /**
   * The class constructor assigns all the values passed in its parameter to the appropriate instance variables.
   * 
   * Variable pic is assigned by calling the method loadImage();
   *  @param x int of new x coordinate
   * @param y int of new y coordinate
   * @param width int of new width
   * @param height int of new height
   * @param name String for image name
   */
  public ContainerBox(int x, int y, int width, int height, String name) {
    minX = x;
    minY = y;
    maxX = x + width - 1;
    maxY = y + height - 1;
    imageName = name;
    pic = loadImage();
  }
  
  /** The set method sets new boundaries for the box.
    * 
    * minX and minY are determined by their respective parameter passes.
    * maxX and maxY are determined by adding the widths and heights to x and y, then subtracting 1.
    * 
    * @param x int of new x coordinate
    * @param y int of new y coordinate
    * @param width int of new width
    * @param height int of new height
    */
  public void set(int x, int y, int width, int height) {
    minX = x;
    minY = y;
    maxX = x + width - 1;
    maxY = y + height - 1;
  }
  
  /** The loadImage method returns a BufferedImage that was loaded in using the imageName variable.
    * 
    * Inside the try-catch statement, the image file is read in and returned according to imageName. A catch is
    * provided to catch any I/O errors. If the image file was not returned in the try catch, null is returned.
    * 
    * @return BufferedImage that was loaded in
    */
  public BufferedImage loadImage()
  {
    try 
    {
      return ImageIO.read(new File(".//resources//" + imageName));
    } 
    catch (IOException e) 
    {
    }
    return null;
  }
  
  /** The draw method draws the background image in, and draws the outline color according to the variable colorBorder.
    * 
    * @param g This parameter pass is used to access the Graphics class.
    */
  public void draw(Graphics g) {
    g.drawImage(pic, minX, minY, null);
  }
}