package br.com.aevc.pocswing.view.component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class SearchJPanel<T, U> extends JPanel {

    private final JTableModelUpdater<T> jTableModelUpdater;

    private final JButton searchJButton;
    private final JButton clearJButtion;

    protected SearchJPanel(JTableModelUpdater<T> jTableModelUpdater, LayoutManager layoutManager) {
        super(layoutManager);
        this.jTableModelUpdater = jTableModelUpdater;

        this.searchJButton = new JButton("Pesquisar");
        add(this.searchJButton);

        this.clearJButtion = new JButton("Limpar");
        add(this.clearJButtion);

        this.searchJButton
                .addActionListener(actionEvent -> jTableModelUpdater.updateTableModel(
                        search(getFieldsValues())
                ));

        this.clearJButtion
                .addActionListener(actionEvent -> clearAllFields());
    }

    public abstract List<T> search(U allFields);

    public abstract void clearAllFields();

    public abstract U getFieldsValues();

}