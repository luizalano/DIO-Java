/*
Desafio
Pedro e Fernando são os desenvolvedores em uma stratup e vão desenvolver o novo sistema de cadastro,
e pediram a sua ajuda. Sua task é fazer o código que valide as senhas que são cadastradas,
para isso você deve atentar aos requisitos a seguir:

A senha deve conter, no mínimo, uma letra maiúscula, uma letra minúscula e um número;
A mesma não pode ter nenhum caractere de pontuação, acentuação ou espaço;
Além disso, a senha pode ter de 6 a 32 caracteres.

Entrada
A entrada contém vários casos de teste e termina com final de arquivo.
Cada linha tem uma string S, correspondente a senha que é inserida pelo
usuário no momento do cadastro.

Saída
A saída contém uma linha, que pode ser Senha valida.,
caso a senha tenha cada item dos requisitos solicitados anteriormente,
ou Senha invalida., se um ou mais requisitos não forem atendidos.
 */
package br.com.luigipietro.desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Desafio0403 {
    static int TAMMIN = 6;
    static int TAMMAX = 32;
    static String PERMITIDO = "1234567890abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String senha;
        System.out.println("Entre com a senha:");
        if ((senha = br.readLine()) == null) senha="";
        while (senha.length() > 0){
            String resultado = "Senha valida.";

            if (senha.length() < TAMMIN || senha.length() > TAMMAX) resultado = "Senha invalida.";
            else {
                String senhaUpper = senha.toUpperCase();
                String senhaLower = senha.toLowerCase();
                // Se for igual, então faltou letra minúscula
                if (senhaUpper.equals(senha)) resultado = "Senha invalida.";
                else {
                    // Se for igual, então faltou letra maiúscula
                    if (senhaLower.equals(senha)) resultado = "Senha invalida.";
                    else {
                        // Verifica se tem algum número
                        boolean temNumero = false;
                        for (int i = 0; i < 10; i++){
                            if (senha.contains(Integer.toString(i))) {
                                temNumero = true;
                                break;
                            }
                        }
                        if (!temNumero) resultado = "Senha invalida.";
                        else {
                            boolean temInvalido = false;
                            for (int i=0; i < senha.length(); i++){
                                if (!PERMITIDO.contains(senha.substring(i, i+1).toLowerCase())) {
                                    temInvalido = true;
                                    break;
                                }
                            }
                            if (temInvalido) resultado = "Senha invalida.";
                        }
                    }
                }

            }
            System.out.println(resultado);
            System.out.println("Entre com a senha:");
            if ((senha = br.readLine()) == null) senha="";
        }
    }
}
