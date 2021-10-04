package br.com.aevc.pocswing.service;

import br.com.aevc.pocswing.model.Product;
import br.com.aevc.pocswing.model.dao.ProductDAO;
import br.com.aevc.pocswing.service.exception.BusinessException;
import br.com.aevc.pocswing.service.exception.SystemException;

import java.sql.SQLException;

import static java.lang.String.format;

public class ProductService {

    private final ProductDAO productDAO = new ProductDAO();

    public void save(Product product) throws SystemException, BusinessException {
        try {
            this.productDAO.insert(product);
        } catch (SQLException e) {
            System.out.println(format("%s %s", e.getMessage(), e));
            throw new SystemException(e.getMessage(), e);
        }
    }

}
