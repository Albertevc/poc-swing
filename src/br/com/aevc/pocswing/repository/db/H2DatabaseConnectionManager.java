package br.com.aevc.pocswing.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Natanael
 *
 */
abstract public class H2DatabaseConnectionManager {

	public static final String TABLE_NAME = "usuario";
	private static final String H2_CONNECTION_URL = "jdbc:h2:~/poc-swing";

	/**
	 * Método para se conectar ao banco de dados com autenticação por senha
	 * 
	 * @param user     usuário do banco de dados
	 * @param password senha do banco de dados
	 * @throws SQLException Retorna uma exceção caso tenha algum problema durante a
	 *                      conexão com o banco de dados
	 */
	public static Connection getConnection(String user, String password) throws SQLException {
		return DriverManager.getConnection(H2_CONNECTION_URL, user, password);
	}

	/**
	 * Método para se conectar ao banco de dados que não tenha uma senha definida
	 * 
	 * @param user usuário do banco de dados
	 * @throws SQLException Retorna uma exceção caso tenha algum problema durante a
	 *                      conexão com o banco de dados
	 */
	public static Connection getConnection(String user) throws SQLException {
		return DriverManager.getConnection(H2_CONNECTION_URL, user, "");
	}

}
