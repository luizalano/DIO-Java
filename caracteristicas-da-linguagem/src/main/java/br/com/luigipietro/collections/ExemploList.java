package br.com.luigipietro.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Luiz Alberto Alano");
        nomes.add("Daniel de Macedo Alano");
        nomes.add("Paula de Macedo Alano");
        nomes.add("Zé Mané");

        System.out.println(nomes);

        Collections.sort(nomes);
        System.out.println(nomes);

        nomes.set(3, "Mané Zé");
        System.out.println(nomes);

        System.out.println("for each ***********************");
        for (String nome:nomes) {
            System.out.println(nome);
        }

        System.out.println("iterator ***********************");
        Iterator<String> iterator = nomes.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
