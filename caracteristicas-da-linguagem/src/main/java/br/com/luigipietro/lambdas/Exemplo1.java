package br.com.luigipietro.lambdas;

public class Exemplo1 {
    public static void main(String[] args) {
        FuncaoDaqui gerarUmaSaida = (valor, v2) -> valor + " == " + v2;
        System.out.println(gerarUmaSaida.gerar("Xis", " Epsilon"));
    }

}

@FunctionalInterface
interface FuncaoDaqui {
    String gerar(String valor, String v2);
}
