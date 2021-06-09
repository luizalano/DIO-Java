package br.com.luigipietro.desafios.desafios02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Desafio0202 {
    public static void main(String[] args) throws IOException {
        List<Integer> listaPares = new ArrayList<>();

        System.out.println("Digitaí mano:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int meuNumero = Integer.parseInt(br.readLine());

        for (int i = 2; i <=  meuNumero; i+=2) {
            listaPares.add(i);
        }

        for (Integer num: listaPares) {
            System.out.println(num);
        }

    }
}
