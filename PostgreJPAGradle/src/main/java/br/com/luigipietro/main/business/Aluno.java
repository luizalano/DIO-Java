package br.com.luigipietro.main.business;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column(name = "colunasexo", nullable = false, columnDefinition = "char default 'M'")
    private String sexo;

    @Column
    private int idade;

    @ManyToOne(fetch = FetchType.EAGER)
    private Estado estado;

    public Aluno(int id, String nome, int idade, Estado estado, String sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
        this.sexo = sexo;
    }

    public Aluno(int id, String nome, int idade, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
        this.sexo = "M";
    }

    public Aluno(String nome, int idade, Estado estado, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
        this.sexo = sexo;
    }

    public Aluno(String nome, int idade, Estado estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
        this.sexo = "M";
    }
    public Aluno() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Aluno{id=" + getId() + ", " +
                "nome='" + getNome() + "', " +
                "sexo = '" + getSexo() + "', " +
                "idade = " + getIdade() + ", " +
                "estado = {'" + estado.getNome() + "', " +
                "' " + estado.getSigla() + "'} }";
                //"estado = '" + getEstado().getNome() + "'}";
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
