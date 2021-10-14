package br.com.aevc.pocswing.view.menu.file;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.stream.Stream;

/**
 * @author alber
 */
class FileJMenu extends JMenu {

    FileJMenu(JMenuItem... jMenuItems) {
        super("Arquivo");
        setMnemonic(KeyEvent.VK_N);

        Stream.of(jMenuItems).forEach(jMenuItem -> {
                    add(jMenuItem);
                    addSeparator();
                }
        );

    }

}
