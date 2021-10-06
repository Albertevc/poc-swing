package br.com.aevc.pocswing.view;

import br.com.aevc.pocswing.view.login.LoginPanel;

import javax.swing.*;

/**
 * @author alber
 */
public class ViewLoader {

    private static JFrame mainView;

    public static JFrame load() {
        if (mainView == null) {
            mainView = new MainView(new MainPanel());
            LoginPanel.showLoginDialog();
        }
        return mainView;
    }

}
