package br.com.luigipietro.desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Desafio0201 {
    public static void main(String[] args) throws IOException {
        List<Double> valores = new ArrayList<>();
        final Integer max = 6;
        int positivos = 0;

        System.out.println("Digitaí mano, tudo na mesma linha:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            System.out.println(st.nextToken().toString());
        }


        for (int i = 0; i <max; i++) {
            valores.add(Double.parseDouble(st.nextToken()));
        }*/

        for (int i = 0; i <max; i++) {
            valores.add(Double.parseDouble(br.readLine()));
        }

        for (Double valor : valores){
            if (valor > 0) positivos++;
        }
        System.out.println(positivos + " valores positivos");
    }
}
