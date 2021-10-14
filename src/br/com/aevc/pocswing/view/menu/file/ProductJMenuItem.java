package br.com.aevc.pocswing.view.menu.file;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.view.SwingApplicationContext;
import br.com.aevc.pocswing.view.product.ProductJInternalFrameFactory;

import javax.swing.*;

public class ProductJMenuItem extends JMenuItem {

    ProductJMenuItem(ProductController productController) {
        super("Cadastro de Produtos");
        addActionListener(actionEvent ->
                SwingApplicationContext
                        .getSwingApplication()
                        .addJInternalFrame(
                                ProductJInternalFrameFactory.createFrom(productController)
                        )
        );
    }
}
