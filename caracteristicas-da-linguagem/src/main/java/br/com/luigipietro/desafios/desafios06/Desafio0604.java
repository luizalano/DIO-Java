package br.com.luigipietro.desafios.desafios06;


import java.util.*;

public class Desafio0604 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            int L = sc.nextInt();
            int valHash = 0;

            for (int j = 0; j < L; j++) {
                String linha = sc.next();
                char[] letras = linha.toCharArray();
                for (int k = 0; k < letras.length; k++) {
                    valHash += (int) letras[k] - 65 + j + k;
                }
            }
            System.out.println(valHash);
        }
    }
}
