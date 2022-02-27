
import java.util.Scanner;

public class Classificações {

    public static void main (String[] args){
        System.out.println("Número de classificações:");

        Scanner ler = new Scanner(System.in);
        int n = ler.nextInt();

        int cinco = 0, dez = 0, quinze = 0, vinte = 0;

        for (int i = 0; i<n; i++){
            float nota = ler.nextFloat();
            if (nota>=0 && nota<5) cinco++;
            else if (nota>=5 && nota<10) dez++;
            else if (nota>=10 && nota<15) quinze++;
            else if (nota>=15 && nota<=20) vinte++;
        }

        System.out.println("[0,5[: "+cinco+"\n[5,10[: "+dez+"\n[10,15[: "+quinze+"\n[15,20]: "+vinte+"");
    }


}