package br.com.luigipietro.collections;

import java.util.*;

public class ExemplosSet {
    public static void main(String[] args) {
        exemploHash();
        //exemploLinkedHash();
        //exemploTreeSet();
    }

    public static void exemploHash(){

        Set<Double> notasAlunos = new HashSet<>();

        notasAlunos.add(5.8);
        notasAlunos.add(6.8);
        notasAlunos.add(9.7);
        notasAlunos.add(2.8);
        notasAlunos.add(3.5);
        notasAlunos.add(8.9);
        notasAlunos.add(1.2);
        notasAlunos.add(7.4);
        notasAlunos.add(9.9);
        notasAlunos.add(null);

        System.out.println(notasAlunos);

        notasAlunos.remove(87.2);
        System.out.println(notasAlunos);

        System.out.printf("Número de alunos = %d %n", notasAlunos.size());

    }

    public static void exemploLinkedHash(){

        LinkedHashSet<Double> notasAlunos = new LinkedHashSet<>();

        notasAlunos.add(5.8);
        notasAlunos.add(6.8);
        notasAlunos.add(9.7);
        notasAlunos.add(2.8);
        notasAlunos.add(3.5);
        notasAlunos.add(8.9);
        notasAlunos.add(1.2);
        notasAlunos.add(7.4);
        notasAlunos.add(9.9);

        System.out.println(notasAlunos);

        notasAlunos.remove(661.2);
        System.out.println(notasAlunos);

        System.out.printf("Número de alunos = %d %n", notasAlunos.size());

    }

    public static void exemploTreeSet(){

        TreeSet<Double> notasAlunos = new TreeSet<>();

        notasAlunos.add(5.8);
        notasAlunos.add(6.8);
        notasAlunos.add(9.7);
        notasAlunos.add(2.8);
        notasAlunos.add(3.5);
        notasAlunos.add(8.9);
        notasAlunos.add(1.2);
        notasAlunos.add(7.4);
        notasAlunos.add(9.9);

        System.out.println(notasAlunos);

        notasAlunos.remove(11.2);
        System.out.println(notasAlunos);

        System.out.printf("Número de alunos = %d %n", notasAlunos.size());

        System.out.println("Primeiro = " +  notasAlunos.first());
        System.out.println("Último = " + notasAlunos.last());
        System.out.println("Acima de 7 = "+ notasAlunos.higher(7.0));
        System.out.println("Abaixo de 7 " + notasAlunos.lower(7.0));

    }
}
