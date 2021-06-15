package br.com.luigipietro.springwebmvc.repository;

import br.com.luigipietro.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

//    private List<Jedi> jedis;
//
//    public JediRepository() {
//        this.jedis = new ArrayList<>();
//        this.jedis.add(new Jedi("Luque", "iscaiuálquer"));
//        this.jedis.add(new Jedi("Lucao", "isficauálquer"));
//        this.jedis.add(new Jedi("Luquinho", "isobeuálquer"));
//        this.jedis.add(new Jedi("Lóque", "islevanteuálquer"));
//        this.jedis.add(new Jedi("Loco", "istrupicauálquer"));
//    }
//
//    public List<Jedi> findAll(){
//        return this.jedis;
//    }
//
//    public void add(Jedi jedi) {
//        this.jedis.add(jedi);
//    }
}
