package br.com.aevc.pocswing.repository.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.aevc.pocswing.model.Usuario;

/**
 * @author Natanael
 *
 */
public class UserDAO extends DAO<Usuario> {

	private static final UsuarioDAOMapper USUARIO_DAO_MAPPER = new UsuarioDAOMapper();

	public UserDAO(Connection connection, String tableName) {
		super(connection, tableName);
	}

	@Override
	public void insert(Usuario user) throws SQLException {
		String nome = user.getNome();
		int idade = user.getIdade();
		String matricula = user.getMatricula();
		String senha = user.getSenha();

		String query = "INSERT INTO " + this.tableName + "(nome, idade, matricula, senha) VALUES ('" + nome + "',"
				+ idade + ",'" + matricula + "','" + senha + "');";

		executeStatement(query);
	}

	@Override
	public void delete(Usuario user) throws SQLException {
		String nome = user.getNome();

		String query = "DELETE FROM '" + tableName + "' WHERE " + "nome ilike '" + nome + "';";

		executeStatement(query);
	}

	public void update(Usuario user) throws SQLException {
		String nome = user.getNome();
		int idade = user.getIdade();
		String matricula = user.getMatricula();
		String senha = user.getSenha();

		String query = "UPDATE " + tableName + " SET nome = '" + nome + "'," + "idade = " + idade + ","
				+ "matricula = '" + matricula + "'," + "senha = '" + senha + "';";

		executeStatement(query);
	}

	/**
	 *
	 * @param name Nomde do usuário cadastrado no banco de dados (não é case
	 *             sensitive)
	 * @return Retorna uma instância de Usuario ou nulo caso não ache o cadastro no
	 *         banco de dados
	 * @throws SQLException lança uma exceção caso não consiga fechar a conexão com
	 *                      o banco de dados
	 */
	public Usuario select(String name) throws SQLException {
		return select("SELECT * FROM " + tableName + " WHERE " + "nome like '" + name + "';", USUARIO_DAO_MAPPER);
	}

}
