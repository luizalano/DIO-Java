package br.com.luigipietro.desafios.desafios03;

import java.util.*;

public class Desafio0304 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Quantos testes?");
        Integer nTestes = scan.nextInt();

        for(int i = 0; i < nTestes; i++){
            List<Integer> original = new ArrayList<>();
            List<Integer> ordenada = new ArrayList<>();

            System.out.println("Quantos clientes?");
            Integer nClientes = scan.nextInt();

            System.out.println("Lista de senhas");
            String[] senhas = scan.next().split(" ");
            for(int j = 0; j < nClientes; j++){
                original.add(Integer.parseInt(senhas[j]));
                ordenada.add(Integer.parseInt(senhas[j]));
            }
            Collections.sort(ordenada, new Comparator<Integer>() {
                @Override
                public int compare(Integer numero1, Integer numero2) {
                    return numero2 - numero1;
                }
            });

            int ficam = 0;
            for (int j=0; j < original.size(); j++){
                System.out.println(original.get(j) + " -> " + ordenada.get(j) + " <> " + original.get(j).equals(ordenada.get(j)));
                if (original.get(j).equals(ordenada.get(j))) ficam++;
            }
            System.out.println(ficam);
        }
    }
}
