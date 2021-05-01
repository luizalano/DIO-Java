package br.com.luigipietro.strings;

public class StringFormat {
    public static void main(String[] args) {

        var nome = "Andréff";
        var sobreNome = "Gomes";
        final var nomeCompleto = nome + sobreNome;

        System.out.println(nome);
        System.out.println("Nome do cliente : " + nome);
        System.out.println("Nome completo do cliente : " + nomeCompleto);
        final var mensagem = String.format("O cliente %s possui sobre nome %s ", nome, sobreNome);
        System.out.println(mensagem);

        System.out.printf("Numero %.2f %n", 1.2375d);
    }
}
