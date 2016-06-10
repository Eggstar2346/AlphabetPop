 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
/**
 * This class is used to print the file.  When constructed, it produces a dialog box that allows you to print to your
 * printer correctly.
 * <b> Version Information: </b>
  * <p>
  * <b>Author</b> Oracle and its affiliates, Samantha Unger
  * <b>Version #</b> 1
  * <b>Date</b> 05.27.16
  * <b>Time Spent</b> 2.5 hours
  * <p>
  * <b>Author</b> Samantha Unger
  * <b>Version #</b> 1.1
  * <b>Date</b> 06.08.16
  * <b>Time Spent</b> 2 hours
  * <b>What Was Changed</b> Formatting of printed image was improved to make it more effective and compelling.
  * 
  * 
  * 
  * @author Oracle and its affiliates, Samantha Unger
  * @version 1.1 05.27.16
  * 
  * 
  * <p>
  * <b>Instance variables: </b>
  * <p>
  * <b>names</b> This String array is used to store the names to be printed.
  * <p>
  * <b>scores</b> This String array is used to store the scores to be printed.
  * <p>
  * <b>levels</b> This String array is used to store the levels to be printed.
 * <p>
 * 
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 

 
public class PrintFile implements Printable {
 
 private String[]names;
 private String[]scores;
 private String[]levels;
  
         /**
* This is the method that prints the file.  It constructs a BufferedImage and translates X and Y values to prevent
* clipping from outside the imageable area.  Then, a try block is used while reading in a heading.  Then, the heading
* and scores are drawn. 
* 
* @param g Graphics is passed in to allow drawing.
* @param pf PageFormat is passed in to represent the format of the page.
* @param page int is passed in to represent the page.
*/ 
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
      BufferedImage top = new BufferedImage(5,5,BufferedImage.TYPE_BYTE_GRAY); 
        if (page > 0) { 
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        
        try 
        {
          top = ImageIO.read(new File(".//resources//printback2.jpg"));
          System.out.println("GOOD");
        } 
        catch (IOException e) 
        {
          System.out.println("NOOOOO");
        } 
        g.drawImage(top,110,80,null);
        g.setFont(new Font("Comic Sans", Font.PLAIN, 25));
        g.drawString("Name", 125, 350);
        g.drawString("Score", 270, 350);
        g.drawString("Level", 400, 350);
        g.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        for (int x = 0 ; x < names.length ; x++)
        {
          g.drawString (names[x],125,380+x*20);
          g.drawString (scores[x],270,380+x*20);
          if (levels[x].equals("1"))
            g.drawString ("Easy",400,380+x*20);
          else if (levels[x].equals("2"))
            g.drawString ("Medium",400,380+x*20);
          else
            g.drawString ("Hard",400,380+x*20);
        }
        return PAGE_EXISTS;
    }
 
             /**
* This is the method that prints the file.  It constructs a BufferedImage and translates X and Y values to prevent
* clipping from outside the imageable area.  Then, a try block is used while reading in a heading.  Then, the heading
* and scores are drawn. 
* 
* @param newNames This String array is passed in as the new names associated with high scores.
* @param newScores This String array is passed in as the new high scores.
* @param newLevels This String array is passed in as the new levels associated with high scores.
*/ 
    public PrintFile (String[]newNames, String[]newScores, String[]newLevels) {
      names=newNames;
      scores=newScores;
      levels=newLevels;
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
               JOptionPane.showMessageDialog(new JFrame(),"The scores cannot be printed.","Printing Error!",JOptionPane.ERROR_MESSAGE);
             }
         }
    }
 
}
