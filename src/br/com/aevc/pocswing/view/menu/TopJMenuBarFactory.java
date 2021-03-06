package br.com.aevc.pocswing.view.menu;

import br.com.aevc.pocswing.controller.ProductController;
import br.com.aevc.pocswing.view.menu.file.FileJMenuFactory;
import br.com.aevc.pocswing.view.menu.help.HelpJMenuFactory;

public class TopJMenuBarFactory {

    public static TopJMenuBar createFrom(ProductController productController){
        return new TopJMenuBar(
                FileJMenuFactory.createFrom(productController),
                HelpJMenuFactory.createDefault()
        );
    }

}
