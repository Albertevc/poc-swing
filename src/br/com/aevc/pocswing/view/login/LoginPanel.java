package br.com.aevc.pocswing.view.login;

import br.com.aevc.pocswing.controller.ControllerResult;
import br.com.aevc.pocswing.controller.LoginController;
import br.com.aevc.pocswing.controller.UserSessionController;
import br.com.aevc.pocswing.model.LoginDTO;
import br.com.aevc.pocswing.model.LoginResponseVO;
import br.com.aevc.pocswing.view.session.SessionJPanel;

import static javax.swing.JOptionPane.*;

public class LoginPanel {

    private static final LoginPanel LOGIN_PANEL = new LoginPanel();
    private static final LoginController LOGIN_CONTROLLER = LoginController.getInstance();
    private static final UserSessionController USER_SESSION_CONTROLLER = UserSessionController.getInstance();

    private LoginPanel() {
    }

    private void showLoginDialog(LoginFormJPanel loginFormJPanel) {
        int login = showConfirmDialog(
                null,
                loginFormJPanel,
                "Login",
                OK_CANCEL_OPTION,
                PLAIN_MESSAGE
        );

        if (OK_OPTION == login) {
            ControllerResult<LoginResponseVO> controllerResult = LOGIN_CONTROLLER.login(
                    new LoginDTO(
                            loginFormJPanel.getUsernameJTextField().getText(),
                            loginFormJPanel.getJPasswordField().getPassword()
                    )
            );

            LoginMessageDialog.showMessageDialog(null,controllerResult);

            if (controllerResult.errorHappened() || !controllerResult.getResult().authenticated()) {
                showLoginDialog(loginFormJPanel);
                SessionJPanel.INSTANCE.setVisible(false);
            }else{
                USER_SESSION_CONTROLLER.initSession(
                        controllerResult.getResult().getName(),
                        controllerResult.getResult().getRegistration()
                );
                SessionJPanel.INSTANCE.setVisible(true);
            }

        } else {
            System.exit(0);
        }
    }

    public static void showLoginDialog() {
        LOGIN_PANEL.showLoginDialog(new LoginFormJPanel());
    }

}
