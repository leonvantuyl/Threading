/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Top10;
import Model.fileReaderThread;
import View.View;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Legopiraat
 */
public class Controller
  {
    private View view;
    private Top10 top10;

    public Controller()
      {
        this.top10 = new Top10();
      }

    public void readFile()
      {
        File file = new File("C://bestanden.txt");

        try
          {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null)
              {
                (new Thread(new fileReaderThread(line, top10))).start();
              }
          }
        catch (Exception e)
          {
            System.err.println(e);
          }
      }

    public void printTop10()
      {
        top10.showTop10();
      }

    public void setView(View view)
      {
        this.view = view;
      }
  }
