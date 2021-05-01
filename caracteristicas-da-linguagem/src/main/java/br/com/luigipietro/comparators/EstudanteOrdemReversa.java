package br.com.luigipietro.comparators;

import java.util.Comparator;

public class EstudanteOrdemReversa implements Comparator<Estudante> {
    /*
    O método compareTo da classe específica serve para comprar o objeto instanciado com outro
    objeto da mesma classe
    A classe Comparator server para que outros objetos possam comparar dois objetos de
    uma mesma classe
     */
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return o2.getIdade() - o1.getIdade();
    }
}
