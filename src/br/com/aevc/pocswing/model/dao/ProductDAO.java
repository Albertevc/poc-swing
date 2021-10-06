package br.com.aevc.pocswing.model.dao;

import br.com.aevc.pocswing.model.Product;
import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.model.dao.mapper.ProductVODAOMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

/**
 * @author Natanael
 *
 */
public class ProductDAO extends DAO {

	public ProductDAO() {
		super("PRODUCT");
	}

	public int insert(Product product) throws SQLException {
		try (
				Statement statement = getConnection().createStatement()
		) {
			return statement.executeUpdate(
					new StringBuilder()//
							.append(" INSERT INTO ")//
							.append(this.tableName)//
							.append(" ( ")//
							.append("  NAME, ")//
							.append("  CODE, ")//
							.append("  VALUE, ")//
							.append("  TYPE ")//
//							.append("  IMAGE ")//
							.append(" ) ")//
							.append(" VALUES ")//
							.append(" ( ")//
							.append(format("'%s',", product.getName()))//
							.append(format("'%s',", product.getCode()))//
							.append(format("'%s',", product.getValue()))//
							.append(format("'%s'", product.getType()))//
//							.append(format("'%s'", product.getImage()))//
							.append(" ) ")//
							.toString()
			);
		}
	}

	public int delete(Product product) throws SQLException {
		try (
				Statement statement = getConnection().createStatement()
		) {
			return statement.executeUpdate(
					new StringBuilder()//
							.append(" DELETE FROM ")//
							.append(this.tableName)//
							.append(" WHERE ")//
							.append(format(" CODE = '%s',", product.getCode()))//
							.toString()
			);
		}
	}

	public int update(Product product) throws SQLException {
		try (
				Statement statement = getConnection().createStatement()
		) {
			return statement.executeUpdate(
					new StringBuilder()//
							.append(" UPDATE ")//
							.append(this.tableName)//
							.append(" SET ")//
							.append(format(" NAME = '%s',", product.getName()))//
							.append(format(" CODE = '%s',", product.getCode()))//
							.append(format(" VALUE = '%s',", product.getValue()))//
							.append(format(" TYPE = '%s',", product.getType()))//
//							.append(format(" IMAGE = '%s'", product.getPassword()))//
							.append(" WHERE ")//
							.append(format(" CODE = '%s',", product.getCode()))//
							.toString()
			);
		}
	}

	public ProductVO selectProductBy(String code) throws SQLException {
		try (
				Statement statement = getConnection().createStatement();
				ResultSet resultSet = statement.executeQuery(
						new StringBuilder()//
								.append(" SELECT ")//
								.append("  NAME, ")//
								.append("  CODE, ")//
								.append("  VALUE, ")//
								.append("  TYPE ")//
								.append(" FROM ")//
								.append(this.tableName)//
								.append(" WHERE ")//
								.append(format(" CODE = '%s'", code))//
								.toString()
				)
		) {
			if (resultSet.next()) {
				return ProductVODAOMapper.getInstance()
						.map(resultSet);
			} else {
				return null;
			}
		}
	}

}
