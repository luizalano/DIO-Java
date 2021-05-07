package br.com.luigipietro.lambdas;

public class Fatorial {
    public static void main(String[] args) {
        System.out.println(fatorial(5));
    }

    private static double fatorial(double valor) {
        return fatorialComTailCall(valor, 1);
    }

    private static double fatorialComTailCall(double valor, double numero) {
        if (valor == 1) return numero;
        return fatorialComTailCall(valor -1, numero*valor);
    }
}
