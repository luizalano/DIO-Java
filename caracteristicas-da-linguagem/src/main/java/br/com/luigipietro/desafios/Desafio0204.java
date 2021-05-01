package br.com.luigipietro.desafios;

import java.util.Scanner;

public class Desafio0204 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        int de100 = 0;
        int de50 = 0;
        int de20 = 0;
        int de10 = 0;
        int de5 = 0;
        int de2 = 0;
        int de1 = 0;
        int resto = 0;
        int valor = scan.nextInt();

        de100 = (int) valor / 100;
        resto = valor - de100 * 100;

        de50 = (int) resto / 50;
        resto = resto - de50 * 50;

        de20 = (int) resto / 20;
        resto = resto - de20 * 20;

        de10 = (int) resto / 10;
        resto = resto - de10 * 10;

        de5 = (int) resto / 5;
        resto = resto - de5 * 5;

        de2 = (int) resto / 2;
        resto = resto - de2 * 2;

        de1 = resto;

        System.out.println(valor);
        System.out.println(de100 + " nota(s) de R$ 100,00");
        System.out.println(de50 + " nota(s) de R$ 50,00");
        System.out.println(de20 + " nota(s) de R$ 20,00");
        System.out.println(de10 + " nota(s) de R$ 10,00");
        System.out.println(de5 + " nota(s) de R$ 5,00");
        System.out.println(de2 + " nota(s) de R$ 2,00");
        System.out.println(de1 + " nota(s) de R$ 1,00");
    }
}
