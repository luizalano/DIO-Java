package br.com.luigipietro.Threads;

public class ThreadExemplo {
    public static void main(String[] args) {
        GeradorPDF iniciarGeradorPdf = new GeradorPDF(5000);
        GeradorPDF iniciarGeradorPdf2 = new GeradorPDF(8000);
        BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPdf, 500);
        BarraDeCarregamento iniciarBarraDeCarregamento2 = new BarraDeCarregamento(iniciarGeradorPdf2, 500);

        iniciarGeradorPdf.start();
        iniciarGeradorPdf2.start();
        iniciarBarraDeCarregamento.start();
        iniciarBarraDeCarregamento2.start();

        System.out.println("Por aqui acabou tudo!");
    }
}

class GeradorPDF extends Thread {

    private long tempo;

    public GeradorPDF (long tempo){
        this.tempo = tempo;
    }

    @Override
    public void run() {
        try {
            System.out.println("Iniciar geração de PDF");
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento extends Thread {
    private Thread iniciarGeradorPdf;
    private long tempo;

    public BarraDeCarregamento(Thread iniciarGeradorPdf, long tempo) {
        this.iniciarGeradorPdf = iniciarGeradorPdf;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(tempo);

                if (!iniciarGeradorPdf.isAlive()){
                    break;
                }
                System.out.println("A thread " + iniciarGeradorPdf.getName() + " continua rodando" + " e a Thread " + this.getName() + " diz: Loading ... ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
