package br.com.aevc.pocswing.view.product;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ProductSearchJPanel extends JPanel {

    private final JLabel nameJLabel;
    private final JTextField nameJTextField;

    private final JLabel codeJLabel;
    private final JTextField codeJTextField;

    private final JLabel typeJLabel;
    private final JTextField typeJTextField;

    private final JButton searchJButton;
    private final JButton clearJButtion;

    public ProductSearchJPanel(){
        super(new MigLayout("wrap 8"));

        this.nameJLabel =  new JLabel("Nome:");
        add(nameJLabel);

        this.nameJTextField  = new JTextField(100);
        this.nameJLabel.setLabelFor(this.nameJTextField);
        add(this.nameJTextField);

        this.codeJLabel = new JLabel("Codigo:");
        add(this.codeJLabel);
        this.codeJTextField = new JTextField(100);
        this.codeJLabel.setLabelFor(this.codeJTextField);
        add(this.codeJTextField);

        this.typeJLabel = new JLabel("Tipo:");
        add(this.typeJLabel);
        this.typeJTextField = new JTextField(100);
        this.typeJLabel.setLabelFor(this.typeJTextField);
        add(this.typeJTextField);

        this.searchJButton = new JButton("Pesquisar");
        add(this.searchJButton);

        this.clearJButtion = new JButton("Limpar");
        add(this.clearJButtion);
    }
}
