package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.view.component.JTableScrollPaneManager;
import br.com.aevc.pocswing.view.component.SearchJPanel;
import br.com.aevc.pocswing.view.product.action.ProductActionJPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ProductJPanel extends JPanel {

    ProductJPanel(
            SearchJPanel searchJPanel,
            ProductActionJPanel productActionJPanel,
            JTableScrollPaneManager jTableScrollPaneManager
    ) {
        super(new MigLayout("wrap 1"));

        add(searchJPanel);
        add(productActionJPanel);
        add(jTableScrollPaneManager.getjScrollPane());
    }

}
