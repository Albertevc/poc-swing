package br.com.aevc.pocswing.model.dao;

import br.com.aevc.pocswing.model.NameAndPasswordVO;
import br.com.aevc.pocswing.model.User;
import br.com.aevc.pocswing.model.dao.mapper.NameAndPasswordVODAOMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class UserDAO extends DAO {

    public UserDAO() {
        super("USER");
    }

    public int insert(User user) throws SQLException {
        try (
                Statement statement = getConnection().createStatement()
        ) {
            return statement.executeUpdate(
                    new StringBuilder()//
                            .append(" INSERT INTO ")//
                            .append(this.tableName)//
                            .append(" ( ")//
                            .append("  NAME, ")//
                            .append("  AGE, ")//
                            .append("  REGISTRATION, ")//
                            .append("  PASSWORD ")//
                            .append(" ) ")//
                            .append(" VALUES ")//
                            .append(" ( ")//
                            .append(format("'%s',", user.getName()))//
                            .append(format("'%s',", user.getAge()))//
                            .append(format("'%s',", user.getRegistration()))//
                            .append(format("'%s'", user.getPassword()))//
                            .append(" ) ")//
                            .toString()
            );
        }
    }

    public int delete(User usuario) throws SQLException {
        try (
                Statement statement = getConnection().createStatement()
        ) {
            return statement.executeUpdate(
                    new StringBuilder()//
                            .append(" DELETE FROM ")//
                            .append(this.tableName)//
                            .append(" WHERE ")//
                            .append(format(" REGISTRATION = '%s',", usuario.getRegistration()))//
                            .toString()
            );
        }
    }

    public int update(User usuario) throws SQLException {
        try (
                Statement statement = getConnection().createStatement()
        ) {
            return statement.executeUpdate(
                    new StringBuilder()//
                            .append(" UPDATE ")//
                            .append(this.tableName)//
                            .append(" SET ")//
                            .append(format(" NAME = '%s',", usuario.getName()))//
                            .append(format(" AGE = '%s',", usuario.getAge()))//
                            .append(format(" REGISTRATION = '%s',", usuario.getRegistration()))//
                            .append(format(" PASSWORD = '%s'", usuario.getPassword()))//
                            .append(" WHERE ")//
                            .append(format(" REGISTRATION = '%s',", usuario.getRegistration()))//
                            .toString()
            );
        }
    }

    public NameAndPasswordVO selectNameAndPasswordBy(String registration) throws SQLException {
        try (
                Statement statement = getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(
                        new StringBuilder()//
                                .append(" SELECT ")//
                                .append("  NAME, ")//
                                .append("  PASSWORD ")//
                                .append(" FROM ")//
                                .append(this.tableName)//
                                .append(" WHERE ")//
                                .append(format(" REGISTRATION = '%s'", registration))//
                                .toString()
                )
        ) {
            if (resultSet.next()) {
                return NameAndPasswordVODAOMapper.getInstance()
                        .map(resultSet);
            } else {
                return null;
            }

        }
    }

}
