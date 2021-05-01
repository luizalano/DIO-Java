package br.com.luigipietro.testesVarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BricandoComDatas {
    public static void main(String[] args) {
        //datasAteJava8();
        datasNoJava8();
    }

    private static void datasAteJava8(){
        Date data1 = new Date();
        System.out.println(data1);

        espera((long) 1200);

        Date data2 = new Date(System.currentTimeMillis());
        System.out.println(data2);

        Instant instant = data1.toInstant();
        System.out.println(instant);

        //
        // Classe Calendar
        //
        System.out.println("\nCalendar ***********************\n");
        Calendar data3 = Calendar.getInstance();
        Calendar data4 = Calendar.getInstance();
        Calendar data5 = Calendar.getInstance();

        System.out.println(data3.getTime() + " na timezone: " + data3.getTimeZone().getID());

        data4.set(1966, 0,01);
        System.out.println(data4.getTime() + " na timezone: " + data4.getTimeZone().getID());

        //
        //  Classe DataFormat
        //
        String dataToStr1 = DateFormat.getInstance().format(data2);
        String dataToStr2 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(data2);
        String dataToStr3 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(data2);
        String dataToStr4 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG).format(data2);

        System.out.println("\nDateFormat ***********************\n");
        System.out.println(dataToStr1);
        System.out.println(dataToStr2);
        System.out.println(dataToStr3);
        System.out.println(dataToStr4);

        //
        //  Classe SimpleDateFormat
        //
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MMMM/yy");
        String dataToStr01 = formatador.format(data2);

        System.out.println("\nSimpleDateFormat ***********************\n");
        System.out.println(dataToStr01);
    }

    private static void datasNoJava8(){
        LocalDate data1 = LocalDate.now();
        LocalDate data2 = LocalDate.of(1966, 01, 01);
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data2);

    }

    private static void espera(long tempo){
        try {
            TimeUnit.MILLISECONDS.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

