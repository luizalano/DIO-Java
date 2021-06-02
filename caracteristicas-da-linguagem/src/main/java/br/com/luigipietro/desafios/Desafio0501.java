package br.com.luigipietro.desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Desafio0501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        Locale.setDefault(new Locale("en", "US"));

        ArrayList<Integer> lista = new ArrayList<Integer>();

        System.out.println("Quantos tem?");
        int quantos =sc.nextInt();
        while(quantos >0) {
            System.out.printf("Qual o próximo? (%d): ", quantos);
            lista.add(sc.nextInt());
            quantos--;
        }
        SortedMap<Integer, Integer> contaQuant = new TreeMap<>();
        lista.forEach(id -> contaQuant.compute(id, (k, valor ) -> ( valor   == null ? 1 : valor + 1)));


        contaQuant.entrySet().forEach(entry->{
            System.out.printf("%d aparece %d vez(es)\n", entry.getKey(), entry.getValue());
        });

        sc.close();
    }
}
