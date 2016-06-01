import javax.swing.JFrame;
import java.awt.event.*;


/**
 * Main Program for running the bouncing ball as a standalone application.
 */
public class Main {
   // Entry main program
   public static void main(String[] args) {
      // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new JFrame("A World of Balls");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MainMenu m = new MainMenu();
            frame.add(m);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(1200,650);
            
            //while (true)
            //{
            m.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
      if (m.getChoice()==2)
            {
        frame.remove(m);
              frame.add(new AlphabetPopGame(1200, 550)); 
              frame.revalidate();
              //break;
            }
      }
            
});
            

            //}// BallWorld is a JPanel
                        // Preferred size of BallWorld
            
            
            
              // Show it
         }
      });
      //new AudioRecordings();
      
   }
}