/** The GameTimer class is a thread that is used to time the user's game.
 * 
 * <p>
 * <b> Version Information: </b>
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1
 * <b>Date</b> 05.29.16
 * <b>Time Spent</b> 30 minutes
 * <p>
 * <b>Author</b> Esther Yoo
 * <b>Version #</b> 1.1
 * <b>Date</b> 06.01.16
 * <b>Time Spent</b> 5 minutes
 * <b>What Was Changed</b> The timeElapsed variable is no longer set to 0 within the timer() method.  To set this 
 * variable, the new setTimeElapsed() method can be used.
 * <p>
 * <b>Author</b> Samantha Unger
 * <b>Version #</b> 1.2
 * <b>Date</b> 06.03.16
 * <b>Time Spent</b> 5 minutes
 * <b>What Was Changed</b> The catch within the timer method now catches InterruptedException instead of Exception.
 * 
 * 
 * <p>
 * <b> Instance Variables: </b>
 * <p>
 * <b>timeElapsed</b> This int is used to store how much time has elapsed.
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1.2 06.03.16
 */
import java.awt.*;
import java.lang.*;

public class GameTimer extends Thread
{
    private int timeElapsed;

              /**
 * This method is used to increment the timer.  It used a loop so that the timeElapsed variable is incremented
 * repeatedly.  A try catch block is used to catch in case of an InterruptedException.
 */
    public void timer ()
    {
        do
        {
            try
            {
                Thread.sleep (1000);
            }
            catch (InterruptedException e)
            {
            }
            timeElapsed++;
        }
        while (true);
    }

          /**
 * This method returns the value of the private timeElapsed variable.
 */
    public int getTimeElapsed ()
    {
        return timeElapsed;
    }
    
              /**
 * This method sets the value of the private timeElapsed variable.
 * 
 * @param newTimeElapsed  int that is used as the new value for timeElapsed
 */
    public void setTimeElapsed (int newTimeElapsed)
    {
        timeElapsed = newTimeElapsed;
    }

          /**
 * This method is an empty constructor for the class.
 */    
    public GameTimer ()
    {
    }

          /**
 * This method runs the timer() method.
 */
    public void run ()
    {
        timer ();
    }
}