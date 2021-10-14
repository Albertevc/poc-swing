package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.controller.ProductController;

public class ProductJInternalFrameFactory {

    private static ProductJInternalFrame productJInternalFrame;

    public static ProductJInternalFrame createFrom(ProductController productController){
        productJInternalFrame = new ProductJInternalFrame(
                productController,
                2
        );
        return productJInternalFrame;
    }
}
