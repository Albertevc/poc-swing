package br.com.aevc.pocswing.view.component;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public abstract class JTableScrollPaneManager {

    private final JScrollPane jScrollPane;
    protected final JTable jTable;

    protected JTableScrollPaneManager(AbstractTableModel abstractTableModel) {
        this.jTable = new JTable(
                abstractTableModel
        );
        this.jScrollPane = new JScrollPane(this.jTable);
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

}
