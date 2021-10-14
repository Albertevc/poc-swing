package br.com.aevc.pocswing.view.product.table;

import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.view.component.JTableModelUpdater;
import br.com.aevc.pocswing.view.component.JTableScrollPaneManager;

import java.util.List;

import static java.util.Collections.emptyList;

public class ProductJTableScrollPaneManager
        extends JTableScrollPaneManager
        implements JTableModelUpdater<ProductVO> {

    ProductJTableScrollPaneManager() {
        super(new ProductTableModel(emptyList()));
    }

    @Override
    public void updateTableModel(List<ProductVO> modelList) {
        ProductTableModel productTableModel = new ProductTableModel(modelList);
        this.jTable.setModel(productTableModel);
        productTableModel.fireTableDataChanged();
    }

}
