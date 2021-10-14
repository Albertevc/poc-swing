package br.com.aevc.pocswing.view.product.table;

public class ProductJTableScrollPaneManagerFactory {

    private static ProductJTableScrollPaneManager productJTableScrollPaneManager;

    public static ProductJTableScrollPaneManager createDefault(){
        productJTableScrollPaneManager = new ProductJTableScrollPaneManager();
        return productJTableScrollPaneManager;
    }

}
