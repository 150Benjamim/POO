
import java.time.LocalDate;
import java.util.Scanner;

public class DataSum {


    public static void main (String[] args){

        Scanner ler = new Scanner(System.in);
        int dia1 = ler.nextInt(), horas1 = ler.nextInt(), minutos1 = ler.nextInt(), segundos1 = ler.nextInt();
        int dia2 = ler.nextInt(), horas2 = ler.nextInt(), minutos2 = ler.nextInt(), segundos2 = ler.nextInt();

        int segR = segundos1 + segundos2;
        int minutosR = minutos1 + minutos2 + (segR / 60);
        int horasR = horas1 + horas2 + (minutosR / 60);
        int diasR = dia1 + dia2 + (horasR / 24);

        segR = segR % 60;
        minutosR = minutosR % 60;
        horasR = horasR % 24;

        System.out.println(""+diasR+"D "+horasR+"H "+minutosR+"M "+segR+"S");
    }


}