package br.com.luigipietro.desafios;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.function.UnaryOperator;

public class Desafio0102 {
    public static void main(String[] args) throws IOException {
        System.out.println("Digitaí. Dois números em uma linha:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        UnaryOperator<Integer> produto = b -> b*a;

        int b = Integer.parseInt(st.nextToken());
        int total = a * b; // Altere o valor da variável com o cálculo esperado
        System.out.println("PROD = " + String.valueOf(produto.apply(b)));
    }
}
