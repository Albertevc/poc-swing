package br.com.aevc.pocswing.view;

import br.com.aevc.pocswing.view.menu.TopJMenuBar;

import javax.swing.*;

/**
 * @author alber
 */
public class SwingApplication {

    private static final SwingApplication INSTANCE = new SwingApplication();

    private final JDesktopPane jDesktopPane;
    private final JMenuBar jMenuBar;
    private final JFrame jFrame;

    private SwingApplication() {
        this.jDesktopPane = new MainJDesktopPane();
        this.jMenuBar = new TopJMenuBar();
//        this.jMenuBar.setVisible(false);
        this.jFrame = new MainJFrame(this.jDesktopPane, this.jMenuBar);
    }

    public static SwingApplication getInstance(){
        return INSTANCE;
    }

    public static void showJMenuBar(){
        INSTANCE.jMenuBar.setVisible(true);
    }

    public static void addJInternalFrame(JInternalFrame jInternalFrame){
        INSTANCE.jDesktopPane.add(jInternalFrame);
    }

    public static void removeJInternalFrame(){
        INSTANCE.jDesktopPane.removeAll();
    }

}
