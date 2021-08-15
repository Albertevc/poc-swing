package br.com.aevc.pocswing.controller;

import br.com.aevc.pocswing.model.Usuario;
import br.com.aevc.pocswing.repository.dao.UserDAO;
import br.com.aevc.pocswing.repository.db.H2DatabaseConnectionManager;

import org.h2.jdbc.JdbcSQLNonTransientConnectionException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

/**
 * @author alber
 *
 */
public class LoginController {
	
	public static final LoginController INSTANCE = new LoginController();
	private static Usuario loggedUser = null;
	
	private LoginController() {
	}
	
	public ControllerResult<Boolean> doLogin(String usuario, Long senha) {
		doLogin(usuario, senha.toString());
		return null;
	}

	public ControllerResult<Boolean> doLogin(String usuario, String senha) {

		try {
			Connection connection = H2DatabaseConnectionManager.getConnection("sa");
			UserDAO dao = new UserDAO(connection, H2DatabaseConnectionManager.TABLE_NAME);
			Usuario user = dao.select(usuario);

			if (user != null) {
				if (user.getSenha() == null || user.getSenha().equals(senha)) {
					return new ControllerResult<Boolean>(true, String.format("Seja bem vindo %s!", user.getNome()));
				} else {
					return new ControllerResult<Boolean>(false, String.format("A Senha de \"%s\" está incorreta.", usuario.toUpperCase(Locale.ROOT)));
				}
			} else {
				return new ControllerResult<Boolean>(false, String.format("Usuário \"%s\" não está cadastrado.", usuario.toUpperCase(Locale.ROOT)));
			}

		} catch (JdbcSQLNonTransientConnectionException e) {
			return new ControllerResult<Boolean>(false, "Erro de conexão com o Banco de dados.");

		} catch (SQLException e) {
			return new ControllerResult<Boolean>(false, String.format("Erro desconhecido: %s.", e.getCause()));
		}

	}
	
	public static LoginController getInstance() {
		return INSTANCE;
	}

	public static Usuario getLoggedUser() {
		return loggedUser;
	}

	public static void logoff() {
		loggedUser = null;

	}

}
