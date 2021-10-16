package br.com.aevc.pocswing;

import br.com.aevc.pocswing.model.dao.entity.EntityGenerator;
import br.com.aevc.pocswing.view.SwingApplicationFactory;
import br.com.aevc.pocswing.view.login.LoginJOptionPane;

import static br.com.aevc.pocswing.util.ApplicationPropertiesUtil.getProperty;

/**
 * @author alber
 */
public class Application {

    public static void main(String[] args) {
        EntityGenerator.getInstance()
                .generate();
        SwingApplicationFactory.createDefault();
        if (Boolean.valueOf(getProperty("poc-swing.security.active", "false"))) {
            LoginJOptionPane.showLoginDialog();
        }
    }

}
