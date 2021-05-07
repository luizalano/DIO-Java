package br.com.luigipietro.lambdas;

import java.util.function.Predicate;

public class UsandoPredicates {
    public static void main(String[] args) {
        //
        // Predicates sempre retornam boolean
        //
        Predicate<String> estaVazio = valor -> valor.isEmpty();
        Predicate<String> taVazio = String::isEmpty;

        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Tá vazio não"));

        System.out.println(taVazio.test(""));
        System.out.println(taVazio.test("Tá vazio não"));
    }
}
