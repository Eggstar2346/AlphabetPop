
/*
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
 
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
 
public class PrintFile implements Printable {
 
 private String[]names;
 private String[]scores;
 private String[]levels;
  
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
      BufferedImage top = new BufferedImage(5,5,BufferedImage.TYPE_BYTE_GRAY); //idk what i did here, hope its okay
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        
        try 
        {
          top = ImageIO.read(new File("printback.jpg"));
          System.out.println("GOOD");
        } 
        catch (IOException e) 
        {
          System.out.println("NOOOOO");
        } 
        g.drawImage(top,100,100,null);
        g.setFont(new Font("Comic Sans", Font.PLAIN, 25));
        g.drawString("Name", 90, 150);
        g.drawString("Score", 250, 150);
        g.drawString("Level", 330, 150);
        g.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        for (int x = 0 ; x < names.length ; x++)
        {
          g.drawString (names[x],90,180+x*20);
          g.drawString (scores[x],250,180+x*20);
          if (levels[x].equals("1"))
            g.drawString ("Easy",330,180+x*20);
          else if (levels[x].equals("2"))
            g.drawString ("Medium",330,180+x*20);
          else
            g.drawString ("Hard",330,180+x*20);
        }
        //g.drawString("Wow, we did something!", 100, 100);
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
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
              /* The job did not successfully complete */
             }
         }
    }
 
//    public static void main(String args[]) {
//  
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//        JFrame f = new JFrame("Hello World Printer");
//        f.addWindowListener(new WindowAdapter() {
//           public void windowClosing(WindowEvent e) {System.exit(0);}
//        });
//        JButton printButton = new JButton("Print Hello World");
//        printButton.addActionListener(new PrintFile());
//        f.add("Center", printButton);
//        f.pack();
//        f.setVisible(true);
//    }
}
