package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.controller.ProductController;

import javax.swing.*;
import java.beans.PropertyVetoException;

public class ProductJInternalFrame extends JInternalFrame {

    static final int xPosition = 30, yPosition = 30;

    ProductJInternalFrame(
            ProductController productController,
            int openFrameCount
    ) {
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

            getContentPane().add(
                    ProductJPanelFactory.createFrom(productController)
            );
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

}
