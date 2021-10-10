package br.com.aevc.pocswing.view.user;

import br.com.aevc.pocswing.model.User;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class UserRegistrationFormJPanel extends JPanel {

	private static final long serialVersionUID = -8677390533585078067L;

	private JTextField userName;
	private JFormattedTextField userAge;
	private JTextField matricula;
	private JPasswordField password;
	private JPasswordField confirmPassword;

	public UserRegistrationFormJPanel() {
		super();
		initClass();
	}

	public UserRegistrationFormJPanel(User user) {
		super();
		initClass();

		if (user != null) {
			userName.setText(user.getName());
			userAge.setText(user.getAge().toString());
			matricula.setText(user.getRegistration());
		}
	}

	private void initClass() {
		JPanel labels = new JPanel(new GridLayout(0, 1, 2, 7));

		labels.add(new JLabel("Nome:"));
		labels.add(new JLabel("Idade:"));
		labels.add(new JLabel("Matrícula:"));
		labels.add(new JLabel("Senha:"));
		labels.add(new JLabel("Confirmar Senha:"));
		add(labels, BorderLayout.CENTER);

		JPanel textFieldsPanel = new JPanel(new GridLayout(0, 1, 2, 2 ));

		userName = new JTextField();
		userName.setPreferredSize(new Dimension(100, 20));
		textFieldsPanel.add(userName);


		try {
			MaskFormatter onlyNumbersMask = new MaskFormatter("##");
			onlyNumbersMask.setValidCharacters("0123456789");
			userAge = new JFormattedTextField(onlyNumbersMask);

		} catch (ParseException e) {
			e.printStackTrace();
			userAge = new JFormattedTextField();
		}

		userAge.setPreferredSize(new Dimension(100, 20));
		textFieldsPanel.add(userAge);


		matricula = new JTextField();
		matricula.setPreferredSize(new Dimension(100, 20));
		textFieldsPanel.add(matricula);


		password = new JPasswordField();
		password.setPreferredSize(new Dimension(100, 20));
		textFieldsPanel.add(password);


		confirmPassword = new JPasswordField();
		confirmPassword.setPreferredSize(new Dimension(100, 20));
		textFieldsPanel.add(confirmPassword);

		add(textFieldsPanel, BorderLayout.CENTER);
	}


	public User getUser() {
		String nome = userName.getText();
		String matricula = this.matricula.getText();
		String userAgeText = userAge.getText();
		Integer age = (userAgeText.isEmpty() || userAgeText.isBlank()) ? 0 : (Integer.parseInt(userAgeText.trim()));
		String senha = String.copyValueOf(password.getPassword());

		if (!(nome.isBlank() || nome.isEmpty())) {
			return new User(nome, age, matricula, senha);
		} else {
			return null;
		}
	}

}
