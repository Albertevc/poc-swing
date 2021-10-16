package br.com.aevc.pocswing.view;

import javax.swing.*;

import static br.com.aevc.pocswing.util.ApplicationPropertiesUtil.getProperty;
import static java.lang.Boolean.parseBoolean;

/**
 * @author alber
 */
public class SwingApplication {

    private final JDesktopPane jDesktopPane;
    private final JMenuBar jMenuBar;

    SwingApplication(
            JDesktopPane jDesktopPane,
            JMenuBar jMenuBar
    ) {
        this.jDesktopPane = jDesktopPane;
        this.jMenuBar = jMenuBar;
        if (parseBoolean(getProperty("poc-swing.security.active", "false"))) {
            this.jMenuBar.setVisible(false);
        }
         new MainJFrame(this.jDesktopPane, this.jMenuBar);
    }

    public void showJMenuBar() {
        this.jMenuBar.setVisible(true);
    }

    public void addJInternalFrame(JInternalFrame jInternalFrame) {
        this.jDesktopPane.add(jInternalFrame);
    }

    public void removeJInternalFrame(JInternalFrame jInternalFrame) {
        this.jDesktopPane.remove(jInternalFrame);
    }

}
