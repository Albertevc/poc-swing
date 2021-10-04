package br.com.aevc.pocswing.model.dao.connection;

public class ConnectionManagerFactory {

    public static ConnectionManager createDefault(){
        return H2DatabaseConnectionManager.getInstance();
    }

}
