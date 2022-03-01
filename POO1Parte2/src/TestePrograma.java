import java.util.Scanner;

public class TestePrograma {

    public static void main(String[] args){

        Ficha1 test = new Ficha1();
        Scanner ler = new Scanner(System.in);

        System.out.println("Temperatura para passar para Farenheit:");
        double tempC = ler.nextDouble();
        double tempF = test.celsiusParaFarenheit(tempC);
        System.out.println(tempC + "ºC equivale a " +tempF+ "ºF");

        System.out.println("Dois número inteiros:");
        System.out.println("O maior dos dois número é "+test.maximoNumeros(ler.nextInt(),ler.nextInt()));

        System.out.println("Um nome e um saldo:");
        System.out.println(test.criaDescricaoConta(ler.next(),ler.nextDouble()));

        System.out.println("Euros:");
        double euros = ler.nextDouble();
        System.out.println(euros+" Euros equivale a "+ test.eurosParaLibras(euros,2)+" Libras");

        test.lerIntMedia(ler);

        System.out.println("Número fatorial");
        System.out.println(test.factorial(ler.nextInt()));

        long tgasto = test.tempoGasto();
        System.out.println("Tempo que demora a fazer factorial de 5000: "+tgasto + ((tgasto == 1) ? " milisegundo" : " milisegundos"));
    }

}