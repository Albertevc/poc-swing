package br.com.aevc.pocswing.controller;

import br.com.aevc.pocswing.model.Product;
import br.com.aevc.pocswing.model.ProductSearchDTO;
import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.model.dao.ProductDAO;
import br.com.aevc.pocswing.service.ProductService;
import br.com.aevc.pocswing.service.exception.BusinessException;
import br.com.aevc.pocswing.service.exception.SystemException;

import java.util.List;

/**
 * @author Natanael
 */
public class ProductController {

    private static final ProductController INSTANCE =
            new ProductController(new ProductService(new ProductDAO()));

    private final ProductService productService;

    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    public static ProductController getInstance() {
        return INSTANCE;
    }

    public ControllerResult<Void> register(Product product) {
        try {
            this.productService.save(product);
            return ControllerResult.success();
        } catch (BusinessException e) {
            return new ControllerResult<>(e);
        } catch (SystemException e) {
            return new ControllerResult<>(e);
        }
    }

    public ControllerResult<List<ProductVO>> search(ProductSearchDTO productSearchDTO) {
        try {
            return new ControllerResult<>(this.productService.search(productSearchDTO));
        } catch (SystemException e) {
            return new ControllerResult<>(e);
        } catch (BusinessException e) {
            return new ControllerResult<>(e);
        }
    }

    public ControllerResult<Void> delete(ProductVO productVO) {
        try {
            this.productService.delete(productVO);
            return ControllerResult.success();
        } catch (BusinessException e) {
            return new ControllerResult<>(e);
        } catch (SystemException e) {
            return new ControllerResult<>(e);
        }
    }
}
