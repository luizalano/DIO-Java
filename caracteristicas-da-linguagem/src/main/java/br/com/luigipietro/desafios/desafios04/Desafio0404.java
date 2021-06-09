/*
Tesoura corta papel
Tesoura prende lagarto
Papel cobre pedra
Papel refuta Spock
Pedra derruba lagarto
Pedra quebra tesoura
Lagarto adormece Spock
Lagarto come papel
Spock derrete tesoura
Spock vaporiza pedra
 */

package br.com.luigipietro.desafios.desafios04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desafio0404 {
    public static void main(String[] args) throws IOException {
        String[][] matrizCombate = {{"tesoura","papel", "lagarto"},
                                    {"papel","pedra","spock"},
                                    {"pedra", "lagarto","tesoura"},
                                    {"lagarto","spock","papel"},
                                    {"spock","tesoura","pedra"}};
        int quantos;
        String entrada;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Entre com a quantidade de testes:");
        quantos = Integer.parseInt(br.readLine());
        while (quantos > 0){
            for(int casos = 0; casos < quantos; casos++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String fernanda = st.nextToken();
                String marcia = st.nextToken();
                String vencedora = "empate";

                // Verifica se fernanda ganha
                for (int i = 0; i < 5; i++) {
                    if (fernanda.equals(matrizCombate[i][0])) {
                        if (marcia.equals(matrizCombate[i][1]) || marcia.equals(matrizCombate[i][2])) {
                            vencedora = "fernanda";
                        }
                        break;
                    }
                }

                if (vencedora == "empate") {
                    // Verifica se Marcia ganha
                    for (int i = 0; i < 5; i++) {
                        if (marcia.equals(matrizCombate[i][0])) {
                            if (fernanda.equals(matrizCombate[i][1]) || fernanda.equals(matrizCombate[i][2])) {
                                vencedora = "marcia";
                            }
                            break;
                        }
                    }
                }

                System.out.println(vencedora);
            }
            System.out.println("Entre com a quantidade de testes:");
            if ((entrada = br.readLine()) == null) entrada="0";
            quantos = Integer.parseInt(entrada);
        }
    }
}
