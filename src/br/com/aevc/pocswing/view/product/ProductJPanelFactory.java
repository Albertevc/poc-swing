package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.view.product.action.ProductActionJPanel;
import br.com.aevc.pocswing.view.product.form.ProductFormJPanel;
import br.com.aevc.pocswing.view.product.search.ProductSearchJPanelFactory;
import br.com.aevc.pocswing.view.product.table.ProductJTableScrollPaneManager;

public class ProductJPanelFactory {

    public static ProductJPanel createFrom(ProductController productController) {

        ProductJTableScrollPaneManager productJTableScrollPaneManager
                = new ProductJTableScrollPaneManager();

        return new ProductJPanel(
                ProductSearchJPanelFactory.createFrom(
                        productJTableScrollPaneManager,
                        productController
                ),
                new ProductActionJPanel(productJTableScrollPaneManager, productController),
                productJTableScrollPaneManager,
                new ProductFormJPanel(productJTableScrollPaneManager, productController)
        );
    }
}
