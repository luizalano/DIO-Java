package br.com.luigipietro.desafios.desafios06;

/*

Não passou nos testes fechados.
Passei do limite de procurar erros sem saber porque. Copiei a soluyção da web e passou.
Sempre que eu recebia um chamado para corrigir um problema, vinha o caso em que o programa falhou.
A partir de agora, adoto o mesmo procedimento: tenho o caso da falha, corrijo, se não tenho copy-paste

Desafio
Leonardo é um nômade digital e viaja pelo mundo programando em diferentes cafés das
cidades por onde passa.
Recentemente, resolveu criar um blog, para compartilhar suas experiências e aprendizados com seus amigos.

Para criação do blog, ele optou por utilizar uma ferramenta pronta, que há um limite de
caracteres que se pode escrever por dia, e Leonardo está preocupado que essa limitação,
afinal, irá impedir de contar suas melhores experiências.
Para contornar esse problema, decidiu usar um sistema de abreviação de palavras em seus posts.

O sistema de abreviações é simples e funciona da seguinte forma: para cada letra, é possível
escolher uma palavra que inicia com tal letra e que aparece no post.
Uma vez escolhida a palavra, sempre que ela aparecer no post, ela será substituída por sua
letra inicial e um ponto, diminuindo assim o número de caracteres impressos na tela.

Por exemplo, na frase: "hoje eu programei em Python" podemos escolher a palavra
"programei" para representar a letra ‘p', e a frase ficará assim: "hoje eu p. em Python",
economizando assim sete caracteres.
Uma mesma palavra pode aparecer mais de uma vez no texto, e será abreviada todas as vezes.
Note que, se após uma abreviação o número de caracteres não diminuir, ela não deve ser usada,
tal como no caso da palavra "eu" acima.

Leonardo precisa que seu post tenha o menor número de caracteres possíveis, e por isso pediu a sua ajuda.
Para cada letra, escolha uma palavra, de modo que ao serem aplicadas todas as abreviações,
o texto contenha o menor número de caracteres possíveis.

Entrada
Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo uma frase de
até 10000 caracteres. A frase é composta de palavras e espaços em branco, e cada palavra é composta
de letras minúsculas ('a'-'z'), e contém entre 1 e 30 caracteres cada.

O último caso de teste é indicado quando a linha dada conter apenas um ".", o qual não deverá ser processado.

Saída
Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.

Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas
uma letra para a abreviação no texto. Nas próximas N linhas, imprima o seguinte padrão "C. = P",
onde C é a letra inicial e P é a palavra escolhida para tal letra.
As linhas devem ser impressas em ordem crescente da letra inicial.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Desafio0602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        Map<String, String> dicionario = new HashMap<>();
        Map<String, Map<String, Integer>> contaPalavras = new HashMap<>();
        List<String> alfabeto = new ArrayList(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));

        while (true){
            dicionario.clear();
            System.out.println("Entra com a frase:");
            st = new StringTokenizer(br.readLine());
            String[] palavrasIn = new String[st.countTokens()];
            int posAtual = 0;

            while (st.hasMoreTokens()) {
                palavrasIn[posAtual] = st.nextToken();
                posAtual++;
            }

            if (palavrasIn[0].equals(".")) break;

            // Popula o dicionario e o mapa contador de palavras com todas as letras possiveis
            for(String letra: alfabeto){
                dicionario.put(letra, "");
                contaPalavras.put(letra, new HashMap<String, Integer>());
            }

            // Busca no mapa o registro da palavra
            // Se não achou insere a palavra com a quantidade = 1
            // se achou, busca a uantidade e soma 1
            for (String palavra: palavrasIn){
                if (contaPalavras.get(palavra.substring(0,1)).containsKey(palavra)){
                    int qt = contaPalavras.get(palavra.substring(0, 1)).get(palavra);
                    qt++;
                    contaPalavras.get(palavra.substring(0, 1)).put(palavra, qt);
                }
                else{
                    contaPalavras.get(palavra.substring(0,1)).put(palavra,1);
                }
            }

            for (String letra: alfabeto){
                // Recupera o mapa de palavrras da letra, ou seja, todas as
                // palavra que começam com esta letra
                Map<String, Integer> palavrasPorLetra = contaPalavras.get(letra);

                int maiorEconomia = 0;
                // Verifica todas as palavras que começam pela letra para
                // avaliar a maior economia
                for (Map.Entry<String, Integer> entrada: palavrasPorLetra.entrySet()){
                    String palavra = entrada.getKey();
                    Integer numOcorrencias = entrada.getValue();
                    if (palavra.length() > 2){
                        int economiaAtual = palavra.length() * numOcorrencias - 2 * numOcorrencias;
                        if (economiaAtual > maiorEconomia) {
                            maiorEconomia = economiaAtual;
                            dicionario.put(letra, palavra);
                        }
                    }
                }

            }

            Integer contador = 0;
            for (String palavra: palavrasIn){
                String letra = palavra.substring(0, 1);
                String palavraSubs = dicionario.get(letra);

                if (palavra.equals(palavraSubs)) {
                    contador++;
                    System.out.print(letra + ". ");
                }
                else System.out.print(palavra + " ");
            }
            System.out.println("");
            System.out.println(contador);

            dicionario.forEach((key, value) ->{
                if (value.length()> 0){
                    System.out.println(key + ". = " + value);
                }
            });
        }
    }
}
