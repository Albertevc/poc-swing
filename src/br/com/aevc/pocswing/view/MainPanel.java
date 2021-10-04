package br.com.aevc.pocswing.view;

import br.com.aevc.pocswing.view.login.LoginPanel;
import br.com.aevc.pocswing.view.menu.TopJMenuBar;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.PAGE_START;
import static javax.swing.BorderFactory.createEmptyBorder;

/**
 * @author alber
 */
class MainPanel extends JPanel {

    public MainPanel() {
        super(new BorderLayout());
        setBorder(createEmptyBorder(0, 0, 5, 0));

        add(new TopJMenuBar(), PAGE_START);

//        showLoginDialog(this);
        LoginPanel.showLoginDialog();
    }

}
