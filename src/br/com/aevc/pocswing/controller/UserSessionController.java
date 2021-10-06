package br.com.aevc.pocswing.controller;

import br.com.aevc.pocswing.model.AuthenticatedUser;

public class UserSessionController {

    private static final UserSessionController INSTANCE = new UserSessionController();
    private AuthenticatedUser authenticatedUser;

    private UserSessionController(){

    }

    public static UserSessionController getInstance(){
        return INSTANCE;
    }

    public void initSession(
            String userName,
            String registration
    ){
      this.authenticatedUser = new AuthenticatedUser(userName, registration);
    }

    public AuthenticatedUser getAuthenticatedUser(){
        return this.authenticatedUser;
    }

}
