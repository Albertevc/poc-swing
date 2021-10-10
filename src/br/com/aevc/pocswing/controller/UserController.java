package br.com.aevc.pocswing.controller;

import br.com.aevc.pocswing.model.User;
import br.com.aevc.pocswing.service.UserService;
import br.com.aevc.pocswing.service.exception.BusinessException;
import br.com.aevc.pocswing.service.exception.SystemException;

/**
 * @author Natanael
 */
public class UserController {

    private static final UserController INSTANCE = new UserController();

    private final UserService userService = new UserService();

    private UserController() {
    }

    public static UserController getInstance() {
        return INSTANCE;
    }

    public ControllerResult<Void> register(User user) {
        try {
            this.userService.save(user);
            return ControllerResult.success();
        } catch (BusinessException e) {
            return new ControllerResult(e);
        } catch (SystemException e) {
            return new ControllerResult(e);
        }
    }

}
