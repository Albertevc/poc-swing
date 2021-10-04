package br.com.aevc.pocswing.controller;

import br.com.aevc.pocswing.model.LoginDTO;
import br.com.aevc.pocswing.model.LoginResponseVO;
import br.com.aevc.pocswing.service.LoginService;
import br.com.aevc.pocswing.service.exception.SystemException;

/**
 * @author alber
 */
public class LoginController {

    private static final LoginController INSTANCE = new LoginController();

    private final LoginService loginService = new LoginService();

    private LoginController() {
    }

    public static LoginController getInstance() {
        return INSTANCE;
    }

    public ControllerResult<LoginResponseVO> login(LoginDTO loginDTO) {
        try {
            return new ControllerResult(this.loginService.login(loginDTO));
        } catch (SystemException e) {
            return new ControllerResult(e);
        }

    }

}
