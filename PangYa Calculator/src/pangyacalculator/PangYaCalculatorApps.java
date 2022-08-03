/*
 * PangYaCalculatorApps.java
 */

package pangyacalculator;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The PangYaCalculatorApps class of the application.
 */
public class PangYaCalculatorApps extends SingleFrameApplication {

    /**
     * At startup create and show the PangYaCalculatorApps frame of the application.
     */
    @Override protected void startup() {
        show(new PangYaCalculatorView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of PangYaCalculatorApps
     */
    public static PangYaCalculatorApps getApplication() {
        return Application.getInstance(PangYaCalculatorApps.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(PangYaCalculatorApps.class, args);
    }
}
