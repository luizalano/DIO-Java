package br.com.luigipietro.desafios.desafios05;
/*
Desafio
Nesse algoritmo você deverá descobrir se um conjunto de palavras é bom ou ruim.
Por definição, um conjunto é bom quando nenhuma palavra desse conjunto é
um prefixo de outra palavra.
Caso contrário, é considerado um conjunto ruim.

Por exemplo, {dbc, dae, dbcde} é um conjunto ruim, pois dbc é um
prefixo de dbcde.
Quando duas palavras são idênticas, definimos como uma sendo prefixo da outra.

Entrada
A entrada contém vários casos de teste.
A primeira linha de cada caso de teste terá um inteiro N
que representa a quantidade de palavras no conjunto. S
egue então N linhas, cada uma tendo uma palavra de no máximo 100 letras minúsculas.
A entrada termina quando N = 0 e não deve ser processada.

Saída
Para cada caso de teste, você deverá imprimir "Conjunto Bom",
ou "Conjunto Ruim", conforme explicado acima.

 */
import java.util.*;

public class Desafio0505 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> palavras = new ArrayList<>();

        System.out.println("Quantas palavras?");
        Integer quantos = sc.nextInt();

        while (quantos > 0){
            palavras.clear();

            for (int i = 0; i < quantos; i++){
                System.out.println("Escreve aí a palavra:");
                String palavra = sc.next();
                palavras.add(palavra);
            }

            palavras.sort((primeira, segunda) -> primeira.length() - segunda.length());

            palavras.forEach((palavra) -> System.out.println(palavra));

            boolean deuMatch = false;

            for (int i = 0; i < palavras.size(); i++){
                String padrao = palavras.get(i);
                Integer tamPadrao = padrao.length();

                for (int j = i + 1; j < palavras.size(); j++){
                    String compara = palavras.get(j);
                    if (compara.substring(0, tamPadrao).contains(padrao)) {
                        deuMatch = true;
                        i = j = palavras.size();
                    }
                }
            }

            if (deuMatch) System.out.println("Conjunto Ruim");
            else System.out.println("Conjunto Bom");

            System.out.println("Quantas palavras?");
            quantos = sc.nextInt();
        }
    }
}
