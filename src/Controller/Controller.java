/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Top10;
import Model.fileReaderThread;
import View.View;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFileChooser;

/**
 *
 * @author Legopiraat
 */
public class Controller
  {

    private View view;
    private final Top10 top10;
    private final ArrayList<File> files = new ArrayList<>();

    public Controller()
      {
        this.top10 = new Top10();
      }

    public void readFile()
      {
        // File file = new File("C://bestanden.txt");

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (File file : files)
          {
            try
              {
                Runnable fileReaderThread = new fileReaderThread(file.toString(), top10);
                executor.submit(fileReaderThread);
              }
            catch (Exception e)
              {
                System.err.println(e);
              }
          }
        executor.shutdown();
        while (!executor.isTerminated())
          {
          }
        printTop10();
      }

    public void choiceFile()
      {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION)
          {
            File folder = chooser.getSelectedFile();
            fileListCreator(folder, files);
          }
      }

    public void fileListCreator(File directoryName, ArrayList<File> files)
      {
        File directory = directoryName;

        // try to get all files from the folder
        try
          {
            File[] fList = directory.listFiles();

            for (File file : fList)
              {
                if (file.isFile())
                  {
                    files.add(file);
                  }
                else if (file.isDirectory())
                  {
                    fileListCreator(file, files);
                  }
              }
          }
        catch (Exception e)
          {
            System.out.println(e);
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
