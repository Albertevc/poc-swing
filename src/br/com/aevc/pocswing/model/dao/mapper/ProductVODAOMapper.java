package br.com.aevc.pocswing.model.dao.mapper;

import br.com.aevc.pocswing.model.ProductVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductVODAOMapper implements Mapper<ProductVO> {

	private static final ProductVODAOMapper USUARIO_NAME_DAO_MAPPER = new ProductVODAOMapper();

	private ProductVODAOMapper(){
	}

	public static ProductVODAOMapper getInstance(){
		return USUARIO_NAME_DAO_MAPPER;
	}

	@Override
	public ProductVO map(ResultSet resultSet) throws SQLException {
		return new ProductVO(
				resultSet.getString("NAME"),
				resultSet.getString("CODE"),
				resultSet.getDouble("VALUE"),
				resultSet.getString("TYPE")
		);
	}

}
