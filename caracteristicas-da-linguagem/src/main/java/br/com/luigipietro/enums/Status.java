package br.com.luigipietro.enums;

public enum Status {
    OPEN(13, "Aperto"),
    CLOSE(2, "Chiuso");

    private int cod;
    private String texto;

    Status(int cod, String texto) {
        this.cod = cod;
        this.texto = texto;
    }

    public int getCod() {
        return cod;
    }

    public String getTexto() {
        return texto;
    }
}
