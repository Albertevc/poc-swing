package br.com.aevc.pocswing.view.user;

import javax.swing.*;
import java.beans.PropertyVetoException;

public class UserJInternalFrame extends JInternalFrame {

    static final int xPosition = 30, yPosition = 30;

    public UserJInternalFrame(int openFrameCount) {
        super("Cadastro de usuários",
                false, // resizable
                true, // closable
                false, // maximizable
                true);// iconifiable
        try {
            setMaximum(true);
            // Set the window's location.
            setLocation(xPosition * openFrameCount, yPosition
                    * openFrameCount);
            setVisible(true);
            setSelected(true);

            getContentPane().add(new UserJPanel());
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

}
