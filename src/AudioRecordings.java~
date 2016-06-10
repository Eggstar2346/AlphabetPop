import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

/** <b> Version Information: </b>
  * <p>
  * <b>Author</b> Esther Yoo
  * <b>Version #</b> 1
  * <b>Date</b> 06.01.16
  * <b>Time Spent</b> 2 hours
  * 
  * @author Esther Yoo
  * @version 1 06.05.16
  * 
  * The AudioRecordings class loads all the audio recordings we will use for our game and puts them in static arrays, 
  * making them easily accessible.
  * 
  * 
  * 
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>background</b> A static Clip array that stores references to all the background music.
  * <p>
  * <b>alphabet</b> A static Clip array that stores references to all the the clips that go "Click the letter [...]!".
  * <p>
  * <b>alphabetB</b> A static Clip array that stores references to all the the clips that go 
  * "Click the letter that comes before [...]!".
  * <p>
  * <b>alphabetA</b> A static Clip array that stores references to all the the clips that go 
  * "Click the letter that comes after [...]!".
  * <p>
  * <b>effects</b> A static Clip array that stores all the sound effects (ex. bubble popping) used in the game.
  */

public class AudioRecordings extends Thread
{
  static Clip[] background = new Clip[7];
  static Clip[] alphabet = new Clip[26];
  static Clip[] alphabetB = new Clip[25];
  static Clip[] alphabetA = new Clip[25];
  static Clip[] effects = new Clip[3];
  Clip clip;
  
   /**
   * This constructor calls the method that loads all of the audio clips into the correct arrays.
   */ 
  public AudioRecordings ()
  {
    loadAudio();
  }
  
  /**
   * This method loads all rhe audio into their appropriate arrays.
   * 
   * Firstly, the entire method is inside a try-catch statement (opening Clips may throw lots of errors!).
   * Next, the audio clips are read in one by one using for-loops.
   * The first for-loop loads the background music files/
   * The second for-loop loads the regular "Click the letter [...]" files.
   * The third for-loop loads the audio clips that begin "Click the letter that comes before [...]".
   * The fourth for-loop loads the audio clips that begin "Click the letter that comes after [...]".
   * The fifth for-loop loads the effects.
   */
  public void loadAudio()
  {
    try
    {
      //load background
      for (int x = 0; x < background.length; x++)
      {
        background[x] = AudioSystem.getClip();
        File backgroundClip = new File(".//resources//Music_" + (x+1) + ".wav");
        AudioInputStream backgroundClipStream = AudioSystem.getAudioInputStream(backgroundClip);
        background[x].open(backgroundClipStream);
      }
      //load alphabet regular
      for (int x = 0; x < alphabet.length; x++)
      {
        alphabet[x] = AudioSystem.getClip();
        File alphabetClip = new File((".//resources//Click the letter " + (char)(65+x)) + ".wav");
        AudioInputStream alphabetClipStream = AudioSystem.getAudioInputStream(alphabetClip);
        alphabet[x].open(alphabetClipStream);
      }
      //load alphabet before
      for (int x = 0; x < alphabetB.length; x++)
      {
        alphabetB[x] = AudioSystem.getClip();
        File alphabetBClip = new File((".//resources//Before " + (char)(65+x+1)) + ".wav");
        AudioInputStream alphabetBClipStream = AudioSystem.getAudioInputStream(alphabetBClip);
        alphabetB[x].open(alphabetBClipStream);
      }
      //load alphabet after
      for (int x = 0; x < alphabetA.length; x++)
      {
        alphabetA[x] = AudioSystem.getClip();
        File alphabetAClip = new File((".//resources//After " + (char)(65+x)) + ".wav");
        AudioInputStream alphabetAClipStream = AudioSystem.getAudioInputStream(alphabetAClip);
        alphabetA[x].open(alphabetAClipStream);
      }
      //load effects
      for (int x = 0; x < 3; x++)
      {
        effects[x] = AudioSystem.getClip();
        File effectsClip = new File((".//resources//Music_" + (x+8) + ".wav"));
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
  
  /**
   * This static method stops the specified alphabet clip, then sets MicrosecondPosition to 0 and plays the audio of the
   * next specified alphabet clip.
   * 
   * @param stop int that stores the index of alphabet clip it is supposed to stop.
   * @param play int that stores the index of alphabet clip it is supposed to play.
   */
  public static void playLevelsOneTwo(int stop, int play)
  {
    AudioRecordings.alphabet[stop-65].stop();
    AudioRecordings.alphabet[play-65].setMicrosecondPosition(0);
    AudioRecordings.alphabet[play-65].start();
  }
  
  /**
   * This static method stops the specified alphabet clip, then sets MicrosecondPosition to 0 and plays the audio of the
   * next specified alphabet clip, which is decided depending on the value of the passed in rand variable.
   * 
   * @param rand int that stores whether the clip being played is "Click the letter that comes before [...]" or
   * "Click the letter that comes after [...]".
   * @param stop int that stores the index of alphabetB/alphabetA clip it is supposed to stop.
   * @param play int that stores the index of alphabetB/alphabetA clip it is supposed to play.
   */
  public static void playLevelThree(int rand, int stop, int play)
  {
    if (stop>=66)
      AudioRecordings.alphabetB[stop-66].stop();
    if (stop>=65 && stop <= 89)
      AudioRecordings.alphabetA[stop-65].stop();
    if (rand == 1)
    {
      AudioRecordings.alphabetB[play-65].setMicrosecondPosition(0);
      AudioRecordings.alphabetB[play-65].start();
    }
    else
    {
      AudioRecordings.alphabetA[play-66].setMicrosecondPosition(0);
      AudioRecordings.alphabetA[play-66].start();
    }
  }
}