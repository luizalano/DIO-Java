package br.com.luigipietro.desafios.desafios03;

import java.util.*;

public class Desafio0301 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> listaPar = new ArrayList<>();
        List<Integer> listaImpar = new ArrayList<>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            int entrada = scan.nextInt();
            if (entrada%2 == 0) listaPar.add(entrada);
            else listaImpar.add(entrada);
        }
        Collections.sort(listaPar);

        Collections.sort(listaImpar, new Comparator<Integer>() {

            @Override
            public int compare(Integer n1, Integer n2) {

                return n2 - n1;

            }
        });

        for (int num: listaPar) {
            System.out.println(num);
        }
        for (int num: listaImpar) {
            System.out.println(num);
        }
    }
}
