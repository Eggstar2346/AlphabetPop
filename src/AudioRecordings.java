import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

/** The AudioRecordings class contains all the recordings we will use for our game.
  * 
  * @author Samantha Unger, Esther Yoo
  * @version 1 05.27.16
  */

public class AudioRecordings
{
  static Clip[] background = new Clip[7];
  static Clip[] alphabet = new Clip[26];
  static Clip[] effects = new Clip[6];
  
   /**
   * This constructor loads all of the audio clips into the correct arrays.
   */
  public AudioRecordings()
  {
    try
    {
      //load background
      for (int x = 0; x < background.length; x++)
      {
        background[x] = AudioSystem.getClip();
        File backgroundClip = new File("Music_" + (x+1) + ".wav");
        AudioInputStream backgroundClipStream = AudioSystem.getAudioInputStream(backgroundClip);
        background[x].open(backgroundClipStream);
      }
      //load alphabet
      for (int x = 0; x < alphabet.length; x++)
      {
        alphabet[x] = AudioSystem.getClip();
        File alphabetClip = new File(("" + (char)(65+x)) + ".wav");
        AudioInputStream alphabetClipStream = AudioSystem.getAudioInputStream(alphabetClip);
        alphabet[x].open(alphabetClipStream);
      }
      //load effects
      for (int x = 0; x < 3; x++)
      {
        effects[x] = AudioSystem.getClip();
        File effectsClip = new File(("Music_" + (x+8) + ".wav"));
        AudioInputStream effectsClipStream = AudioSystem.getAudioInputStream(effectsClip);
        effects[x].open(effectsClipStream);
      }
      effects[3] = AudioSystem.getClip();
      File effectsClip = new File(("Click the Letter.wav"));
      AudioInputStream effectsClipStream = AudioSystem.getAudioInputStream(effectsClip);
      effects[3].open(effectsClipStream);
      effects[4] = AudioSystem.getClip();
      File effectsClip2 = new File(("Before.wav"));
      AudioInputStream effectsClipStream2 = AudioSystem.getAudioInputStream(effectsClip2);
      effects[4].open(effectsClipStream2);
      effects[5] = AudioSystem.getClip();
      File effectsClip3 = new File(("After.wav"));
      AudioInputStream effectsClipStream3 = AudioSystem.getAudioInputStream(effectsClip3);
      effects[5].open(effectsClipStream3);
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
   * This method changes the volume of a given clip.
   * 
   * @param volAdjust float that stores the amount to adjust the volume by
   * @param clipNum int that stores the index of the clip to have its volume altered
   */
  public static void volume(float volAdjust, Clip clip)
  {
    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    gainControl.setValue(volAdjust);
  }
  
  public static void oneAfterAnother ()
  {
    byte[] buffer = new byte[4096];
    try {
      File file = new File ("Click the letter.wav");
      AudioInputStream is = AudioSystem.getAudioInputStream(file);
      AudioFormat format = is.getFormat();
      SourceDataLine line = AudioSystem.getSourceDataLine(format);
      line.open(format);
      line.start();
      while (is.available() > 0) 
      {
        int len = is.read(buffer);
        line.write(buffer, 0, len);
      }
      line.drain();
      line.close();
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
//    try {
//      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
//      AudioFormat format = audioStream.getFormat();
//      DataLine.Info info = new DataLine.Info(Clip.class, format);
//      Clip audioClip = (Clip) AudioSystem.getLine(info);
//      audioClip.addLineListener(this);
//      audioClip.open(audioStream);
//      audioClip.start();
//      
//      while (!playCompleted) {
//        // wait for the playback completes
//        try {
//          Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//          ex.printStackTrace();
//        }
//      }
//      
//      audioClip.close();
//      
//    } catch (UnsupportedAudioFileException ex) {
//      System.out.println("The specified audio file is not supported.");
//      ex.printStackTrace();
//    } catch (LineUnavailableException ex) {
//      System.out.println("Audio line for playing back is unavailable.");
//      ex.printStackTrace();
//    } catch (IOException ex) {
//      System.out.println("Error playing the audio file.");
//      ex.printStackTrace();
//    }
//  }
}
}