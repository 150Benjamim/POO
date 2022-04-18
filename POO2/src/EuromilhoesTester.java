import java.util.Arrays;
import java.util.Scanner;

public class EuromilhoesTester {


    public static void main(String[] args){

        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha cinco números entre 1 e 50!");

        int[] numeros  = new int[5];
        int[] estrelas = new int[2];

        for (int i = 0; i<5; i++){
            numeros[i] = ler.nextInt();
            if (numeros[i]<1 || numeros[i]>50){
                System.out.println("Apenas números entre 1 e 50 são permitidos.");
                i--;
            }
            else{
                for (int j = 0; j<i; j++){
                    if (numeros[j] == numeros[i]){
                        System.out.println("Não insira números repitidos.");
                        i--;
                    }
                }
            }
        }

        System.out.println("Escolha duas estrelas entre 1 e 9!");

        for (int i = 0; i<2; i++){
            estrelas[i] = ler.nextInt();
        }

        Euromilhoes chave = new Euromilhoes();

        System.out.println("Números chave: " +chave.printNumeros() + " Estrelas: " +chave.printEstrelas());

        int[] numCertos = chave.numCoin(numeros);
        int[] estrelasCertos = chave.numEstrelas(estrelas);

        if (numCertos.length == 5 && estrelasCertos.length == 2){
            for (int i = 0; i<50; i++){
                for (int j = 0; j<i; j++) System.out.print("  ");
                System.out.println(chave.printNumeros()+" "+chave.printEstrelas());
            }
        }
        else System.out.println(Arrays.toString(numCertos)+" "+Arrays.toString(estrelasCertos));

    }
}