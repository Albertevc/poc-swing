package br.com.aevc.pocswing.model.dao;

import br.com.aevc.pocswing.model.dao.connection.ConnectionManager;
import br.com.aevc.pocswing.model.dao.connection.ConnectionManagerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO {

    protected final ConnectionManager connectionManager = ConnectionManagerFactory.createDefault();

    protected final String tableName;

    public DAO(String tableName){
        this.tableName = tableName;
    }

    public Connection getConnection() throws SQLException {
        return this.connectionManager.getConnection();
    }

}
