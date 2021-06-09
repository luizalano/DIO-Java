package br.com.luigipietro.desafios.desafios03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio0305 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        List<Jogador> jogadores = new ArrayList<>();

        while (true){
            jogadores.clear();
            int carta;
            System.out.println("Quantos jogadores?");
            var numJogadores = scan.nextInt();
            if (numJogadores == 0) break;

            for (int i=0; i< numJogadores; i++) {
                System.out.println("Nome e pontuação:");
                String[] entrada = scan.next().split(" ");
                jogadores.add(new Jogador(entrada[0], Integer.parseInt(entrada[1])));
            }
            var jogadorCorrente = 0;
            carta = jogadores.get(jogadorCorrente).getNumero();
            do {
                int resto = carta % jogadores.size();
                int caiuEm = 0;

                if (carta % 2 != 0){
                    caiuEm = jogadorCorrente + resto;
                    if (caiuEm >= jogadores.size()) {
                        caiuEm = caiuEm - jogadores.size();
                    }
                }
                else {
                    caiuEm = jogadorCorrente - resto;
                    if (caiuEm < 0) {
                        caiuEm = caiuEm + jogadores.size();
                    }
                }

                carta = jogadores.get(caiuEm).getNumero();
                jogadores.remove(caiuEm);
                /*
                Se eu removo o jogador da lista, o corrente, quando no sentido crescente
                deve ser um a menos
                 */
                if (carta % 2 !=0) jogadorCorrente = caiuEm - 1;
                else jogadorCorrente = caiuEm;

                if (jogadorCorrente < 0) jogadorCorrente = jogadores.size() - 1;
                if (jogadorCorrente >= jogadores.size()) jogadorCorrente = 0;

            } while (jogadores.size() > 1);

            System.out.println("Vencedor(a): " + jogadores.get(0).getNome());
        }
    }
}

class Jogador {
    private String nome;
    private Integer numero;

    Jogador(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }
}
