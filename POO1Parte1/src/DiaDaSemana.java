import java.time.LocalDate;
import java.util.Scanner;

public class DiaDaSemana {

    public static void weekDay(int dia, int mês, int ano){

        int x;
        LocalDate diaX = LocalDate.of(ano,mês,dia);
        int dayOfYear = diaX.getDayOfYear();

        x = (ano-1900)*365 + (ano-1899)/4;
        x += dayOfYear;
        x = x % 7;

        switch(x){
            case 0:
                System.out.println("Domingo");
                break;
            case 1:
                System.out.println("Segunda");
                break;
            case 2:
                System.out.println("Terça");
                break;
            case 3:
                System.out.println("Quarta");
                break;
            case 4:
                System.out.println("Quinta");
                break;
            case 5:
                System.out.println("Sexta");
                break;
            case 6:
                System.out.println("Sábado");
                break;
        }
    }


    public static void main (String[] args){

        Scanner ler = new Scanner(System.in);
        int dia = ler.nextInt(), mês = ler.nextInt(), ano = ler.nextInt();
        weekDay(dia,mês,ano);
    }

}