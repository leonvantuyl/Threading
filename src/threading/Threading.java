
package threading;

import Controller.Controller;
import View.View;

public class Threading
  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        Controller controller = new Controller();

        View view = new View();
        view.setVisible(true);

        controller.setView(view);
        view.setController(controller);
        
      }
  }
