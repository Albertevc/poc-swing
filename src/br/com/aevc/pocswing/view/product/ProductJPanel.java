package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.controller.ControllerResult;
import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.model.ProductVO;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static br.com.aevc.pocswing.view.product.ProductJTableScrollPaneFactory.createTable;

public class ProductJPanel extends JPanel {

    private final ProductController productController = ProductController.getInstance();
    private final ProductSearchJPanel searchJPanel;
    private final ProductActionJPanel actionJPanel;
    private JScrollPane jTableJScrollPane;

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

        this.searchJPanel.getSearchJButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerResult<List<ProductVO>> search = productController.search(searchJPanel.getFieldsValues());
                Object[][] data = {
                        search.getResult().toArray()
                };

                String[][] dataString = {
                    {"Pera", "123", "3.00", "2"}
                };

                //FIXME Não está exibindo o resultado na tabela
                jTableJScrollPane = createTable(dataString);
                jTableJScrollPane.revalidate();
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
