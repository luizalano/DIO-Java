public class Calculadora {

    public int somar(String experssao) {
        int soma = 0;
        for (String valor : experssao.split("\\+")) soma += Integer.parseInt(valor);

        System.out.println(soma);
        return soma;
    }
}
