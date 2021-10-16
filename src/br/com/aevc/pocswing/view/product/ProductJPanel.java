package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.view.component.JTableScrollPaneManager;
import br.com.aevc.pocswing.view.component.SearchJPanel;
import br.com.aevc.pocswing.view.product.action.ProductActionJPanel;
import br.com.aevc.pocswing.view.product.form.ProductFormJPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ProductJPanel extends JPanel {

    ProductJPanel(
            SearchJPanel<?, ?> searchJPanel,
            ProductActionJPanel productActionJPanel,
            JTableScrollPaneManager jTableScrollPaneManager,
            ProductFormJPanel productFormJPanel
    ) {
        super(new MigLayout("wrap 1"));

        add(searchJPanel);
        add(productActionJPanel);

        JPanel jPanel = new JPanel(new GridLayout(0,2, 10, 0));
        jPanel.add(jTableScrollPaneManager.getjScrollPane());
        jPanel.add(productFormJPanel);
        add(jPanel);
    }

}
