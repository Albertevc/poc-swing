package br.com.aevc.pocswing.view.product.search;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.model.ProductVO;
import br.com.aevc.pocswing.view.component.JTableModelUpdater;

public class ProductSearchJPanelFactory {

    private static ProductSearchJPanel productSearchJPanel;

    public static ProductSearchJPanel createFrom(
            JTableModelUpdater<ProductVO> jTableModelUpdater,
            ProductController productController
    ){
        productSearchJPanel =  new ProductSearchJPanel(
                jTableModelUpdater,
                productController
        );
        return productSearchJPanel;
    }
}
