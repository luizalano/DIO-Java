package br.com.luigipietro.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploDeComparator {
    public static void main(String[] args) {
        List<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Jão", 23));
        estudantes.add(new Estudante("Pedro", 14));
        estudantes.add(new Estudante("Maria", 87));
        estudantes.add(new Estudante("Ana Júlia", 18));
        estudantes.add(new Estudante("Zonia", 14));
        estudantes.add(new Estudante("Xênia", 42));
        estudantes.add(new Estudante("Zenildília", 79));

        System.out.println("Lista original *******************");
        System.out.println(estudantes);

        estudantes.sort((primeiro, segundo) -> segundo.getIdade() - primeiro.getIdade());
        System.out.println("\nLista ordenada decrescente *******************");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade));
        System.out.println("\nLista ordenada *******************");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());
        System.out.println("\nLista reordenada reversa *******************");
        System.out.println(estudantes);

        Collections.sort(estudantes);
        System.out.println("\nLista ordenada com collections *******************");
        System.out.println(estudantes);

        Collections.sort(estudantes, new EstudanteOrdemReversa());
        System.out.println("\nLista ordenada reversa com collections *******************");
        System.out.println(estudantes);
    }
}
