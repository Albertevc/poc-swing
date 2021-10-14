package br.com.aevc.pocswing.view.menu.help;

import javax.swing.*;

public class HelpJMenuFactory {

    private static HelpJMenu helpJMenu;

    public static HelpJMenu createDefault(){
        helpJMenu = new HelpJMenu(
                new AboutJMenuItem()
        );
        return helpJMenu;
    }

    public static HelpJMenu createFrom(JMenuItem... jMenuItems){
        helpJMenu = new HelpJMenu(
                new AboutJMenuItem()
        );
        return helpJMenu;
    }
}
