package br.com.aevc.pocswing.view.product.table;

import br.com.aevc.pocswing.model.ProductVO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {

    private final String[] columnNames;
    private final List<ProductVO> products;

    ProductTableModel(List<ProductVO> products) {
        this.columnNames = new String[]{"Nome", "Código", "Valor", "Tipo"};
        this.products = products;
    }

    @Override
    public int getRowCount() {
        if (this.products == null) {
            return 0;
        } else {
            return this.products.size();
        }
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return this.products.get(rowIndex).getName();
        } else if (columnIndex == 1) {
            return this.products.get(rowIndex).getCode();
        } else if (columnIndex == 2) {
            return this.products.get(rowIndex).getValue();
        } else {
            return this.products.get(rowIndex).getType();
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Double.class;
        } else {
            return String.class;
        }
    }

}
