package br.com.aevc.pocswing.view.login;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

class LoginFormJPanel extends JPanel {

	private static final long serialVersionUID = 9031784451368701659L;

	private final JTextField usernameJTextField = new JTextField(20);
	private final JPasswordField jPasswordField = new JPasswordField(20);

	public LoginFormJPanel() {
		super();

		setLayout(new MigLayout("wrap 2"));

		add(new JLabel("Usuário:"));
		add(usernameJTextField);

		add(new JLabel("Senha:"));
		add(jPasswordField);

	}

	public JTextField getUsernameJTextField() {
		return usernameJTextField;
	}

	public JPasswordField getJPasswordField() {
		return jPasswordField;
	}
	
}
