package br.com.luigipietro.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsandoIteracoes {
    public static void main(String[] args) {
        String[] nomes = {"João", "Pedro", "Paulo", "Maria", "Joana", "Paula", "Margonha"};
        Integer[] numeros = {1,2,3,4,67};
        imprimirNomesFiltrados(nomes);
        imprimeTudo(nomes);

        List<String> profissoes = new ArrayList<>();
        profissoes.add("Engenheiro Civil");
        profissoes.add("Engenheiro Químico");
        profissoes.add("Professor");
        profissoes.add("Engenheiro Mecânico");
        profissoes.add("Político");
        profissoes.add("Assaltante");

        //
        //  Coloca toda a lista em uma stream e se usa como se fosse uma stream
        //
        profissoes.stream()
                .filter(profissao -> profissao.toLowerCase().contains("eng"))
                .forEach(System.out::println);
    }

    public static void imprimirNomesFiltrados(String ... nomes){
        StringBuilder filtrados = new StringBuilder();
        for (String nome : nomes) {
            if (nome.toLowerCase().contains("o")) filtrados.append(nome).append(" ");
        }

        String filtradosPorStream = Stream.of(nomes)
                .filter(nome -> nome.toLowerCase().contains("o"))
                .collect(Collectors.joining(" "));

        System.out.println(filtrados);
        System.out.println(filtradosPorStream);
    }

    public static void imprimeTudo(String... nomes){

        Stream.of(nomes)
                .forEach(nome -> {
                    StringBuilder nom = new StringBuilder();
                    nom.append(nome);
                    nom.reverse();
                    System.out.println(nom.toString());
                });
    }
}
