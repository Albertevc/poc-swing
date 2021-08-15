package br.com.aevc.pocswing.controller;

import java.sql.Connection;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.h2.jdbc.JdbcSQLNonTransientConnectionException;

import br.com.aevc.pocswing.model.Produto;
import br.com.aevc.pocswing.repository.dao.DAO;
import br.com.aevc.pocswing.repository.dao.ProdutoDAO;
import br.com.aevc.pocswing.repository.db.H2DatabaseConnectionManager;

/**
 * @author Natanael
 *
 */
public class ProductController {

	private static final ProductController INSTANCE = new ProductController();

	private DAO<Produto> dao;

	public ControllerResult<Boolean> doSaveProduct(Produto produto) {
		if (produto == null) {
			return new ControllerResult<>(false, "O Produto não pode estar vazio.");
		} else {

			try {
				Connection connection = H2DatabaseConnectionManager.getConnection("sa");

				dao = new ProdutoDAO(connection, H2DatabaseConnectionManager.TABLE_NAME);
				dao.insert(produto);

				return new ControllerResult<Boolean>(true,
						String.format("Produto %s cadastrado com sucesso.", produto.getName()));

			} catch (JdbcSQLNonTransientConnectionException e) {
				return new ControllerResult<Boolean>(false, "Falha de conexão com o banco de dados");

			} catch (JdbcSQLIntegrityConstraintViolationException e) {
				return new ControllerResult<Boolean>(false, String.format("Produto %s já existe.", produto.getName()));

			} catch (Exception e) {
				e.printStackTrace();
				return new ControllerResult<Boolean>(false, String.format("Erro desconhecido: %s", e.getMessage()));
			}
		}
	}

	public static ProductController getInstance() {
		return INSTANCE;
	}
}
