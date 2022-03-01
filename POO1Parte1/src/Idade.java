import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Idade {

    public static void main(String[] args){

        Scanner ler = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy às HH:mm");

        System.out.println("Dia de Nascimento:");

        int diaN = ler.nextInt(), mêsN = ler.nextInt(), anoN = ler.nextInt();

        LocalDate dateN = LocalDate.of(anoN, diaN, mêsN);

        LocalDateTime currentD = LocalDateTime.now();

        long idadeHoras = (currentD.getYear() - dateN.getYear()) * (365*24 + 24/4) + (currentD.getDayOfYear() - dateN.getDayOfYear()) * 24 + currentD.getHour();


        System.out.println("Pessoa tem "+idadeHoras+" horas de idade na data " + formatter.format(currentD));
    }



}
