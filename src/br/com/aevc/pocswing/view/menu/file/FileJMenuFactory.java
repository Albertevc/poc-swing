package br.com.aevc.pocswing.view.menu.file;

import br.com.aevc.pocswing.controller.ProductController;

public class FileJMenuFactory {

    public static FileJMenu createFrom(ProductController productController){
        return new FileJMenu(
                new ConfigurationJMenuItem(),
                new UserJMenuItem(),
                new ProductJMenuItem(productController),
                new ExitJMenuItem()
        );
    }

}
