package br.com.luigipietro.springwebmvc.controller;

import br.com.luigipietro.springwebmvc.model.Jedi;
import br.com.luigipietro.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class JediController {

    @Autowired
    private JediRepository jediRepository;

    @GetMapping("/jedi")
    public ModelAndView jedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");   // Atribui o jedi.html para o model

        modelAndView.addObject("allJedi", jediRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi,
                             BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            return "new-jedi";
        }

        jediRepository.save(jedi);

        redirectAttributes.addFlashAttribute("message", "Jedi cadastrado.");

        // Adiciona um objeto na lista e redireciona a saída para
        //o jedi.html
        return "redirect:jedi";
    }

    @GetMapping("new-jedi")
    public ModelAndView newJedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");   // Atribui o new-jedi.html para o model

        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }
}
