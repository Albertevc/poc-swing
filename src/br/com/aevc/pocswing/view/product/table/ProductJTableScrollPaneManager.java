package br.com.aevc.pocswing.view.product.table;

import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.view.component.JTableModelUpdater;
import br.com.aevc.pocswing.view.component.JTableScrollPaneManager;

import java.util.List;

import static java.util.Collections.emptyList;

public class ProductJTableScrollPaneManager
        extends JTableScrollPaneManager
        implements JTableModelUpdater<ProductVO> {

    public ProductJTableScrollPaneManager() {
        super(new ProductTableModel(emptyList()));
    }

    @Override
    public void updateTableModel(List<ProductVO> modelList) {
        ProductTableModel productTableModel = new ProductTableModel(modelList);
        this.jTable.setModel(productTableModel);
        productTableModel.fireTableDataChanged();
    }

    public ProductVO getSelectedItem(){
        int selectedRow = this.jTable.getSelectedRow();
        ProductTableModel model = (ProductTableModel) this.jTable.getModel();
        return model.getSelected(selectedRow);
    }

}
