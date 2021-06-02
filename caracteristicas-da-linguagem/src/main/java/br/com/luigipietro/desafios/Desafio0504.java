package br.com.luigipietro.desafios;
/*
Desafio
A nutricionista Juliana Alcantra é uma excelente profissional de sua área.
Em determinado dia, ela foi entrevistada ao vivo para um jornal da cidade.
No entanto, ficou um pouco nervosa na hora, e diante da situação, sua fala
ficou um pouco distorcida, repetindo o final de cada palavra após dizer a mesma.
Para que isso não aconteça novamente, ela precisa da sua ajuda para escrever um
programa que omita a parte repetida, de modo que as palavras sejam pronunciadas como deveriam ser.

Escreva um programa que, dada uma palavra errada, a mesma seja corrigida.

Entrada
Haverá diversos casos de teste. Cada caso de teste é formado por uma palavra, de,
no máximo, 30 caracteres, dita da forma errada. A entrada termina com fim de arquivo.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Desafio0504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Entre sua palavra de gagueira:");
        StringTokenizer entrada = new StringTokenizer(br.readLine());
        while (entrada.hasMoreTokens()){
            String palavraIn = entrada.nextToken();
            if (palavraIn.length() > 30) palavraIn = palavraIn.substring(0, 30);

            String palavraOut = palavraIn;
            String letra = palavraIn.substring(0,1);
            String auxiliar = palavraIn.replaceAll(letra, "");
            if (auxiliar.length() > 0) {
                int tamanho = palavraIn.length();
                int pos, tamPedaco, comeco, fim;

                if (tamanho > 1) {
                    int i = 1;
                    //int metade = ((int) tamanho / 2) + tamanho % 2;
                    int metade = (int) tamanho / 2;
                    boolean repete = false;
                    while (i <= metade) {
                        String pedaco0, pedaco1, pedaco2;

//                        tamPedaco = tamanho - i + 1;
//                        comeco = i - 1;
//                        fim = comeco + tamPedaco;
//                        pedaco1 = palavraIn.substring(comeco, fim);
//                        pedaco2 = palavraIn.substring(comeco - tamPedaco, fim - tamPedaco);

                        //if (pedaco1.equals(pedaco2)) palavraOut = palavraIn.substring(0, comeco);
                        //i--;

                        pedaco0 = palavraIn.substring(0, palavraIn.length() - 2 * i);
                        pedaco1 = palavraIn.substring(palavraIn.length() - 2 * i, palavraIn.length() - i);
                        pedaco2 = palavraIn.substring(palavraIn.length() - i, palavraIn.length());

                        if (pedaco1.equals(pedaco2)) {
                            palavraOut = pedaco0 + pedaco1;
                            //saida.add(palavraCorrigida);
                            repete = true;
                        }
                        i++;
                    }

                    if (palavraOut.isEmpty() || palavraOut.isBlank()) palavraOut = palavraIn;
                }
            }
            System.out.println(palavraOut);
            System.out.println("Entre sua palavra de gagueira:");
            entrada = new StringTokenizer(br.readLine());
        }
    }
}
