package br.com.luigipietro.maps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class ExemploMapas {
    public static void main(String[] args) {
        exemploHashMap();
        //exemploTreeMap();
        //exemploHashTable();
    }

    private static void exemploHashTable() {
        Hashtable<String, Integer> copasDoMundo = new Hashtable<>();

        copasDoMundo.put("Brasil",5);
        copasDoMundo.put("Itália", 4);
        copasDoMundo.put("Argentina", 2);
        copasDoMundo.put("Uruguai", 2);
        copasDoMundo.put("Espanha", 1);
        copasDoMundo.put("França", 2);
        copasDoMundo.put("Alemanha", 4);
        copasDoMundo.put("Inglaterra", 1);
        copasDoMundo.putIfAbsent ("Inglaterra", 1);
        copasDoMundo.putIfAbsent("Afeganistão", 0);

        System.out.println("Este é o mapa: **************************");
        System.out.println(copasDoMundo);

        copasDoMundo.put("Brasil", 6);

        System.out.println("Argentina -> " + copasDoMundo.get("Argentina").toString());

        System.out.println("Tem França? -> " + copasDoMundo.containsKey("França"));
        System.out.println("Tem Portugal? -> " + copasDoMundo.containsKey("Portugal"));


        System.out.println("\nTem Quantos? -> " + copasDoMundo.size());
        copasDoMundo.forEach((key, value) -> {
            System.out.println("Chave: " + key + ", valor: " + value);
        });

        System.out.println("\nNagegação 2 ***********************");
        for (String key: copasDoMundo.keySet()){
            System.out.println("Chave: " + key + ", valor: " + copasDoMundo.get(key));
        }

        System.out.println("\nNagegação 3 ***********************");
        for (Map.Entry<String, Integer> entrada: copasDoMundo.entrySet()){
            System.out.println("Chave: " + entrada.getKey() + ", valor: " + entrada.getValue());
        }


    }

    public static void exemploHashMap(){
        Map<String, Integer> copasDoMundo = new HashMap<>();
        
        copasDoMundo.put("Brasil",5);
        copasDoMundo.put("Itália", 4);
        copasDoMundo.put("Argentina", 2);
        copasDoMundo.put("Uruguai", 2);
        copasDoMundo.put("Espanha", 1);
        copasDoMundo.put("França", 2);
        copasDoMundo.put("Alemanha", 4);
        copasDoMundo.put("Inglaterra", 1);
        copasDoMundo.putIfAbsent ("Inglaterra", 15);
        copasDoMundo.putIfAbsent("Afeganistão", 0);

        System.out.println(copasDoMundo.get(3));
        System.out.println("Este é o mapa: **************************");
        System.out.println(copasDoMundo);

        copasDoMundo.put("Brasil", 6);

        System.out.println("\nArgentina -> " + copasDoMundo.get("Argentina").toString());

        System.out.println("\nTem França? -> " + copasDoMundo.containsKey("França"));
        System.out.println("\nTem Portugal? -> " + copasDoMundo.containsKey("Portugal"));


        System.out.println("\nTem Quantos? -> " + copasDoMundo.size());
        copasDoMundo.forEach((key, value) -> {
            System.out.println("Chave: " + key + ", valor: " + value);
        });

        System.out.println("\nNagegação 2 ***********************");
        for (String key: copasDoMundo.keySet()){
            System.out.println("Chave: " + key + ", valor: " + copasDoMundo.get(key));
        }

        System.out.println("\nNagegação 3 ***********************");
        for (Map.Entry<String, Integer> entrada: copasDoMundo.entrySet()){
            System.out.println("Chave: " + entrada.getKey() + ", valor: " + entrada.getValue());
        }


    }

    public static void exemploTreeMap(){
        TreeMap<String, Integer> copasDoMundo = new TreeMap<>();

        copasDoMundo.put("Brasil",5);
        copasDoMundo.put("Itália", 4);
        copasDoMundo.put("Argentina", 2);
        copasDoMundo.put("Uruguai", 2);
        copasDoMundo.put("Espanha", 1);
        copasDoMundo.put("França", 2);
        copasDoMundo.put("Alemanha", 4);
        copasDoMundo.put("Inglaterra", 1);
        copasDoMundo.putIfAbsent ("Inglaterra", 1);
        copasDoMundo.putIfAbsent("Afeganistão", 0);

        System.out.println("Este é o mapa: **************************");
        System.out.println(copasDoMundo);

        copasDoMundo.put("Brasil", 6);

        System.out.println("\nPrimeiro -> " + copasDoMundo.firstKey());
        System.out.println("Primeiro -> " + copasDoMundo.firstEntry().getKey() + ", " + copasDoMundo.firstEntry().getValue());
        System.out.println("Último -> " + copasDoMundo.lastKey());
        System.out.println("Antes da Espanha -> " + copasDoMundo.lowerKey("Espanha"));
        System.out.println("Após a Espanha -> " + copasDoMundo.higherKey("Espanha"));

        System.out.println("Argentina -> " + copasDoMundo.get("Argentina").toString());

        System.out.println("Tem França? -> " + copasDoMundo.containsKey("França"));
        System.out.println("Tem Portugal? -> " + copasDoMundo.containsKey("Portugal"));


        System.out.println("\nTem Quantos? -> " + copasDoMundo.size());
        copasDoMundo.forEach((key, value) -> {
            System.out.println("Chave: " + key + ", valor: " + value);
        });

        System.out.println("\nNagegação 2 ***********************");
        for (String key: copasDoMundo.keySet()){
            System.out.println("Chave: " + key + ", valor: " + copasDoMundo.get(key));
        }

        System.out.println("\nNagegação 3 ***********************");
        for (Map.Entry<String, Integer> entrada: copasDoMundo.entrySet()){
            System.out.println("Chave: " + entrada.getKey() + ", valor: " + entrada.getValue());
        }


    }

}
