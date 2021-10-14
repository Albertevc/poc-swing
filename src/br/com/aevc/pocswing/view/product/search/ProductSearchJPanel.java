package br.com.aevc.pocswing.view.product.search;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.model.ProductSearchDTO;
import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.view.component.JTableModelUpdater;
import br.com.aevc.pocswing.view.component.SearchJPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.List;

public class ProductSearchJPanel extends SearchJPanel<ProductVO, ProductSearchDTO> {

    private final ProductController productController;

    private final JTextField nameJTextField;
    private final JTextField codeJTextField;
    private final JTextField typeJTextField;

    ProductSearchJPanel(
            JTableModelUpdater<ProductVO> jTableModelUpdater,
            ProductController productController
    ) {
        super(jTableModelUpdater, new MigLayout("wrap 8"));

        this.productController = productController;

        JLabel nameJLabel = new JLabel("Nome:");
        add(nameJLabel);
        this.nameJTextField = new JTextField(100);
        nameJLabel.setLabelFor(this.nameJTextField);
        add(this.nameJTextField);

        JLabel codeJLabel = new JLabel("Codigo:");
        add(codeJLabel);
        this.codeJTextField = new JTextField(100);
        codeJLabel.setLabelFor(this.codeJTextField);
        add(this.codeJTextField);

        JLabel typeJLabel = new JLabel("Tipo:");
        add(typeJLabel);
        this.typeJTextField = new JTextField(100);
        typeJLabel.setLabelFor(this.typeJTextField);
        add(this.typeJTextField);
    }

    @Override
    public List<ProductVO> search(ProductSearchDTO allFields) {
        return this.productController.search(allFields).getResult();
    }

    @Override
    public void clearAllFields() {
        this.nameJTextField.setText("");
        this.codeJTextField.setText("");
        this.typeJTextField.setText("");
    }

    @Override
    public ProductSearchDTO getFieldsValues() {
        return new ProductSearchDTO(
                this.nameJTextField.getText(),
                this.codeJTextField.getText(),
                this.typeJTextField.getText()
        );
    }

}
