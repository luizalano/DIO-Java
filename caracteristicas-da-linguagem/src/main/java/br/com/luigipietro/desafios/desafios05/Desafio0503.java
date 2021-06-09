package br.com.luigipietro.desafios.desafios05;
/*
Desafio
Final de ano ocorre uma festa na escola.
As inscrições para participar da festa são abertas no início de julho.
No momento da inscrição, o aluno pode escolher se quer ser "O Amigo do Pablo" na festa ou não.
O mais lógico seria escolher a opção Sim, afinal, é um privilégio ser O Amigo do Pablo,
já que ele é a pessoa mais descolada da escola.
Porém, há indivíduos que definitivamente não pretendem ser O Amigo do Pablo, e por motivos desconhecidos.

Somente um será o escolhido.
Em vista disso, muitos alunos que escolheram a opção Sim realizaram a inscrição diversas
vezes para aumentar a própria probabilidade de ser O Amigo do Pablo.
A diretora da escola pediu que você desenvolva um programa que organize as inscrições do site,
pois está havendo um spam de inscrições.
O critério para ser o escolhido é a quantidade de letras do primeiro nome, e em caso de empate,
vence aquele que realizou primeiro a inscrição.
A organização final dos inscritos deverá seguir a ordem de escolha (Sim ou Não),
mas respeitando a ordem alfabética.

OBS.: Ninguém que escolheu a opção Não realizou a inscrição mais de uma vez.

Entrada
A entrada contém somente um caso de teste.
Cada linha é composta pelo primeiro nome do participante (sem espaços),
seguido da opção SIM (caso o usuário queira ser O Amigo do Pablo) ou NAO (caso não queira).
A entrada termina assim que o usuário digita "FIM" (sem as aspas).

Saída
Seu programa deverá imprimir os inscritos pela ordem de escolha e por ordem alfabética,
seguido do nome do vencedor.
Imprima uma linha em branco entre a lista de inscritos e o nome do vencedor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Desafio0503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<AlunoAmigo> listao = new ArrayList<>();
        List<String> jaFoi = new ArrayList<>();

        System.out.println("Pessoa e opção:");
        StringTokenizer st = new StringTokenizer(br.readLine());

        String nome = st.nextToken();
        Integer ordem = 0;
        while (!nome.toUpperCase().equals("FIM")){
            String opcao = st.nextToken();

            if (!jaFoi.contains(nome)) {
                ordem++;
                listao.add(new AlunoAmigo(nome, ordem, opcao.toUpperCase()));
                jaFoi.add(nome);
            }

            System.out.println("Pessoa e opção:");
            st = new StringTokenizer(br.readLine());
            nome = st.nextToken();
        }

        Collections.sort(listao);

        listao.forEach(aluno -> System.out.println(aluno));

        AlunoAmigo vencedor = listao.get(0);


        listao.sort((primeiro, segundo) -> {
            Integer diferenca = segundo.getOpcao().compareTo(primeiro.getOpcao());
            if (diferenca == 0) {
                diferenca = primeiro.getNome().compareTo(segundo.getNome());
            }
            return diferenca;
        });

        listao.forEach(aluno -> System.out.println(aluno.getNome()));
        System.out.println("\nAmigo do Pablo:\n" + vencedor.getNome());
    }
}

class AlunoAmigo implements Comparable<AlunoAmigo>{
    String nome;
    Integer tamanho;
    Integer ordem;
    String opcao;

    public AlunoAmigo(String nome, Integer ordem, String opcao) {
        this.nome = nome;
        this.tamanho = nome.length();
        this.ordem = ordem;
        this.opcao = opcao;
    }

    @Override
    public String toString() {
        return ordem + " - " + nome + " - " + tamanho + " - " + opcao;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public String getOpcao() {
        return opcao;
    }

    @Override
    public int compareTo(AlunoAmigo o) {
        Integer difOpcao = o.opcao.compareTo(this.opcao);
        if (difOpcao == 0) {
            Integer difTamanho = o.tamanho - this.tamanho;

            if (difTamanho == 0) return this.ordem - o.ordem;
            return difTamanho;
        }
        else return difOpcao;
    }
}