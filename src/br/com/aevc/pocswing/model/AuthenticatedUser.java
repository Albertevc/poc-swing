package br.com.aevc.pocswing.model;

public class AuthenticatedUser {

    private final String nome;
    private final String matricula;

    public AuthenticatedUser(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

}
