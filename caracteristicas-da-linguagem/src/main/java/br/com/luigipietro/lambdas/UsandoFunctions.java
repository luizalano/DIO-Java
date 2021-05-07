package br.com.luigipietro.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UsandoFunctions {
    public static void main(String[] args) {
        Function<String,String> retornarNomeAoContrario = texto ->
                new StringBuilder(texto).reverse().toString();
        Function<String, Integer> somaStringComoInteiros = str1 -> {
            String[] parts = str1.split(" ");
            int val1 = Integer.parseInt(parts[0]);
            int val2 = Integer.parseInt(parts[1]);
            return val1 + val2;
        };

        System.out.println(retornarNomeAoContrario.apply("Luiz Alberto Alano"));
        System.out.println(somaStringComoInteiros.apply("4 6"));
    }
}
