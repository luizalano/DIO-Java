package br.com.luigipietro.desafios;

import java.util.Scanner;

public class Desafio0203 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));

        int numPar = 0;
        int numImpar = 0;
        int numPos = 0;
        int numNeg = 0;

        for (int i = 0; i< 5; i++){
            var valor = scan.nextInt();
            if (valor != 0){
                if (valor > 0) numPos++; else numNeg++;
            }
            if (valor%2 == 0) numPar++; else numImpar++;
        }


        System.out.println(numPar + " valor(es) par(es)");
        System.out.println(numImpar + " valor(es) impar(es)");
        System.out.println(numPos + " valor(es) positivo(s)");
        System.out.println(numNeg + " valor(es) negativo(s)");
    }
}
