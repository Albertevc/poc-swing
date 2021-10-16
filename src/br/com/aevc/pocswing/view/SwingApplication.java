package br.com.aevc.pocswing.view;

import javax.swing.*;

import static br.com.aevc.pocswing.util.ApplicationPropertiesUtil.getProperty;

/**
 * @author alber
 */
public class SwingApplication {

    private final JDesktopPane jDesktopPane;
    private final JMenuBar jMenuBar;
    private final JFrame jFrame;

    SwingApplication(
            JDesktopPane jDesktopPane,
            JMenuBar jMenuBar
    ) {
        this.jDesktopPane = jDesktopPane;
        this.jMenuBar = jMenuBar;
        if (Boolean.valueOf(getProperty("poc-swing.security.active", "false"))) {
            this.jMenuBar.setVisible(false);
        }
        this.jFrame = new MainJFrame(this.jDesktopPane, this.jMenuBar);
    }

    public void showJMenuBar() {
        this.jMenuBar.setVisible(true);
    }

    public void addJInternalFrame(JInternalFrame jInternalFrame) {
        this.jDesktopPane.add(jInternalFrame);
    }

    public void removeJInternalFrame() {
        this.jDesktopPane.removeAll();
    }

}
