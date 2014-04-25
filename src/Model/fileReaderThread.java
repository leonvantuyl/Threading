package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fileReaderThread implements Runnable
  {

    private int count = 0;
    private final String fileUrl;
    private final Top10 top10;

    public fileReaderThread(String url, Top10 top10)
      {
        this.fileUrl = url;
        this.top10 = top10;
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
        BufferedReader reader = new BufferedReader(new FileReader(fileUrl));
        String line;

        while ((line = reader.readLine()) != null)
          {
            try
              {
                final byte[] bytes = line.getBytes("UTF-8");

                if (bytes.length == 42)
                  {
                    count++;
                  }
              }
            catch (UnsupportedEncodingException ex)
              {
                Logger.getLogger(fileReaderThread.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        if (count > 0)
          {
            this.top10.addResult(fileUrl, count);
          }
      }
  }
