package br.com.aevc.pocswing.view.component;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class SearchJPanel<T, U> extends JPanel {

    private final JTableModelUpdater<T> jTableModelUpdater;

    private final JPanel fieldsJpanel;
    private final JButton searchJButton;
    private final JButton clearJButtion;

    protected SearchJPanel(JTableModelUpdater<T> jTableModelUpdater, LayoutManager layoutManager) {
        super(new MigLayout("wrap 3"));

        this.jTableModelUpdater = jTableModelUpdater;

        this.fieldsJpanel = new JPanel(layoutManager);
        super.add(this.fieldsJpanel);

        this.searchJButton = new JButton("Pesquisar");
        this.searchJButton
                .addActionListener(actionEvent -> jTableModelUpdater.updateTableModel(
                        search(getFieldsValues())
                ));
        super.add(this.searchJButton);

        this.clearJButtion = new JButton("Limpar");
        this.clearJButtion
                .addActionListener(actionEvent -> clearAllFields());
        super.add(this.clearJButtion);

    }

    public abstract List<T> search(U allFields);

    public abstract void clearAllFields();

    public abstract U getFieldsValues();

    @Override
    public Component add(Component comp) {
        return this.fieldsJpanel.add(comp);
    }

    @Override
    public Component add(Component comp, int index) {
        return this.fieldsJpanel.add(comp, index);
    }

    @Override
    public Component add(String name, Component comp) {
        return this.fieldsJpanel.add(name, comp);
    }

    @Override
    public void add(PopupMenu popup) {
        this.fieldsJpanel.add(popup);
    }

    @Override
    public void add(Component comp, Object constraints) {
        this.fieldsJpanel.add(comp, constraints);
    }

    @Override
    public void add(Component comp, Object constraints, int index) {
        this.fieldsJpanel.add(comp, constraints, index);
    }
}