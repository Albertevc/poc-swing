package br.com.aevc.pocswing.model.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static br.com.aevc.pocswing.util.ApplicationPropertiesUtil.getProperty;

/**
 * @author Natanael
 */
public class H2DatabaseConnectionManager implements ConnectionManager {

    private static final String H2_CONNECTION_URL = getProperty("poc-swing.h2.database.connection-url",
            "H2_CONNECTION_URL");
    private static final String H2_CONNECTION_USERNAME = getProperty("poc-swing.h2.database.username",
            "H2_CONNECTION_URL");
    private static final String H2_CONNECTION_PASSWORD = getProperty("poc-swing.h2.database.password",
            "H2_CONNECTION_URL");
    private static final H2DatabaseConnectionManager H2_DATABASE_CONNECTION_MANAGER = new H2DatabaseConnectionManager();

    private static Connection connection;

    private H2DatabaseConnectionManager() {
    }

    public static H2DatabaseConnectionManager getInstance() {
        return H2_DATABASE_CONNECTION_MANAGER;
    }

    /**
     * Método para se conectar ao banco de dados com autenticação por senha
     *
     * @param user     usuário do banco de dados
     * @param password senha do banco de dados
     * @throws SQLException Retorna uma exceção caso tenha algum problema durante a
     *                      conexão com o banco de dados
     */
    @Override
    public Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        } else {
            return DriverManager.getConnection(H2_CONNECTION_URL, H2_CONNECTION_USERNAME, H2_CONNECTION_PASSWORD);
        }
    }

}
