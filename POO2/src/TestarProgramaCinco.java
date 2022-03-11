import java.util.Arrays;
import java.util.Scanner;

public class TestarProgramaCinco {

    public static void main(String[] args){

        ExcCinco test = new ExcCinco();
        Scanner ler = new Scanner(System.in);

        System.out.println("Quantos elementos tem o array de strings?");
        int n = ler.nextInt();
        String[] lista = new String[n];
        for (int i = 0; i<n; i++){
            lista[i] = ler.next();
        }

        System.out.println(Arrays.toString(test.arrayNoRepetitions(lista)));
        System.out.println(test.maiorString(lista));
        System.out.println(Arrays.toString(test.arrayRepetitions(lista)));
        System.out.println("Escolha uma string para verificar quantas vezes esta ocorre no array.");
        String check = ler.next();
        System.out.println(test.quantasRepString(lista,check));

    }
}
