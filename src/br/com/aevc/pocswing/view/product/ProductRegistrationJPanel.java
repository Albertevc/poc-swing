package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.controller.ControllerResult;
import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.model.Product;
import br.com.aevc.pocswing.model.TypeEnum;

import javax.swing.*;

/**
 * @author Natanael
 */
public class ProductRegistrationJPanel extends JPanel {

    private static final long serialVersionUID = -1941098188860327226L;

    public ProductRegistrationJPanel() {
        super();

        boolean isToContinueLoop = true;

        ProductRegistrationFormJPanel productRegisterForm;
        setBorder(BorderFactory.createEmptyBorder());

        while (isToContinueLoop) {
            productRegisterForm = new ProductRegistrationFormJPanel();
            int confirmDialogOption = JOptionPane.showInternalConfirmDialog(null, productRegisterForm, "Cadastro",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (confirmDialogOption == JOptionPane.OK_OPTION) {

                JTextField productName = productRegisterForm.getProductName();
                JFormattedTextField value = productRegisterForm.getValue();
                JFormattedTextField amount = productRegisterForm.getAmount();

                JCheckBox type = productRegisterForm.getType();
                JFileChooser image = productRegisterForm.getImage();

                Product produto = new Product(
                        productName.getText(),
                        null,
                        tratarDouble(value.getValue().toString()),
                        TypeEnum.ELETRONICO.toString(),
                        null
                );

                ProductController instance = ProductController.getInstance();
                ControllerResult<Boolean> result = instance.register(produto);

                if (result.getResult()) {
//					JOptionPane.showMessageDialog(this, result.getMessage(), "Sucesso",
//							JOptionPane.INFORMATION_MESSAGE);
                    isToContinueLoop = false;

                } else {
//					JOptionPane.showMessageDialog(null, result.getMessage(), "Falha ao resigtrar produto",
//							JOptionPane.ERROR_MESSAGE);
                }

            } else if (confirmDialogOption == JOptionPane.CANCEL_OPTION
                    || confirmDialogOption == JOptionPane.CLOSED_OPTION) {
                isToContinueLoop = false;
            }
        }
    }

    public static Double tratarDouble(String string) {
        return Double.valueOf(string.replace("R$", ""));
    }
}
