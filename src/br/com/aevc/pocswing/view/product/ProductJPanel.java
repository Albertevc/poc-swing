package br.com.aevc.pocswing.view.product;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import static br.com.aevc.pocswing.view.product.ProductJTableScrollPaneFactory.createTable;

public class ProductJPanel extends JPanel {

    private final ProductSearchJPanel searchJPanel;
    private final ProductActionJPanel actionJPanel;
    private final JScrollPane jTableJScrollPane;

    public ProductJPanel() {
        super(new MigLayout("wrap 1"));

        this.searchJPanel = new ProductSearchJPanel();
        add(this.searchJPanel);

        this.actionJPanel = new ProductActionJPanel();
        add(this.actionJPanel);

        String[][] data = {
        };
        this.jTableJScrollPane = createTable(data);
        add(this.jTableJScrollPane);
    }

}
