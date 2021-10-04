package br.com.aevc.pocswing.model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Natanael
 *
 */
public interface ConnectionManager {

	Connection getConnection() throws SQLException;

}
