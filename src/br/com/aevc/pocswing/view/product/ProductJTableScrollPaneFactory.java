package br.com.aevc.pocswing.view.product;

import javax.swing.*;

public class ProductJTableScrollPaneFactory {

    public static JScrollPane createTable(Object[][] data) {
        return new JScrollPane(
                new JTable(
                        data,
                        new String[]{"Nome", "Código", "Valor", "Tipo"}
                )
        );
    }
}
