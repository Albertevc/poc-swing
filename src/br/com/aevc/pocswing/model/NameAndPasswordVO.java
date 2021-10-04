package br.com.aevc.pocswing.model;

public class NameAndPasswordVO {

    private final String name;
    private final String password;

    public NameAndPasswordVO() {
        this.name = null;
        this.password = null;
    }

    public NameAndPasswordVO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
