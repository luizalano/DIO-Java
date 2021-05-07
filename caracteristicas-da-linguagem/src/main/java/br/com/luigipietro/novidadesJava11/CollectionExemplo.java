package br.com.luigipietro.novidadesJava11;

import java.util.*;

public class CollectionExemplo {

    public static void main(String[] args) {
        Collection<String> nomes = Set.of("Joao", "Paulo", "Oliveira", "Santos");
        Map<String, String> argumentos = new HashMap<>();

        System.out.println(nomes);
        funcaoTeste(Set.of("Chave1:valor1","Chave2:valor1","Chave3:valor3","nome:Alano","telefone:41 99997-0486"));

        argumentos.put("nome","Alano");
        argumentos.put("telefone", "41 99997-0486");
        argumentos.put("pais","Brasil");
        passandoMap(argumentos);
    }

    public static void passandoMap(Map mapa){
        System.out.println("O nome do vivente é: " + mapa.get("nome"));
        System.out.println("Ele veio do país: " + mapa.get("pais"));
        System.out.println("O nome da mãe é: " + mapa.get("mae"));
        System.out.println("Tem nome? " + mapa.containsKey("nome"));
        System.out.println("Tem mãe? " + mapa.containsKey("mae"));
    }
    public static void funcaoTeste( Collection<String> entrada){
        entrada.forEach(par -> {
            String[] cv = par.split(":");
            System.out.println(cv[0] + " : " + cv[1]);
        });

    }

}