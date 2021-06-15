package br.com.luigipietro.springwebmvc.rest;

import br.com.luigipietro.springwebmvc.exception.JediNotFoundException;
import br.com.luigipietro.springwebmvc.model.Jedi;
import br.com.luigipietro.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediRepository jediRepository;

    @PostMapping("/create")
    public void createDb(){
        Jedi jedi = new Jedi();
        jedi.setName("Nome do jedi");
        jedi.setLastName("Congnome");
        jediRepository.save(jedi);
    }

    @PostMapping("/api/createjedi")
    public Jedi createJedi(@Valid @RequestBody Jedi jedi){

        return jediRepository.save(jedi);
    }

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){
        return jediRepository.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity <Jedi> getJedi(@PathVariable("id") Long id, HttpResponse response) {
        final Optional<Jedi> jedi = jediRepository.findById(id);

        if (jedi.isPresent()){
            return ResponseEntity.ok(jedi.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
