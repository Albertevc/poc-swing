package br.com.aevc.pocswing.view.product.form;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.model.Product;
import br.com.aevc.pocswing.model.TypeEnum;
import br.com.aevc.pocswing.view.component.JFileChooserJPanel;
import br.com.aevc.pocswing.view.product.table.ProductJTableScrollPaneManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;

public class ProductFormJPanel extends JPanel {

    private JTextField nameJTextField;
    private JTextField codeJTextField;
    private JTextField valueJTextField;
    private JComboBox<TypeEnum> typeJComboBox;
    private JFileChooserJPanel imageJFileChooserJPanel;

    public ProductFormJPanel(
            ProductJTableScrollPaneManager productJTableScrollPaneManager,
            ProductController productController
    ) {
        super(new MigLayout());

        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel nameJLabel = new JLabel("Nome:");
        add(nameJLabel);
        this.nameJTextField = new JTextField(20);
        nameJLabel.setLabelFor(this.nameJTextField);
        add(this.nameJTextField, "wrap");

        JLabel codeJLabel = new JLabel("Código:");
        add(codeJLabel);
        this.codeJTextField = new JTextField(20);
        nameJLabel.setLabelFor(this.codeJTextField);
        add(this.codeJTextField, "wrap");

        JLabel valueJLabel = new JLabel("Valor:");
        add(valueJLabel);
        this.valueJTextField = new JTextField(20);
        nameJLabel.setLabelFor(this.valueJTextField);
        add(this.valueJTextField, "wrap");

        JLabel typeJLabel = new JLabel("Tipo:");
        add(typeJLabel);
        this.typeJComboBox = new JComboBox<>(TypeEnum.values());
        nameJLabel.setLabelFor(this.typeJComboBox);
        add(this.typeJComboBox, "wrap");

        this.imageJFileChooserJPanel = new JFileChooserJPanel("Imagem:");
        add(this.imageJFileChooserJPanel, "span");

        JPanel jPanel = new JPanel(new MigLayout("wrap 2"));

        JButton saveJButton = new JButton("Salvar");
        saveJButton.addActionListener(actionEvent -> productController.register(getFieldsValues()));
        jPanel.add(saveJButton);

        JButton cancelJButton = new JButton("Cancelar");
        cancelJButton.addActionListener(actionEvent -> {
//            FIXME IMPLEMENTAR
        });
        jPanel.add(cancelJButton);

        add(jPanel, "wrap");
    }

    public Product getFieldsValues() {
        try {
            return new Product(
                    this.nameJTextField.getText(),
                    this.codeJTextField.getText(),
                    Double.valueOf(this.valueJTextField.getText()),
                    this.typeJComboBox.getSelectedItem().toString(),
                    Files.readAllBytes(this.imageJFileChooserJPanel.getSelectedFile()
                            .toPath())
            );
        } catch (IOException e) {
            System.out.println("Problemas ao ler o arquivo.");
            return new Product(
                    this.nameJTextField.getText(),
                    this.codeJTextField.getText(),
                    Double.valueOf(this.valueJTextField.getText()),
                    this.typeJComboBox.getSelectedItem().toString(),
                    null
            );
        }
    }
}
