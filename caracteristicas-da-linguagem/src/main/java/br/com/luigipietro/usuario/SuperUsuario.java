package br.com.luigipietro.usuario;

import java.util.Objects;

public class SuperUsuario {

    private String login;
    private String senha;
    String nome;

    public SuperUsuario(final String login, final String senha){
        this.login = login;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperUsuario that = (SuperUsuario) o;
        return login.equals(that.login) && senha.equals(that.senha) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, senha, nome);
    }
}
