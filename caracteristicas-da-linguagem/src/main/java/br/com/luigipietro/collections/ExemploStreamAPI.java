package br.com.luigipietro.collections;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStreamAPI {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Luiz Alberto Alano");
        nomes.add("Daniel de Macedo Alano");
        nomes.add("Paula de Macedo Alano");
        nomes.add("Zé Mané");
        nomes.add("Ganesh");
        nomes.add("Analu");
        nomes.add("Anala");
        nomes.add("Tia Nice");
        nomes.add("Vovózinha");
        nomes.add("Tio Delphino");

        System.out.println(nomes);
        System.out.println("Tem " + nomes.stream().count() + " elementos!") ;

        System.out.println("Quem tem o maior nome " +
                nomes.stream().max(Comparator.comparingInt(String::length))) ;
        System.out.println("Quem tem o menor nome " +
                nomes.stream().min(Comparator.comparingInt(String::length))) ;
        System.out.println("Quem tem D no  nome " +
                nomes.stream().filter((nome) ->
                        nome.toLowerCase().contains("d")).collect(Collectors.toList()));

        System.out.println("Todos tem A no nome? " +
                nomes.stream().allMatch((nome) -> nome.toLowerCase().contains("a")));

        System.out.println("Alguém tem A no nome? " +
                nomes.stream().anyMatch((nome) -> nome.toLowerCase().contains("a")));

        System.out.println("\n\nNão casa nenhum? " +
                nomes.stream().noneMatch((nome) -> nome.toLowerCase().contains("#")));

        System.out.println("Nome + tamanho" +
                nomes.stream().map(nome ->
                        nome.concat(" - ").concat(String.valueOf(nome.length()))).collect(Collectors.toList()) );

        System.out.println("3 primeiros elementos " +
                nomes.stream().limit(3).collect(Collectors.toList())) ;

        System.out.println("Lista todos os elementos e retorna a coleção inteira " +
                nomes.stream().peek(System.out::println).collect(Collectors.toList())) ;

        System.out.println("Lista todos os elementos ");
        nomes.stream().forEach(System.out::println);

        System.out.println("\nOperação encadeada ");
        System.out.println(nomes.stream()
                .peek(System.out::println)
                .map(nome -> nome.concat(" - ").concat(String.valueOf(nome.length())))
                .peek(System.out::println)
                .filter((nome) -> nome.toLowerCase().contains("a"))
                .collect(Collectors.toList())
        );

        System.out.println("\nOperação encadeada 2");
        System.out.println(nomes.stream()
                .peek(System.out::println)
                .map(nome -> nome.concat(" - ").concat(String.valueOf(nome.length())))
                .peek(System.out::println)
                .filter((nome) -> nome.toLowerCase().contains("a"))
                .collect(Collectors.joining("| "))
        );

        System.out.println("\nOperação encadeada 3");
        System.out.println(nomes.stream()
                .peek(System.out::println)
                .map(nome -> nome.concat(" - ").concat(String.valueOf(nome.length())))
                .peek(System.out::println)
                .filter((nome) -> nome.toLowerCase().contains("a"))
                .collect(Collectors.toSet())
        );

        System.out.println("\nOperação encadeada 4");
        System.out.println(nomes.stream()
                .peek(System.out::println)
                .map(nome -> nome.concat(" - ").concat(String.valueOf(nome.length())))
                .peek(System.out::println)
                .filter((nome) -> nome.toLowerCase().contains("a"))
                .collect(Collectors.groupingBy(nome -> nome.substring(nome.indexOf(" - ") + 3)))
        );

    }
}
