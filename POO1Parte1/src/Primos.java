import java.util.Scanner;

public class Primos {


    public static boolean prime(int number){

        for (int i = 2; i<number; i++){
            if  (number % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args){

        Scanner ler = new Scanner(System.in);

        while(true){

            System.out.println("\nDo you want to play?");
            String check = ler.next();
            if (check.equals("Sim") == false) System.exit(0);

            System.out.println("Número:");
            int n = ler.nextInt();

            for (int i = 2; i<n; i++){
                if (prime(i)) System.out.print(i+" ");
            }

            System.out.println();
        }
    }


}