package br.com.aevc.pocswing.view.menu.file;

import br.com.aevc.pocswing.view.util.ViewUtil;

import javax.swing.*;

public class ConfigurationJMenuItem extends JMenuItem {

    ConfigurationJMenuItem() {
        super(
                "Configuração",
                ViewUtil.imageIconFrom("resources/icon/gear.png")
        );
    }

}
