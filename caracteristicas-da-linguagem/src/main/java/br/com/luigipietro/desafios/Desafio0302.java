package br.com.luigipietro.desafios;

import java.util.*;

public class Desafio0302 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        List<String> lista = new ArrayList<>();
        System.out.println("Quantos?");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            System.out.println("Falaí:");

            String[] entrada = scan.next().split(" ");
            lista.clear();
            for (String produto: entrada) {
                if (!lista.contains(produto)) lista.add(produto);
            }
            Collections.sort(lista);
            for (String produto: lista) {
                System.out.print(produto + " ");
            }
            System.out.println();
        }
    }
}

