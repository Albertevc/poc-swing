package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.controller.ProductController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductJPanel extends JPanel {

    private final ProductController productController = ProductController.getInstance();
    private final ProductSearchJPanel searchJPanel;
    private final ProductActionJPanel actionJPanel;
    private ProductJTableScrollPaneManager jTableJScrollPane;

    public ProductJPanel() {
        super(new MigLayout("wrap 1"));

        this.searchJPanel = new ProductSearchJPanel();
        add(this.searchJPanel);

        this.actionJPanel = new ProductActionJPanel();
        add(this.actionJPanel);

        this.jTableJScrollPane = new ProductJTableScrollPaneManager();
        add(this.jTableJScrollPane.getjScrollPane());

        this.searchJPanel.getSearchJButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTableJScrollPane.updateTableModel(
                        productController.search(searchJPanel.getFieldsValues())
                                .getResult()
                );
            }
        });

        this.searchJPanel.getClearJButtion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchJPanel.clearAllFields();
            }
        });
    }

}
