package br.com.luigipietro.desafios.desafios04;

import java.util.*;

public class Desafio0401 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        int nLinhas = scan.nextInt();
        for (int i = 0; i < nLinhas; i++){
            List<String> palavras = new ArrayList<>();
            String []entrada = scan.next().split(" ");

            for(String palavra: entrada){
                palavras.add(palavra);
            }

            Collections.sort(palavras, new Comparator<String>() {
                @Override
                public int compare(String palavra1, String palavra2) {
                    int dif = palavra2.length() - palavra1.length();
                    if (dif != 0) return dif;
                    return palavra1.compareTo(palavra2);
                }
            });

            for (String palavra: palavras){
                System.out.print(palavra + " ");
            }
            System.out.println("");
        }
    }
}
