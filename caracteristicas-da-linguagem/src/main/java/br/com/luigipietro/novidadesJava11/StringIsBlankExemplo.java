package br.com.luigipietro.novidadesJava11;

public class StringIsBlankExemplo {
    public static void main(String[] args) {
        String espaco = "                                                            ";
        System.out.println(espaco.isBlank());
        System.out.println((espaco.trim()==""));
    }
}
