import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

/** The AudioRecordings class contains all the recordings we will use for our game.
  * 
  * @author Samantha Unger, Esther Yoo
  * @version 1 05.27.16
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
   * This constructor loads all of the audio clips into the correct arrays.
   */
  public AudioRecordings(Clip clip)
  {
    loadAudio();
    this.clip = clip;
  }
  
  public AudioRecordings ()
  {
    loadAudio();
  }
  
  public void setMicrosecondPosition (int time)
  {
    clip.setMicrosecondPosition(time);
  }
  
  public void audioRecordings ()
  {
    clip.start();
  }
  
  public void run()
  {
    audioRecordings();
  }
    
  public void loadAudio()
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
      //load alphabet regular
      for (int x = 0; x < alphabet.length; x++)
      {
        alphabet[x] = AudioSystem.getClip();
        File alphabetClip = new File(("Click the letter " + (char)(65+x)) + ".wav");
        AudioInputStream alphabetClipStream = AudioSystem.getAudioInputStream(alphabetClip);
        alphabet[x].open(alphabetClipStream);
      }
      //load alphabet before
      for (int x = 0; x < alphabetB.length; x++)
      {
        alphabetB[x] = AudioSystem.getClip();
        File alphabetBClip = new File(("Before " + (char)(65+x+1)) + ".wav");
        AudioInputStream alphabetBClipStream = AudioSystem.getAudioInputStream(alphabetBClip);
        alphabetB[x].open(alphabetBClipStream);
      }
      //load alphabet after
      for (int x = 0; x < alphabetA.length; x++)
      {
        alphabetA[x] = AudioSystem.getClip();
        File alphabetAClip = new File(("After " + (char)(65+x)) + ".wav");
        AudioInputStream alphabetAClipStream = AudioSystem.getAudioInputStream(alphabetAClip);
        alphabetA[x].open(alphabetAClipStream);
      }
      //load effects
      for (int x = 0; x < 3; x++)
      {
        effects[x] = AudioSystem.getClip();
        File effectsClip = new File(("Music_" + (x+8) + ".wav"));
        AudioInputStream effectsClipStream = AudioSystem.getAudioInputStream(effectsClip);
        effects[x].open(effectsClipStream);
      }
//      effects[3] = AudioSystem.getClip();
//      File effectsClip = new File(("Click the Letter.wav"));
//      AudioInputStream effectsClipStream = AudioSystem.getAudioInputStream(effectsClip);
//      effects[3].open(effectsClipStream);
//      effects[4] = AudioSystem.getClip();
//      File effectsClip2 = new File(("Before.wav"));
//      AudioInputStream effectsClipStream2 = AudioSystem.getAudioInputStream(effectsClip2);
//      effects[4].open(effectsClipStream2);
//      effects[5] = AudioSystem.getClip();
//      File effectsClip3 = new File(("After.wav"));
//      AudioInputStream effectsClipStream3 = AudioSystem.getAudioInputStream(effectsClip3);
//      effects[5].open(effectsClipStream3);
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
  
  public static void playLevelsOneTwo(int stop, int play)
  {
    AudioRecordings.alphabet[stop-65].stop();
    AudioRecordings.alphabet[play-65].setMicrosecondPosition(0);
    AudioRecordings.alphabet[play-65].start();
  }
  
  public static void playLevelThree(int rand, int stop, int play)
  {
    System.out.println("STOP: " + stop);
        if (stop<89)
    AudioRecordings.alphabetB[stop-65].stop();
    if (stop>65)
    AudioRecordings.alphabetA[stop-66].stop();
    //System.out.println(AudioRecordings.alphabetA[stop-66].toString());
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
  
  public static void oneAfterAnother (String wavFile1, String wavFile2)
  {
//    byte[] buffer = new byte[4096];
//    try {
//      File file = new File ("Click the letter.wav");
//      AudioInputStream is = AudioSystem.getAudioInputStream(file);
//      AudioFormat format = is.getFormat();
//      SourceDataLine line = AudioSystem.getSourceDataLine(format);
//      line.open(format);
//      line.start();
//      while (is.available() > 0) 
//      {
//        int len = is.read(buffer);
//        line.write(buffer, 0, len);
//      }
//      line.drain();
//      line.close();
//    } 
//    catch (Exception e) {
//      e.printStackTrace();
//    }
    
//    public void actionPerformed (ActionEvent e)
//    {
//      
//    }
//    try {
//      AudioInputStream clip1 = AudioSystem.getAudioInputStream(new File(wavFile1));
//      AudioInputStream clip2 = AudioSystem.getAudioInputStream(new File(wavFile2));
//      
//      AudioInputStream appendedFiles = 
//        new AudioInputStream(
//                             new SequenceInputStream(clip1, clip2),     
//                             clip1.getFormat(), 
//                             clip1.getFrameLength() + clip2.getFrameLength());
//      
//      AudioSystem.write(appendedFiles, 
//                        AudioFileFormat.Type.WAVE, 
//                        new File("D:\\wavAppended.wav"));
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
    
    
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