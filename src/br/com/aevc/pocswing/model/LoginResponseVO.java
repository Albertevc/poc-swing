package br.com.aevc.pocswing.model;

public class LoginResponseVO {

    private final String name;
    private final String registration;
    private final boolean authenticated;

    public LoginResponseVO(String name, String registration, boolean authenticated){
        this.name = name;
        this.registration = registration;
        this.authenticated = authenticated;
    }

    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    public boolean authenticated() {
        return authenticated;
    }
}
