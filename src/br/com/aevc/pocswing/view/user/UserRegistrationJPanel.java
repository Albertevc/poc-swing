package br.com.aevc.pocswing.view.user;

import br.com.aevc.pocswing.controller.ControllerResult;
import br.com.aevc.pocswing.controller.UserController;
import br.com.aevc.pocswing.model.User;

import javax.swing.*;

/**
 * @author Natanael
 */
public class UserRegistrationJPanel extends JPanel {

	private static final long serialVersionUID = -1941098188860327226L;
	private User user;

	public UserRegistrationJPanel() {
		super();

		boolean isToContinueLoop = true;

		UserRegistrationFormJPanel userRegisterForm;
		setBorder(BorderFactory.createEmptyBorder());

		while (isToContinueLoop) {
			userRegisterForm = new UserRegistrationFormJPanel(user);
			int confirmDialogOption = JOptionPane.showInternalConfirmDialog(null, userRegisterForm, "Cadastro",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			if (confirmDialogOption == JOptionPane.OK_OPTION) {
				user = userRegisterForm.getUser();
				UserController registerController = UserController.getInstance();
				ControllerResult result = registerController.register(user);

				if (result.errorHappened()) {
//					JOptionPane.showMessageDialog(this, result.getMessage(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					isToContinueLoop = false;

				} else {
//					JOptionPane.showMessageDialog(null, result.getMessage(), "Falha ao resigtrar usu�rio", JOptionPane.ERROR_MESSAGE);
				}

			} else if (confirmDialogOption == JOptionPane.CANCEL_OPTION || confirmDialogOption == JOptionPane.CLOSED_OPTION) {
				isToContinueLoop = false;
			}
		}
	}
}
