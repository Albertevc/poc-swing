package br.com.aevc.pocswing.view;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.view.menu.TopJMenuBarFactory;

import javax.swing.*;

public class SwingApplicationFactory {

    public static void createDefault(){
        SwingApplication swingApplication = new SwingApplication(
                new MainJDesktopPane(),
                TopJMenuBarFactory.createFrom(ProductController.getInstance())
        );
        SwingApplicationContext.initialize(swingApplication);
    }

    public static void createFrom(
            JDesktopPane jDesktopPane,
            JMenuBar jMenuBar
    ){
        SwingApplication swingApplication =  new SwingApplication(
                jDesktopPane,
                jMenuBar
        );
        SwingApplicationContext.initialize(swingApplication);
    }

}
