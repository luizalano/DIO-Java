package br.com.luigipietro.lambdas;

import java.util.function.Supplier;

public class UsandoSuppliers {
    public static void main(String[] args) {
        Supplier<Pessoa> suppliers = Pessoa::new;
        Supplier<Pessoa> suppliers2 = () -> new Pessoa();
        Pessoa joao = suppliers.get();
        Pessoa pedro = suppliers.get();

        System.out.println(joao.toString());
        System.out.println(pedro.toString());

        System.out.println(joao == pedro);
    }
}

class Pessoa{
    private String nome;
    private Integer idade;

    public Pessoa(){
        nome = "Seu zé";
        idade = 56;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
