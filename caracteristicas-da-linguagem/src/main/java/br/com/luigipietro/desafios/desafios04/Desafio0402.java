package br.com.luigipietro.desafios.desafios04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Le a entrada padrão. Duas linhas, enquanto tiver linha para ser lida.
Procura a maior substring comum entre as duas linhas
 */
public class Desafio0402 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha1;

        System.out.println("Primeira linha:");
        linha1 = br.readLine();
        while (linha1.length() > 0) {
            int max;
            System.out.println("Segunda linha:");
            String linha2 = br.readLine();
            String palavra1, palavra2;

            // a maior substring possível é do tamanho da menor palavra
            if (linha1.length() > linha2.length()) {
                palavra1 = linha2;
                palavra2 = linha1;
            }
            else {
                palavra1 = linha1;
                palavra2 = linha2;
            }

            max = palavra1.length();

            boolean continua = true;
            while (max > 0 && continua){
                int limite = palavra1.length() - max;
                for (int i = 0; i <= limite; i++){
                    String subs = palavra1.substring(i, i + max);
                    if (palavra2.contains(subs)) continua = false;
                }
                if (continua) max--;
            }
            System.out.println("maior subs:" + max);
            System.out.println("Primeira linha:");
            if ((linha1 = br.readLine()) == null) linha1="";
        }
    }
}
