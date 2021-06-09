package br.com.luigipietro.desafios.desafios04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Desafio0405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Diz aí:");
        String entrada = br.readLine();

        while (true){

            // pesquisa _
            while (true){
                if (entrada.contains("_")){
                    entrada = entrada.replaceFirst("_","<i>");
                    entrada = entrada.replaceFirst("_","</i>");
                }
                else break;
            }
            // pesquisa *
            while (true){
                if (entrada.contains("*")){
                    entrada = entrada.replaceFirst("\\*", "<b>");
                    entrada = entrada.replaceFirst("\\*", "</b>");
                }
                else break;
            }

            System.out.println(entrada);
            System.out.println("Diz aí:");
            if ((entrada = br.readLine()) == null) break;
        }
    }
}
