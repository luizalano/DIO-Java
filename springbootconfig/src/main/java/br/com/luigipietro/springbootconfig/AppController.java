package br.com.luigipietro.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")
    private String appMessage;

    @Value("${HOMEPATH:caminho inexistente}")
    private String hpVariavelDeAmbiente;

    @GetMapping("/")
    public String getAppMessage(){
        return appMessage;
    }

    @GetMapping("/varambiente")
    public String gethpVariavelDeAmbiente(){
        return "A variavel HOMEPATH do ambiente: " + hpVariavelDeAmbiente;
    }
}
