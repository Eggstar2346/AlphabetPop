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
  static Clip[] effects = new Clip[3];
  
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
      for (int x = 0; x < effects.length; x++)
      {
        effects[x] = AudioSystem.getClip();
        File effectsClip = new File(("Music_" + (x+8) + ".wav"));
        AudioInputStream effectsClipStream = AudioSystem.getAudioInputStream(effectsClip);
        effects[x].open(effectsClipStream);
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
}