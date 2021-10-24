package br.com.aevc.pocswing.view.product.action;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.view.product.table.ProductJTableScrollPaneManager;

import javax.swing.*;
import java.awt.*;

public class ProductActionJPanel extends JPanel {

    public ProductActionJPanel(
            ProductJTableScrollPaneManager productJTableScrollPaneManager,
            ProductController productController
    ) {
        super(new FlowLayout());
        add(new JButton("Novo"));
        add(new JButton("Alterar"));

        JButton excluirJButton = new JButton("Excluir");
        excluirJButton.addActionListener(actionEvent -> {
            ProductVO selectedItem = productJTableScrollPaneManager.getSelectedItem();
            productController.delete(selectedItem);
        });
        add(excluirJButton);

        add(new JButton("Cancelar"));
    }
}
