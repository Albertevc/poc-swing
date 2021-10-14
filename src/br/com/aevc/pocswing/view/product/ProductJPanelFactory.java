package br.com.aevc.pocswing.view.product;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.view.product.action.ProductActionJPanel;
import br.com.aevc.pocswing.view.product.search.ProductSearchJPanelFactory;
import br.com.aevc.pocswing.view.product.table.ProductJTableScrollPaneManager;
import br.com.aevc.pocswing.view.product.table.ProductJTableScrollPaneManagerFactory;

public class ProductJPanelFactory {

    private static ProductJPanel productJPanel;

    public static ProductJPanel createFrom(ProductController productController) {

        ProductJTableScrollPaneManager productJTableScrollPaneManager
                = ProductJTableScrollPaneManagerFactory.createDefault();

        productJPanel =  new ProductJPanel(
                ProductSearchJPanelFactory.createFrom(
                        productJTableScrollPaneManager,
                        productController
                ),
                new ProductActionJPanel(),
                productJTableScrollPaneManager
        );

        return productJPanel;
    }
}
