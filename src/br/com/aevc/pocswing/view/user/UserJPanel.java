package br.com.aevc.pocswing.view.user;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class UserJPanel extends JPanel {

    public UserJPanel(){
        super(new MigLayout("wrap 1"));

        JPanel serachJPanel = new JPanel(new MigLayout("wrap 4"));
        JLabel nameJLabel = new JLabel("Nome:");
        serachJPanel.add(nameJLabel);
        JTextField nameJTextField = new JTextField(100);
        nameJLabel.setLabelFor(nameJTextField);
        serachJPanel.add(nameJTextField);
        serachJPanel.add(new JButton("Pesquisar"));
        serachJPanel.add(new JButton("Limpar"));
        add(serachJPanel);

        JPanel crudJPanel = new JPanel(new FlowLayout());
        crudJPanel.add(new JButton("Novo"));
        crudJPanel.add(new JButton("Alterar"));
        crudJPanel.add(new JButton("Excluir"));
        crudJPanel.add(new JButton("Cancelar"));
        add(crudJPanel);

        String[][] data = {
                {"albert", "27", "123456789"}
        };
        String[] columnNames = { "Nome", "Idade", "Matrícula"};

        JTable jTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(jTable);

        add(scrollPane);
    }

}
