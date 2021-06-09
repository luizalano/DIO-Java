package br.com.luigipietro.desafios.desafios05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class Desafio0502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Aliens:");
        String aliens = br.readLine();

        while(true) {
            System.out.println("Sua frase:");
            String frase = br.readLine();

            String[] letrasAliens = aliens.split("");

            ArrayList<String> letrasFrase = new ArrayList<String>(Arrays.asList(frase.split("")));

            SortedMap<String, Integer> contaQuant = new TreeMap<>();
            letrasFrase.forEach(letra -> contaQuant.compute(letra, (k, valor) -> (valor == null ? 1 : valor + 1)));

            Integer numAliens = 0;

            for (String letra: letrasAliens) {
                Integer valor = contaQuant.get(letra);
                if (valor != null){
                    numAliens += valor;
                }
            }

            System.out.println(numAliens);

            System.out.println("Aliens:");
            if ((aliens = br.readLine()) == null) aliens = "";
            if (aliens.equals("")) break;
        }
    }
}
