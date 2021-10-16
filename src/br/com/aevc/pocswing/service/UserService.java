package br.com.aevc.pocswing.service;

import br.com.aevc.pocswing.model.User;
import br.com.aevc.pocswing.model.dao.UserDAO;
import br.com.aevc.pocswing.service.exception.BusinessException;
import br.com.aevc.pocswing.service.exception.SystemException;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import java.sql.SQLException;

import static java.lang.String.format;

public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void save(User user) throws SystemException, BusinessException {
        try {
            this.userDAO.insert(user);
        } catch (JdbcSQLIntegrityConstraintViolationException e) {
            System.out.printf("%s %s%n", e.getMessage(), e);
            throw new BusinessException(format("Usuário %s já existe.", user.getRegistration()));
        } catch (SQLException e) {
            System.out.printf("%s %s%n", e.getMessage(), e);
            throw new SystemException(e.getMessage(), e);
        }
    }

}
