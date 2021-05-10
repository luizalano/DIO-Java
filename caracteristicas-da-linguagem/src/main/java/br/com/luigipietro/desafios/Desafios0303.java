package br.com.luigipietro.desafios;

import java.util.*;

public class Desafios0303 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        while(true){
            List<Aluno>alunos = new ArrayList<>();
            System.out.println("Quantos alunos?");
            Integer nOcorrencias = scan.nextInt();
            if (nOcorrencias == 0) break;

            for(int i=0; i < nOcorrencias; i++){
                System.out.println("O nome do aluno:");
                String nome = scan.next();
                System.out.println("Cor e tamanho:");
                String[] entrada = scan.next().split(" ");
                alunos.add(new Aluno(nome, entrada[0], entrada[1]));
            }
            for (Aluno aluno: alunos) {
                System.out.println(aluno);
            }
            Collections.sort(alunos);
            for (Aluno aluno: alunos) {
                System.out.println(aluno.getCor() + " "+ aluno.getTamanho() + " " + aluno.getNome());
            }
        }
    }
}

class Aluno implements Comparable<Aluno>{

    private String nome;
    private String cor;
    private String tamanho;

    public Aluno(String nome, String cor, String tamanho){
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", tamanho='" + tamanho + '\'' ;
    }

    @Override
    public int compareTo(Aluno outro) {
        if(!outro.getCor().equals(getCor()))
            return getCor().compareTo(outro.getCor());
        else if(!outro.getTamanho().equals(getTamanho()))
            return outro.getTamanho().compareTo(getTamanho());
        return getNome().compareTo(outro.getNome());
    }
}