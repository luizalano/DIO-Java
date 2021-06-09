package br.com.luigipietro.desafios.desafios05;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Desafio050602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        Integer n = scanner.nextInt();
        scanner.nextLine();

        BigDecimal valor;
        BigDecimal resultado = BigDecimal.ONE;
        String operacao;

        while (n > 0 && n < 100000){
            String entrada = scanner.nextLine();
            if (entrada.split(" ")[0].length() > 1) break;

            valor = new BigDecimal((entrada.split(" ")[0]));
            operacao = entrada.split(" ")[1];

            if (operacao.equals("*")) resultado = resultado.multiply(valor);
            if (operacao.equals("/")) {
                if (valor.compareTo(BigDecimal.ZERO) == 0) continue;
                resultado = resultado.divide(valor, 3, RoundingMode.CEILING);
            }
            n--;
        }
        scanner.close();
        BigDecimal maxInt = new BigDecimal(Integer.MAX_VALUE);
        if (resultado.compareTo(maxInt) > 0) System.out.println(resultado);
        else System.out.println(resultado.intValue());
    }
}
