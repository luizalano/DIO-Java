package br.com.luigipietro.desafios;
/*
Desafio
O feudo da Mesopotâmia é rico e o povo é cordial e alegre. Mas quando o assunto são impostos, é praticamente um roubo. Todo final de ano, cada feudo do país deve pagar uma determinada quantidade de quilos de ouro em impostos. Quando é chegado o momento de coletar os impostos, o Rei envia sua carruagem real para recolher o ouro devido, usando as estradas do reino.

Cada estrada liga dois feudos diferentes e podem ser percorridos em duas direções. Com as estradas é possível ir de um feudo a outro, possivelmente passando por feudos intermediários. Mas há apenas um caminho entre dois feudos diferentes.

Em cada feudo há um cofre real, utilizado para armazenamento do ouro de impostos. Os cofres reais são imensos, de forma que cada cofre tem capacidade de armazenar todo o ouro devido por todo o reino. A carruagem sai do feudo principal, percorrendo as estradas do reino, visitando os feudos para recolher o ouro devido, podendo usar qualquer cofre real para armazenar temporariamente uma parte do imposto recolhido, se necessário. Ao final da coleta, todo o ouro devido por todas os feudos devem estar armazenados no cofre real do feudo principal.

José como é o Rei, contratou o seu time para, dados a quantidade de ouro a ser recolhido em cada feudo (em kg), a lista das estradas do reino, com os respectivos comprimentos (em km) e a capacidade de carga da carruagem real (em kg), determine qual é a mínima distância que a carruagem deve percorrer para recolher todo o ouro devido.

Entrada
A primeira linha contém dois inteiros N e C indicando respectivamente o
número de cidades e a capacidade de carga da carruagem (2 ≤ N ≤ 104 e 1 ≤ C ≤ 100).
O feudo principal é identificado pelo número 1 e os outros feudos são identificadas
por inteiros de 2 a N .
A segunda linha contém N inteiros Ei representando a quantidade de imposto devido
por cada feudo i (0 ≤ Ei ≤ 100 para 1 ≤ i ≤ N ). Cada uma das N-1 linhas seguintes
contém três inteiros A , B e C , indicando que uma estrada liga o feudo A e o
feudo B (1 ≤ A, B ≤ N ) e tem comprimento C (1 ≤ C ≤ 100).

Saída
Seu programa deve produzir uma única linha com um inteiro representando a menor
distância que a carruagem real deve percorrer para recolher o o imposto devido, em km.

Não está saindo como esperado

Fiz algumas alteações na estrutura, mas não consegui identificar onde esta o erro.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Desafio0507 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCidades;
        int capacidadeCarruagem;
        int totalPercorrido;
        String[] entrada;
        List<Cidade> cidades = new ArrayList<>();
        List<Integer> impostoDevidoPorCidade =  new ArrayList<>();

        // le a primeira linha de entrada
        //   -> Número de cidades
        //   -> Capacidade da carruagem
        System.out.println("Quantas cidades e capacidade da carruagem");
        entrada = scanner.nextLine().split(" ");

        nCidades = Integer.parseInt(entrada[0]);
        capacidadeCarruagem = Integer.parseInt(entrada[1]);

        // Le a segunda linha de entrada
        // O imposto devido por cada feudo
        System.out.printf("Imposto devido por cada feudo (%d feudos)\n", nCidades);
        Arrays.asList(scanner.nextLine().split(" ")).forEach(impDev -> {
            impostoDevidoPorCidade.add(Integer.parseInt(impDev));
        });

        // Cria a lista de cidades com o imposto devido
        for (int impDev: impostoDevidoPorCidade) {
            cidades.add(new Cidade(impDev));
        }

        // Le as demais linhas de entrada
        // Para cada cidade (menos para a sede - cidade 1):
        //      -> cidade de origem
        //      -> cidade de destino
        //      -> distância percorrida
        for (int i = 1; i < nCidades; i++){
            System.out.println("Cdade1 cidade2 distância");
            String[] dados = scanner.nextLine().split(" ");
            int a = Integer.parseInt(dados[0]);
            int b = Integer.parseInt(dados[1]);
            int d = Integer.parseInt(dados[2]);

            // Adiciona os caminhas de a para b e de b para a
            // nos respectiovos objetos
            // O índica da cidade na lista é o seu id - 1
            cidades.get(a-1).addPath(cidades.get(b-1),d);
            cidades.get(b-1).addPath(cidades.get(a-1),d);
        }

        // A partir da cidade 1, calcula a distâncoia para percorrer
        totalPercorrido = cidades.get(0).calculaDistancia(null, capacidadeCarruagem);

        System.out.println(totalPercorrido);

    }
}

class Caminho {
    /*
    O caminho pertence à uma cidade, por isso tem somente o destino e a distância até este ponto
    A origem é a cidade que detém a lista de caminhos
     */
    Cidade cidadeDestino;
    int distancia;

    Caminho(Cidade destino, int distancia) {
        this.cidadeDestino = destino;
        this.distancia = distancia;
    }
}

class Cidade {
    double impostoDevido;
    List<Caminho> listaCaminhos;

    public Cidade(int impostoDevido) {
        this.impostoDevido = impostoDevido;
        this.listaCaminhos = new ArrayList<>();
    }

    public void addPath(Cidade destino, int distancia) {
        /*
        Adiciona na lista de caminhos, a cidade destino e a distância até ela
         */
        listaCaminhos.add(new Caminho(destino, distancia));
    }

    public int calculaDistancia (Cidade cidadeAnterior, int capacidadeCarrugem) {
        int distanciaTotal = 0;
        int numeroArcos = 0;

        for (Caminho caminho: listaCaminhos){
            if (caminho.cidadeDestino == cidadeAnterior){
                continue;
            }

            distanciaTotal += caminho.cidadeDestino.calculaDistancia(this, capacidadeCarrugem);
            numeroArcos = (int) Math.ceil(caminho.cidadeDestino.impostoDevido / capacidadeCarrugem);
            distanciaTotal += numeroArcos * caminho.distancia;
            this.impostoDevido += caminho.cidadeDestino.impostoDevido;
        }
        return distanciaTotal;
    }
}

