package br.com.aevc.pocswing.view.session;

import br.com.aevc.pocswing.view.menu.TopJMenuBar;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class SessionJPanel extends JPanel {

    public static final SessionJPanel INSTANCE = new SessionJPanel();

    private SessionJPanel() {
        super(new BorderLayout());
        setBorder(createEmptyBorder(0, 0, 5, 0));

        add(new TopJMenuBar(), BorderLayout.PAGE_START);

        setVisible(false);
    }

}
