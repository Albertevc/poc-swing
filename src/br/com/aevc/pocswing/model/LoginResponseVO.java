package br.com.aevc.pocswing.model;

public class LoginResponseVO {

    private final String nome;
    private final String matricula;
    private final boolean autenticado;

    public LoginResponseVO(String nome, String matricula, boolean autenticado){
        this.nome = nome;
        this.matricula = matricula;
        this.autenticado = autenticado;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean isAutenticado() {
        return autenticado;
    }
}
