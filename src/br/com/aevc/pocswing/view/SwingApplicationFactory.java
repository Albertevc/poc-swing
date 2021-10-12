package br.com.aevc.pocswing.view;

import br.com.aevc.pocswing.view.menu.TopJMenuBar;

import javax.swing.*;

public class SwingApplicationFactory {

    private static SwingApplication swingApplication;

    public static SwingApplication createDefault(){
        swingApplication = new SwingApplication(
                new MainJDesktopPane(),
                new TopJMenuBar()
        );
        SwingApplicationContext.initialize(swingApplication);
        return swingApplication;
    }

    public static SwingApplication createFrom(
            JDesktopPane jDesktopPane,
            JMenuBar jMenuBar
    ){
        swingApplication =  new SwingApplication(
                jDesktopPane,
                jMenuBar
        );
        SwingApplicationContext.initialize(swingApplication);
        return swingApplication;
    }

}
