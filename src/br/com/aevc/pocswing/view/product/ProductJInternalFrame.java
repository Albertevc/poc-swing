package br.com.aevc.pocswing.view.product;

import javax.swing.*;
import java.beans.PropertyVetoException;

public class ProductJInternalFrame extends JInternalFrame {

    static final int xPosition = 30, yPosition = 30;

    public ProductJInternalFrame(int openFrameCount) {
        super("Cadastro de produtos",
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

            getContentPane().add(new ProductJPanel());
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

}
