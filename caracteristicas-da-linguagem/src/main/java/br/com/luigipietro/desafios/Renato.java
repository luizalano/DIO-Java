package br.com.luigipietro.desafios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collections;

public class Renato {

    int k = 0;
    static int finalizar = 1;
    int inicio_Contagem = 0;
    int pontos_Primeiro = 0;
    int contagem_Pontos = 0;
    int p = 0;
    int f = 0;
    int d = 0;

    String aluno = null;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner ler = new Scanner(System.in);
        ArrayList<String> nome_Aluno = new ArrayList<String>();
        ArrayList<String> vencedor = new ArrayList<String>();
        ArrayList<Integer> pontuacao = new ArrayList<Integer>();

        int quant_Alunos = 0;
        int j = 0;
        int f = 0;
        int inicio_Contagem = 0;
        int pontos_Primeiro = 0;
        int d = 0;
        int k = 0;
        int i = 0;
        int num_Voltas = 0;
        int resto = 0;
        int total_Alunos = 0;
        int posicao = 0;
        int pontuacao_Sai = 0;
        int y = 0;
        int valor_Pontuacao = 0;

        String aluno_Sai = null;
        String aluno_Novo = null;
        String aluno_Vencedor = null;
        String novo_aluno;
        String novo_aluno2;
        String pontos;
        String[] output = null;

        int u = 0;

        do{
            System.out.print("Digite a quantidade de alunos no círculo:");
            StringTokenizer st = new StringTokenizer(br.readLine());
            quant_Alunos = Integer.parseInt(st.nextToken());

            if(quant_Alunos == 0) {
                finalizar = 0;

                for(String venc : vencedor) {
                    output = venc.split(" ");
                    System.out.println("Vencedor(a): " +output[0]);
               }
            } else {
//Cadastro dos alunos
                while(j<quant_Alunos) {
//StringTokenizer st1 = new StringTokenizer(br.readLine());
                    do {
                        System.out.print("Digite o nome do aluno:");
                        novo_aluno = ler.nextLine();
//novo_aluno = novo_aluno.replaceAll("( )+", "_");
                        novo_aluno = Normalizer.normalize(novo_aluno, Normalizer.Form.NFD);
                        novo_aluno = novo_aluno.trim().replaceAll("[^\\p{ASCII}]", " ");
                    }while(novo_aluno.length() > 30 || novo_aluno.length() == 0);

                    nome_Aluno.add(novo_aluno);
                    output = novo_aluno.split(" ");
//System.out.println(output[1]);
                    pontuacao.add(Integer.parseInt(output[1]));
                    //System.out.println(nome_Aluno);
                    do {
//System.out.print("Digite a pontuação do aluno:");
//StringTokenizer st2 = new StringTokenizer(br.readLine());
//pontuacao.add(Integer.parseInt(st2.nextToken()));
                        valor_Pontuacao = pontuacao.get(j);
//pontos = String.valueOf(pontuacao.get(j));
//nome_Aluno.add(j, " ");
//nome_Aluno.add(j, pontos);
//System.out.println(nome_Aluno);
//System.out.println("O valor dos pontos é: " +valor_Pontuacao);
                        if(valor_Pontuacao < 1 || valor_Pontuacao >100) {
                            pontuacao.remove(j);
                        }
                    }while(valor_Pontuacao < 1 || valor_Pontuacao >100);
                    j++;
                }
//inicio_Contagem = pontuacao.get(nome_Aluno.size()-1);
//System.out.println("O início da contagem é: " +inicio_Contagem);
                total_Alunos = nome_Aluno.size();
//System.out.println("O total de alunos é: " +total_Alunos);
                pontos_Primeiro = pontuacao.get(0);
//System.out.println("Os pontos do primeiro aluno é: " +pontos_Primeiro);
                y = nome_Aluno.size()-1;

                while(total_Alunos != 1){
//System.out.println("O valor de y é : " +y);
// System.out.println("Aluno que sai é : " +aluno_Sai);
                    if(y>=0) {
                        aluno_Sai = nome_Aluno.get(y);
                        pontos_Primeiro = pontuacao.get(y);
                        nome_Aluno.remove(y);
                        pontuacao.remove(y);
                    }
                    total_Alunos = nome_Aluno.size();
//System.out.println("O valor do resto é: " +resto);
//System.out.println("O valor da variável pontos_Primeiroo é: " +pontos_Primeiro);
                    if(pontos_Primeiro%2==0) {
                        if(nome_Aluno.size()-1!=0 && resto > 1) {
                            y++;
                        }
                    }
                    if(pontos_Primeiro%2==1) {
                        if(nome_Aluno.size()-1!=0 && resto > 1) {
                            y--;
                        }
                    }
                    if(pontos_Primeiro < total_Alunos) {
                        resto = pontos_Primeiro;
                    }else {
                        resto = pontos_Primeiro%total_Alunos;
                    }
                    y = resto;
                }
//System.out.println("Vencedor(a):" +nome_Aluno.get(y));
                vencedor.add(nome_Aluno.get(y));
                nome_Aluno.clear();
                pontuacao.clear();
                j = 0;
            }
        }while(finalizar != 0);
    }
}