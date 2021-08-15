package br.com.aevc.pocswing.repository.dao;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.aevc.pocswing.model.Produto;

/**
 * @author Natanael
 *
 */
public class ProdutoDAO extends DAO<Produto> {

	public ProdutoDAO(Connection connection, String tableName) {
		super(connection, tableName);
	}

	@Override
	public void insert(Produto produto) throws SQLException {
		executeStatement(new StringBuilder()//
				.append(" INSERT INTO ")//
				.append("  produto ")//
				.append("  (name, value, amount, type) ")//
				.append(" VALUES ")//
				.append("  ( ")//
				.append(format("'%s'", produto.getName()))//
				.append(", ")//
				.append(format("'%s'", produto.getValue()))//
				.append(", ")//
				.append(format("'%s'", produto.getAmount()))//
				.append(", ")//
				.append(format("'%s'", produto.getType().name()))//
				.append("  ) ")//
//				.append(", ")//
//				.append(produto.getImage())
				.toString()//
		);
	}

	@Override
	public void delete(Produto t) throws SQLException {
	}

	@Override
	public void update(Produto t) throws SQLException {
	}

}
