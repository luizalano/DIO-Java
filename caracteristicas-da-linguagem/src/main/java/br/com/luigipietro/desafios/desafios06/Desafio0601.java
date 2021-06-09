/*

Esta solução excedu o limite de execução na plataforma da DIO


Desafio
Marcos decidiu abandonar o bar da faculdade onde jogava truco para dedicar-se ao mundo da programação.
Para que isso fosse mais fácil, decidiu criar um novo jogo de cartas.

O coração das cartas, como Marcos apelidou o jogo, é individual e jogado com três pilhas,
inicialmente com o mesmo número de cartas. Cada carta tem um valor numérico inteiro de 0 até 9.
O jogador pode, a qualquer momento ver o valor de qualquer carta, mas só pode jogar com as
cartas que estão no topo das pilhas.

Em cada rodada, o jogador pode remover qualquer combinação de cartas que estejam no topo
da pilha (pode escolher 1, 2 ou até 3 cartas) cuja soma dos valores seja múltiplo de 3.

O jogo é ganho quando todas as cartas forem removidas das pilhas.
Se alguma carta não puder ser removida, perde-se o jogo.

Entrada
A entrada é composta por várias instâncias Cada instância é iniciada por um inteiro N (0 ≤ N ≤ 100),
que identifica o número de cartas em cada pilha. A entrada termina quando N = 0.
Cada uma das N linhas seguintes contém três inteiros A, B e C, que descrevem os valores numéricos
das cartas em um nível da pilha (0 ≤ A, B, C ≤  9). As pilhas são descritas do topo até o fundo.

Saída
Para cada instância, imprima uma linha contendo o número 1 se o jogador pode ganhar a instância
do jogo ou o número 0 se o jogo for impossível.


 */
package br.com.luigipietro.desafios.desafios06;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Desafio0601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCamadas;

        while (true){
            System.out.println("Número de camadas:");
            nCamadas = Integer.parseInt(sc.nextLine());
            if (nCamadas == 0) break;

            Jogo jogo = new Jogo(nCamadas);

            for (int i = 0; i < nCamadas; i++){
                System.out.println("Cartas da camada " + i + ":");
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                int a,b,c;
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                jogo.addLinha(a, b, c);
            }

            if (jogo.jogar(0, 0, 0)) System.out.println(1);
            else System.out.println(0);
        }

    }
}

class Jogo {
    private int dimensao;
    int [][] cartas;
    int proximaLinha;

    public Jogo(int dimensao) {
        this.dimensao = dimensao;
        cartas = new int[dimensao][3];
        proximaLinha = 0;
    }

    public void addLinha(int a, int b, int c) {
        cartas[proximaLinha][0] = a;
        cartas[proximaLinha][1] = b;
        cartas[proximaLinha][2] = c;
        proximaLinha++;
    }

    public boolean jogar(int p1, int p2, int p3){
        // Pega as cartas do topo da pilha
        int carta0 = (p1 < dimensao? cartas[p1][0]: (-1));
        int carta1 = (p2 < dimensao? cartas[p2][1]: (-1));
        int carta2 = (p3 < dimensao? cartas[p3][2]: (-1));

        // Verifica se percorreu toda a pilha
        // Se chegou no final da pilha simultaneamente nas três colunas, o jogo
        // acabou com sucesso
        if (p1 == p2 && p2 == p3 && p3 == dimensao){
            return true;
        }

        if (p1 < dimensao){
            if (carta0%3 ==0 && jogar(p1 + 1, p2, p3)){
                return true;
            }
        }

        // Se cosegue retirar a carta da posição p2 da segunda coluna
        // verifica se o jogo consegue prosseguir a partir daí
        if (p2 < dimensao){
            if (carta1%3 ==0 && jogar(p1, p2 + 1, p3)) {
                return true;
            }
        }

        // Se cosegue retirar a carta da posição p3 da terceira coluna
        // verifica se o jogo consegue prosseguir a partir daí
        if (p3 < dimensao){
            if (carta2%3 ==0 && jogar(p1, p2, p3 + 1)) {
                return true;
            }
        }

        // Se consegue retirar as cartas da primeira e segunda colunas nas posições p1 e p2
        // verifica se o jogo consegue prosseguir a partir daí
        if (p1 < dimensao && p2 < dimensao){
            if ((carta0 + carta1)%3 == 0 && jogar(p1 + 1, p2 + 1, p3)) {
                return true;
            }
        }

        // Se consegue retirar as cartas da primeira e terceira colunas nas posições p1 e p3
        // verifica se o jogo consegue prosseguir a partir daí
        if (p1 < dimensao && p3 < dimensao){
            if ((carta0 + carta2)%3 == 0 && jogar(p1 + 1, p2, p3 + 1)) {
                return true;
            }
        }

        // Se consegue retirar as cartas da primeira e segunda colunas nas posições p2 e p3
        // verifica se o jogo consegue prosseguir a partir daí
        if (p2 < dimensao && p3 < dimensao){
            if ((carta1 + carta2)%3 == 0 && jogar(p1, p2 + 1, p3 + 1)) {
                return true;
            }
        }

        // Se consegue retirar as cartas da tres colunas nas posições p1, p2 e p3
        // verifica se o jogo consegue prosseguir a partir daí
        if (p1 < dimensao && p2 < dimensao && p3 < dimensao) {
            if ((carta0 + carta1 + carta2) % 3 == 0 && jogar(p1 + 1, p2 + 1, p3 + 1)) {
                return true;
            }
        }
        // Se não consegue mexer nada, o jogo acabou;
        return false;
    }

    public void lista() {
        for (int i = 0; i< this.dimensao; i++){
            System.out.println("Linha " + i + " ->  " + cartas[i][0] + " " + cartas[i][1] + " " + cartas[i][2]);
        }
    }
}