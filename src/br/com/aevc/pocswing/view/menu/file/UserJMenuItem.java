package br.com.aevc.pocswing.view.menu.file;

import br.com.aevc.pocswing.view.SwingApplicationContext;
import br.com.aevc.pocswing.view.user.UserJInternalFrame;

import javax.swing.*;

public class UserJMenuItem extends JMenuItem {

    UserJMenuItem(){
        super("Cadastro de Usuários");
        addActionListener(actionEvent -> SwingApplicationContext.getSwingApplication()
                .addJInternalFrame(new UserJInternalFrame(1)));
    }
}
