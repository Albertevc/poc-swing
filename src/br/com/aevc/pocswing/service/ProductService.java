package br.com.aevc.pocswing.service;

import br.com.aevc.pocswing.model.Product;
import br.com.aevc.pocswing.model.ProductSearchDTO;
import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.model.dao.ProductDAO;
import br.com.aevc.pocswing.service.exception.BusinessException;
import br.com.aevc.pocswing.service.exception.SystemException;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public void save(Product product) throws SystemException, BusinessException {
        try {
            this.productDAO.insert(product);
        } catch (SQLException e) {
            System.out.printf("%s %s%n", e.getMessage(), e);
            throw new SystemException(e.getMessage(), e);
        }
    }

    public List<ProductVO> search(ProductSearchDTO productSearchDTO) throws SystemException, BusinessException {
        try {
            return this.productDAO.selectProductsBy(productSearchDTO);
        } catch (SQLException e) {
            System.out.printf("%s %s%n", e.getMessage(), e);
            throw new SystemException(e.getMessage(), e);
        }
    }

    public void delete(ProductVO productVO) throws SystemException, BusinessException {
        try {
            this.productDAO.delete(productVO);
        } catch (SQLException e) {
            System.out.printf("%s %s%n", e.getMessage(), e);
            throw new SystemException(e.getMessage(), e);
        }
    }
}
