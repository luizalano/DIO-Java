package br.com.luigipietro.desafios;

import java.util.Locale;
import java.util.Scanner;

public class Aceleracao01 {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("en", "US"));

        Scanner sc = new Scanner(System.in).useDelimiter(".|-");

        String[] cpf = new String[4];

        //continue a solucao

        System.out.println("CPF:");
        //cpf = sc.nextLine().split("-\\s*|\\.\\s*");
        cpf = sc.nextLine().split("-|\\.");

        System.out.println(cpf.toString());

        for(String peda: cpf){
            System.out.printf("%s\n",peda);
        }


        //System.out.printf("%s\n",cpf[i]);

        sc.close();
    }

}
