package br.com.aevc.pocswing.view.user;

import br.com.aevc.pocswing.controller.ControllerResult;

import javax.swing.*;
import java.awt.*;

import static java.lang.String.format;

public class UserRegistrationMessageDialog {

    public static void showMessageDialog(
            Component parentComponent,
            ControllerResult loginControllerResult
    ) {
        if (loginControllerResult.errorHappened()) {
            JOptionPane.showMessageDialog(
                    parentComponent,
                    format("Erro: %s.", loginControllerResult.getException().getMessage())
            );
        } else {

        }
    }

}
