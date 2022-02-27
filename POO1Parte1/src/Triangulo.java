
import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

public class Triangulo {

    public static void main(String[] args) {


        Scanner ler = new Scanner(System.in);
        DecimalFormat format = new DecimalFormat("0.00000");

        while (true) {

            double base = ler.nextFloat();
            if (base == 0) return;
            double altura = ler.nextFloat();
            double area = base * altura / 2;
            double perimetro = base + altura + Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
            System.out.printf("Área: " + format.format(area) + "\nPerímetro: " + format.format(perimetro) + "\n");
        }
    }

}

