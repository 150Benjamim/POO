import java.util.Scanner;
import java.lang.Math;

public class Temperaturas {


    public static void main(String[] args){


        System.out.println("Número de temperaturas:");

        Scanner ler = new Scanner(System.in);

        int n = ler.nextInt();
        if (n<2) return;

        int temp1 = ler.nextInt(), temp2 = ler.nextInt(), dia1 = 1, dia2 = 2;
        float media = temp1 + temp2;
        float dif = temp2 - temp1;

        for (int i = 3; i<=n; i++){

            temp1 = ler.nextInt();
            media += temp1;

            if (Math.abs(temp1 - temp2) > Math.abs(dif) ) {
                dif = temp1-temp2;
                dia1 = i-1;
                dia2 = i;
            }

            temp2 = temp1;
        }

        media = media / n;

        System.out.println("A média das "+n+" temperaturas foi de "+media+" graus");
        System.out.println("A maior variação registou-se entre os dias "+dia1+" e "+dia2+", tendo a temperatura "
                + ( ( (dif > 0) ? "subido " : "descido ") +Math.abs(dif)+ " graus."));
    }



}