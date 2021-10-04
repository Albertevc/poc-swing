package br.com.aevc.pocswing.view.login;

import br.com.aevc.pocswing.controller.ControllerResult;
import br.com.aevc.pocswing.controller.LoginController;
import br.com.aevc.pocswing.model.LoginDTO;
import br.com.aevc.pocswing.model.LoginResponseVO;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class LoginPanel extends JPanel {

    private static final LoginPanel LOGIN_PANEL = new LoginPanel();
    private static final LoginController LOGIN_CONTROLLER = LoginController.getInstance();

    private LoginPanel() {
    }

    private void showLoginDialog(LoginFormJPanel loginFormJPanel) {
        int login = showConfirmDialog(
                this,
                loginFormJPanel,
                "Login",
                OK_CANCEL_OPTION,
                PLAIN_MESSAGE
        );

        if (OK_OPTION == login) {
            ControllerResult<LoginResponseVO> controllerResult = LOGIN_CONTROLLER.login(
                    new LoginDTO(loginFormJPanel.getUsernameJTextField().getText(),
                            loginFormJPanel.getJPasswordField().getPassword())
            );

            LoginMessageDialog.showMessageDialog(this,controllerResult);

            if (!controllerResult.getResult().isAutenticado()) {
                showLoginDialog();
            }

        } else {
            System.exit(0);
        }
    }

    public static void showLoginDialog() {
        LOGIN_PANEL.showLoginDialog(new LoginFormJPanel());
    }

}
