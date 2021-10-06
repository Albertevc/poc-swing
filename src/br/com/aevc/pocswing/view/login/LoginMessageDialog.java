package br.com.aevc.pocswing.view.login;

import br.com.aevc.pocswing.controller.ControllerResult;
import br.com.aevc.pocswing.model.LoginResponseVO;

import javax.swing.*;
import java.awt.*;

import static java.lang.String.format;

public class LoginMessageDialog {

    public static void showMessageDialog(
            Component parentComponent,
            ControllerResult<LoginResponseVO> loginControllerResult
    ) {
        if (loginControllerResult.errorHappened()) {
            JOptionPane.showMessageDialog(
                    parentComponent,
                    format("Erro: %s.", loginControllerResult.getException().getMessage())
            );
        } else {
            if (loginControllerResult.getResult().authenticated()) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        format("Bem vindo %s.", loginControllerResult.getResult().getName())
                );
            } else if (loginControllerResult.getResult().getName() == null) {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        format("Usuário %s não encontrado.", loginControllerResult.getResult().getRegistration())
                );
            } else {
                JOptionPane.showMessageDialog(
                        parentComponent,
                        format("Senha incorreta para %s.", loginControllerResult.getResult().getRegistration())
                );
            }
        }
    }

}
