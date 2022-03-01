import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.Duration;




public class Ficha1 {


    public double celsiusParaFarenheit(double graus){

        double temp = 1.8 * graus + 32;
        return temp;
    }


    public int maximoNumeros(int a, int b){
        if(a>=b) return a;
        else return b;
    }


    public String criaDescricaoConta(String nome, double saldo){

        return ("Nome: " +nome+ " Saldo: " +saldo+ "$");
    }


    public double eurosParaLibras(double valor, double taxaConversao){

        return valor * taxaConversao;
    }


    public void lerIntMedia(Scanner ler){

        System.out.println("Dois ints:");
        int x = ler.nextInt(), y = ler.nextInt();

        if (x<=y) System.out.println(y+", "+x+", Média:" +(x+y)/2);
        else System.out.println(x+", "+y+", Média:" +(x+y)/2);
    }


    public long factorial(int num){

        long r = num;

        for (num--; num > 0; num--){
            r *= num;
        }

        return r;
    }


    public long tempoGasto() {

        LocalDateTime primeiroS = LocalDateTime.now();
        factorial(5000);
        LocalDateTime segundoS = LocalDateTime.now();

        Duration r = Duration.between(primeiroS,segundoS);

        return (r.toMillis());
    }


}