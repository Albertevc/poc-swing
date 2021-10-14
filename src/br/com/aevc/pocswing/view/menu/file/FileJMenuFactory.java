package br.com.aevc.pocswing.view.menu.file;

import br.com.aevc.pocswing.controller.ProductController;

public class FileJMenuFactory {

    private static FileJMenu fileJMenu;

    public static FileJMenu createFrom(ProductController productController){
        fileJMenu = new FileJMenu(
                new ConfigurationJMenuItem(),
                new UserJMenuItem(),
                new ProductJMenuItem(productController),
                new ExitJMenuItem()
        );
        return fileJMenu;
    }

}
