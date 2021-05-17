package br.com.luigipietro.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryExecution {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();

        // =========================== 1 - Consulta =================================================
        List<Aluno> alunos = alunoDAO.list();

        alunos.stream().forEach(System.out::println);


        // ======================= 1.1 - Consulta com filtro ========================================
        Aluno alunoParaConsulta = alunoDAO.getById(1);

        System.out.println(alunoParaConsulta);


        // =========================== 2 - Inserção =================================================
        Aluno alunoParaInsercao = new Aluno("Matheus",43,"SP");
        alunoDAO.create(alunoParaInsercao);
        alunoParaInsercao = new Aluno("Xico",13,"CE");
        alunoDAO.create(alunoParaInsercao);
        alunoParaInsercao = new Aluno("Francisco",14,"CA");
        alunoDAO.create(alunoParaInsercao);
        alunoParaInsercao = new Aluno("Zézinho",143,"AC");
        alunoDAO.create(alunoParaInsercao);
        alunoParaInsercao = new Aluno("Zézão",21,"AC");
        alunoDAO.create(alunoParaInsercao);
        alunoParaInsercao = new Aluno("Pedrinho",22,"PR");
        alunoDAO.create(alunoParaInsercao);


        // =========================== 3 - Delete ===================================================
        alunoDAO.delete(1);


        // =========================== 4 - Atualizar ================================================
        Aluno alunoParaAtualizar = alunoDAO.getById(3);
        alunoParaAtualizar.setNome("Joaquim");
        alunoParaAtualizar.setIdade(18);
        alunoParaAtualizar.setEstado("RS");

        alunoDAO.update(alunoParaAtualizar);
    }
}
