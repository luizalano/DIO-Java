package br.com.luigipietro.lambdas;

import java.util.function.Consumer;

public class UsoDeConsumer {
    public static void main(String[] args) {
        //
        // Não retorna nada, apenas executa alguma coisa
        //
        Consumer<String> imprimirUmaFrase = System.out::println;
        Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase + " com rabo");

        imprimirUmaFrase.accept("Uma frase");
        imprimirUmaFrase2.accept("Outra frase");


    }
}
