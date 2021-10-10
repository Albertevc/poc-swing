package br.com.aevc.pocswing.model.dao;

import br.com.aevc.pocswing.model.Product;
import br.com.aevc.pocswing.model.ProductSearchDTO;
import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.model.dao.mapper.ProductVODAOMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * @author Natanael
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

    public List<ProductVO> selectProductsBy(ProductSearchDTO productSearchDTO) throws SQLException {

		StringBuilder stringBuilderSql = new StringBuilder()//
				.append(" SELECT ")//
				.append("  NAME, ")//
				.append("  CODE, ")//
				.append("  VALUE, ")//
				.append("  TYPE ")//
				.append(" FROM ")//
				.append(this.tableName)//
				.append(" WHERE ")//
				.append("  1=1 ");//

		if(productSearchDTO.getName() != null && !productSearchDTO.getName().isBlank()){
			stringBuilderSql.append(format(" AND "));
			stringBuilderSql.append(format("  NAME = '%s'", productSearchDTO.getName()));
		}

		if(productSearchDTO.getCode() != null && !productSearchDTO.getCode().isBlank()){
			stringBuilderSql.append(format(" AND "));
			stringBuilderSql.append(format("  CODE = '%s'", productSearchDTO.getCode()));
		}

		if(productSearchDTO.getType() != null && !productSearchDTO.getType().isBlank()){
			stringBuilderSql.append(format(" AND "));
			stringBuilderSql.append(format("  TYPE = '%s'", productSearchDTO.getType()));
		}

        try (
                Statement statement = getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(stringBuilderSql.toString())
        ) {
			List<ProductVO> products = new ArrayList<>();
			while(resultSet.next()){
				products.add(ProductVODAOMapper.getInstance()
						.map(resultSet));
			}
			return products;
        }
    }

}
