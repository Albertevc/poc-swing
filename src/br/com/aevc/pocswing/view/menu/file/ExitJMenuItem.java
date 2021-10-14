package br.com.aevc.pocswing.view.menu.file;

import javax.swing.*;

import static br.com.aevc.pocswing.view.login.LoginJOptionPane.showLoginDialog;

public class ExitJMenuItem extends JMenuItem {

    ExitJMenuItem(){
        super("Sair");
        addActionListener(actionEvent -> showLoginDialog());
    }
}
