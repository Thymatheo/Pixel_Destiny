/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.IController;
import contract.IModel;
import controller.Controller;
import model.Model;
import view.IWindow;
import view.Window;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final IModel model = new Model();
        final IWindow window = new Window(model);
        window.getWindowFrame().getWindowPanel().start();
        final IController controller = new Controller(window, model);
        window.getWindowListener().setController(controller);
        controller.play();
    }
}
