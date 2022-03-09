import java.util.Arrays;
import java.util.Scanner;

public class TestarProgramaUm {


    public static void main(String[] args) {

        ExcUm teste = new ExcUm();
        Scanner ler = new Scanner(System.in);

        System.out.println("Quantos inteiros queres ler?");
        int n = ler.nextInt();

        if (n > 0) {
            int[] arrayUm = new int[n];
            for (int i = 0; i < n; i++) {
                arrayUm[i] = ler.nextInt();
            }
            System.out.println("O menor elemento do array é " + teste.minArray(arrayUm));
        }


        System.out.println("Quantos inteiros queres ler?");
        n = ler.nextInt();

        if (n > 0) {
            int[] arrayUm = new int[n];
            for (int i = 0; i < n; i++) {
                arrayUm[i] = ler.nextInt();
            }
            System.out.println("Primeiro índice:");
            int indUm = ler.nextInt();
            System.out.println("Segundo índice:");
            int indDois = ler.nextInt();
            System.out.println("Array: " + Arrays.toString(teste.newArray(arrayUm, indUm, indDois)) );
        }


        System.out.println("Quantos inteiros queres ler?");
        n = ler.nextInt();
        System.out.println("Quantos inteiros queres ler?");
        int nDois = ler.nextInt();
        if (n > 0 && nDois > 0) {
            int[] arrayUm = new int[n];
            System.out.println("Elementos do primeiro array");
            for (int i = 0; i < n; i++) {
                arrayUm[i] = ler.nextInt();
            }
            int[] arrayDois = new int[nDois];
            System.out.println("Elementos do segundo array");
            for (int i = 0; i < n; i++) {
                arrayDois[i] = ler.nextInt();
            }
            System.out.println("Array com elementos em comum: " + Arrays.toString(teste.commonArray(arrayUm, arrayDois)) );
        }

    }


}