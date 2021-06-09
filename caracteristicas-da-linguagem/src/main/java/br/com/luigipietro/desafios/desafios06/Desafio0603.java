package br.com.luigipietro.desafios.desafios06;

import java.util.Scanner;

public class Desafio0603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos casos?");
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            System.out.println("Caso " + i + " ->");
            String[] palavras = sc.nextLine().split(" ");
            String resultado = "";
            int tam0 = palavras[0].length();
            int tam1 = palavras[1].length();
            if (tam0 > tam1) {
                for (int j = 0; j < palavras[1].length(); j++) {
                    resultado += palavras[0].substring(j, j + 1) + palavras[1].substring(j, j + 1);
                }
                resultado += palavras[0].substring(tam1);
            } else {
                for (int j = 0; j < palavras[0].length(); j++) {
                    resultado += palavras[0].substring(j, j + 1) + palavras[1].substring(j, j + 1);
                }
                if (tam0 != tam1) resultado += palavras[1].substring(tam0);
            }
            System.out.println(resultado);
        }
    }
}
