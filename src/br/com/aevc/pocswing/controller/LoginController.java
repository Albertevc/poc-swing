package br.com.aevc.pocswing.controller;

import br.com.aevc.pocswing.model.LoginDTO;
import br.com.aevc.pocswing.model.LoginResponseVO;
import br.com.aevc.pocswing.model.dao.UserDAO;
import br.com.aevc.pocswing.service.LoginService;
import br.com.aevc.pocswing.service.exception.SystemException;

/**
 * @author alber
 */
public class LoginController {

    private static final LoginController INSTANCE = new LoginController(new LoginService(new UserDAO()));

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public static LoginController getInstance() {
        return INSTANCE;
    }

    public ControllerResult<LoginResponseVO> login(LoginDTO loginDTO) {
        try {
            return new ControllerResult<>(this.loginService.login(loginDTO));
        } catch (SystemException e) {
            return new ControllerResult<>(e);
        }

    }

}
