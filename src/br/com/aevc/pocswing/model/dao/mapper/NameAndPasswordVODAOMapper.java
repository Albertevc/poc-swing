package br.com.aevc.pocswing.model.dao.mapper;

import br.com.aevc.pocswing.model.NameAndPasswordVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NameAndPasswordVODAOMapper implements Mapper<NameAndPasswordVO> {

	private static final NameAndPasswordVODAOMapper USUARIO_NAME_DAO_MAPPER = new NameAndPasswordVODAOMapper();

	private NameAndPasswordVODAOMapper(){
	}

	public static NameAndPasswordVODAOMapper getInstance(){
		return USUARIO_NAME_DAO_MAPPER;
	}

	@Override
	public NameAndPasswordVO map(ResultSet resultSet) throws SQLException {
		return new NameAndPasswordVO(
				resultSet.getString("NAME"),
				resultSet.getString("PASSWORD")
		);
	}

}
