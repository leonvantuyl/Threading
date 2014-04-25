/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import Model.fileReaderThread;
import java.io.File;

/**
 *
 * @author Legopiraat
 */
public class Threading
  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        File file = new File("C://bestanden.txt");
        
        (new Thread (new fileReaderThread(file))).start();
      }
  }
