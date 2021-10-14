package br.com.aevc.pocswing.view;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.view.menu.TopJMenuBarFactory;

import javax.swing.*;

public class SwingApplicationFactory {

    private static SwingApplication swingApplication;

    public static SwingApplication createDefault(){
        swingApplication = new SwingApplication(
                new MainJDesktopPane(),
                TopJMenuBarFactory.createFrom(ProductController.getInstance())
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
