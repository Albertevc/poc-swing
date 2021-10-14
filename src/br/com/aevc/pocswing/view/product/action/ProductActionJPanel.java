package br.com.aevc.pocswing.view.product.action;

import javax.swing.*;
import java.awt.*;

public class ProductActionJPanel extends JPanel {

    public ProductActionJPanel() {
        super(new FlowLayout());
        add(new JButton("Novo"));
        add(new JButton("Alterar"));
        add(new JButton("Excluir"));
        add(new JButton("Cancelar"));
    }
}
