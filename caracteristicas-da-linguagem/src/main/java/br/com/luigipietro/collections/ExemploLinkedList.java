package br.com.luigipietro.collections;

import java.util.LinkedList;
import java.util.Queue;

public class ExemploLinkedList {
    public static void main(String[] args) {

        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("João");
        filaBanco.add("Pedro");
        filaBanco.add("Catarina");
        filaBanco.add("Paulo");
        filaBanco.add("Paulo");

        System.out.println(filaBanco);

        System.out.println("\n");
        String ome = filaBanco.poll();
        System.out.println("Após poll " + ome);
        System.out.println(filaBanco);

        System.out.println("\n");
        ome = filaBanco.peek();
        System.out.println("Após peek " + ome);
        System.out.println(filaBanco);

        System.out.println("\n");
        ome = filaBanco.element();
        System.out.println("Após element " + ome);
        System.out.println(filaBanco);

        for (String cliente: filaBanco) {
            System.out.println("Na fila: " + cliente);
        }
    }
}
