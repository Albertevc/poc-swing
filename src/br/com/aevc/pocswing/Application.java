package br.com.aevc.pocswing;

import br.com.aevc.pocswing.model.dao.entity.EntityGenerator;
import br.com.aevc.pocswing.view.SwingApplication;

/**
 * @author alber
 */
public class Application {

    public static void main(String[] args) {
        EntityGenerator.getInstance()
                .generate();
        SwingApplication.getInstance();
//        LoginJOptionPane.showLoginDialog();
    }

}
