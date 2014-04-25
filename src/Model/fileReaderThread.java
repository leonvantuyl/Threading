package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fileReaderThread implements Runnable
  {
    private File file;
    private int count = 0;
    
    public fileReaderThread(File file)
      {
        this.file = file;
      }

    @Override
    public void run()
      {
        try
          {
            readFile();
          }
        catch (FileNotFoundException ex)
          {
            Logger.getLogger(fileReaderThread.class.getName()).log(Level.SEVERE, null, ex);
          }
        catch (IOException ex)
          {
            Logger.getLogger(fileReaderThread.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    
    private void readFile() throws FileNotFoundException, IOException
      {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        
        while((line = reader.readLine()) != null)
          {
            try
              {
                final byte[] bytes = line.getBytes("UTF-8");

                if(bytes.length == 42)
                  {
                    count++;
                  }
              }
            catch (UnsupportedEncodingException ex)
              {
                Logger.getLogger(fileReaderThread.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        System.out.println(count);
        
      }
  }
