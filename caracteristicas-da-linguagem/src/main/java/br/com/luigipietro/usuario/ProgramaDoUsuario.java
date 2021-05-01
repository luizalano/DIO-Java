

package br.com.luigipietro.usuario;

public class ProgramaDoUsuario {

    public static void main(String[] args) {
        final var superUsuario = new SuperUsuario("root", "12345");

        superUsuario.getLogin();
        superUsuario.getSenha();

        String root = superUsuario.nome;

        Integer i = 9;
    }
}
