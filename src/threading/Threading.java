/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import Model.fileReaderThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Legopiraat
 */
public class Threading
  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
      {
        File file = new File("C://bestanden.txt");
        int threadcount = 0;
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        
        while((line = reader.readLine()) != null && threadcount < 11)
          {
            (new Thread (new fileReaderThread(line))).start();
            threadcount++;
          }
      }
  }
