import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class CombineAudio
{
  public static void main (String [] args)
  {
    for (int x = 0; x < 26; x++)
    {
      try 
      {
        AudioInputStream clip1 = AudioSystem.getAudioInputStream(new File("After.wav"));
        AudioInputStream clip2 = AudioSystem.getAudioInputStream(new File(("" + (char)(65+x)) + ".wav"));
        
        AudioInputStream appendedFiles = 
          new AudioInputStream(
                               new SequenceInputStream(clip1, clip2),     
                               clip1.getFormat(), 
                               clip1.getFrameLength() + clip2.getFrameLength());
        
        AudioSystem.write(appendedFiles, 
                          AudioFileFormat.Type.WAVE, 
                          new File("D:\\" + ("After " + (char)(65+x)) + ".wav"));
      } 
      catch (Exception e) 
      {
        e.printStackTrace();
      }
    }
  }
}