package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.controller.ProductController;

public class ProductJInternalFrameFactory {

    public static ProductJInternalFrame createFrom(ProductController productController){
        return new ProductJInternalFrame(
                productController,
                2
        );
    }
}
