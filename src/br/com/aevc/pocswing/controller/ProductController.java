package br.com.aevc.pocswing.controller;

import br.com.aevc.pocswing.model.Product;
import br.com.aevc.pocswing.service.ProductService;
import br.com.aevc.pocswing.service.exception.BusinessException;
import br.com.aevc.pocswing.service.exception.SystemException;

/**
 * @author Natanael
 *
 */
public class ProductController {

	private static final ProductController INSTANCE = new ProductController();

	private final ProductService productService = new ProductService();

	private ProductController(){
	}

	public static ProductController getInstance() {
		return INSTANCE;
	}

	public ControllerResult register(Product product) {
		try {
			this.productService.save(product);
			return ControllerResult.success();
		} catch (BusinessException e) {
			return new ControllerResult(e);
		} catch (SystemException e) {
			return new ControllerResult(e);
		}

	}
}
