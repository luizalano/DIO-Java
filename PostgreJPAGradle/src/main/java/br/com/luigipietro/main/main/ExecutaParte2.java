package br.com.luigipietro.main.main;

import br.com.luigipietro.main.business.Aluno;
import br.com.luigipietro.main.business.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ExecutaParte2 {
    public static void main(String[] args) {

        // OBS: Esse codigo deve executar SEM ERROS com a implementacao JPA que foi definida no "persistence.xml".
        // Se estiver somente com o JPA baixado, o codigo NAO IRA funcionar.

        // O ideal é que nessa parte (Parte 2) o codigo EXECUTE SEM ERROS, pois aqui tera uma implementacao JPA sendo utilizada.

        // 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
        //Estado estadoParaAdicionar = new Estado("Paranáuê", "PR");
        //Aluno alunoParaAdicionar = new Aluno("Daniel Bacaxi", 29, estadoParaAdicionar, "M");
        Aluno alunoParaAdicionar = new Aluno("Paula Goiabinhaa", 25, entityManager.find(Estado.class, 9), "F");
        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
        entityManager.getTransaction().begin();

        //entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);

//        estadoParaAdicionar = new Estado("Paraná", "PR");
//        alunoParaAdicionar = new Aluno("Alano", 55, estadoParaAdicionar);
//
//        entityManager.persist(alunoParaAdicionar);

        entityManager.getTransaction().commit();

        // 3 - Resgatar instâncias no banco de dados
        //Estado estadoEncontrado = entityManager.find(Estado.class, 10);
        //Aluno alunoEncontrado = entityManager.find(Aluno.class, 16);

        //System.out.println(estadoEncontrado);
        //System.out.println(alunoEncontrado);

        // 4 - Alterar uma entidade
        //entityManager.getTransaction().begin();

        //estadoEncontrado.setNome("Espirito Çanto");
        //alunoEncontrado.setNome("Karaum");
        //alunoEncontrado.setIdade(25);

        //entityManager.getTransaction().commit();

        // 5 - Remover uma entidade
//        entityManager.getTransaction().begin();
//
//        entityManager.remove(alunoEncontrado);
//
//        entityManager.getTransaction().commit();

        // 6 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();

    }

    public static void mostraOnde(int i){
        System.out.println("Tô no ponto " + i);
        Scanner scan = new Scanner(System.in);
        String ok = scan.next();

    }

}
