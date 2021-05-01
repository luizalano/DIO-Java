package br.com.luigipietro.testesVarios;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ExemploOptional {
    public static void main(String[] args) {
        Optional<String> opcionalString = Optional.of("Uma String de inicialização");
        System.out.println("Imprime o valor do objeto ou mensagem padrão");
        opcionalString.ifPresentOrElse(System.out::println,()-> System.out.println("Conteúdo nullo"));

        Optional<String> opcionalNulo = Optional.ofNullable(null);
        System.out.println("\nImprime o valor do objeto ou mensagem padrão");
        opcionalNulo.ifPresentOrElse(System.out::println,()-> System.out.println("Conteúdo nullo"));

        Optional<String> opcionalEmpty = Optional.empty();
        System.out.println("\nImprime o valor do objeto ou mensagem padrão");
        opcionalEmpty.ifPresentOrElse(System.out::println,()-> System.out.println("Conteúdo nullo"));

        OptionalInt opcionalInt = OptionalInt.of(34);
        System.out.println("\nImprime o valor do objeto ou mensagem padrão - Int");
        opcionalInt.ifPresentOrElse(System.out::println,()-> System.out.println("Conteúdo nullo"));

        System.out.println("Imprime o valor do objeto ou mensagem padrão - Long");
        OptionalLong.of(6767L).ifPresentOrElse(System.out::println,()-> System.out.println("Conteúdo nullo"));

        System.out.println("Imprime o valor do objeto ou mensagem padrão - Double");
        OptionalDouble.of(6767.8676).ifPresentOrElse(System.out::println,()-> System.out.println("Conteúdo nullo"));

        System.out.println("\nPresente - vazio");
        System.out.println(opcionalString.isPresent());
        System.out.println(opcionalString.isEmpty());

        System.out.println("\nConteúdo");
        System.out.println(opcionalString.get());

        System.out.println("\nMap e print");
        opcionalString.map((valor) -> valor.concat("*********")).ifPresent((System.out::println));

        /*Optional<String> opcionalNullErro = Optional.of(null);
        System.out.println("Imprime o valor do objeto ou mensagem padrão");
        opcionalNullErro.ifPresentOrElse(System.out::println,()-> System.out.println("Conteúdo nullo"));
*/
    }
}
