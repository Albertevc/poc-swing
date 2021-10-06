package br.com.aevc.pocswing.view;

import br.com.aevc.pocswing.view.session.SessionJPanel;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

/**
 * @author alber
 */
class MainPanel extends JPanel {

    public MainPanel() {
        super(new BorderLayout());
        setBorder(createEmptyBorder(0, 0, 5, 0));

        add(SessionJPanel.INSTANCE);
    }

}
