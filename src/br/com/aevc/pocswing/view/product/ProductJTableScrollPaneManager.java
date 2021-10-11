package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.model.ProductVO;

import javax.swing.*;
import java.util.List;

import static java.util.Collections.emptyList;

public class ProductJTableScrollPaneManager {

    private final JTable jTable;
    private final JScrollPane jScrollPane;

    public ProductJTableScrollPaneManager(){
        super();
        this.jTable = new JTable(
                new ProductTableModel(emptyList())
        );
        this.jScrollPane = new JScrollPane(this.jTable);
    }

    public void updateTableModel(List<ProductVO> productVOs){
        ProductTableModel productTableModel = new ProductTableModel(productVOs);
        this.jTable.setModel(productTableModel);
        productTableModel.fireTableDataChanged();
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }
}
