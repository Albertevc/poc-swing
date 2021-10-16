package br.com.aevc.pocswing.view.menu.help;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.stream.Stream;

/**
 * @author alber
 */
class HelpJMenu extends JMenu {

    HelpJMenu(JMenuItem... jMenuItems) {
        super("Ajuda");
        setMnemonic(KeyEvent.VK_N);

        Stream.of(jMenuItems)
                .forEach(this::add);
    }

}
