package br.com.luigipietro.lambdas;

public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calculo soma = Integer::sum;
        Calculo multiplica = (a, b) -> a * b;
        Calculo areaQuadrados = (a, b) -> {
            int val;
            val = a * a - b * b;
            if (val < 0) val *= -1;
            return val;
        };
        System.out.println(executarOperacao(soma, 45, 98));
        System.out.println(executarOperacao(multiplica, 45, 98));
        System.out.println(executarOperacao(areaQuadrados, 45, 98));
    }

    public static int executarOperacao (Calculo calculo, int a, int b){
        return calculo.calculo(a, b);
    }
}

interface Calculo {
    public int calculo (int a, int b);
}
