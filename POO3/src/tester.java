import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;

public class tester {

    public static void main(String[] args){

        /*
        Telemovel test = new Telemovel();

        test.setArmOcupado((byte)0);
        test.setArmFotosAps((byte)100);
        test.setArmOcupado((byte)0);

        test.instalaApp("equemano",10);
        String[] t = test.getNomesAps();

        t[0] = "bro";

        System.out.println(test.toString());

        System.out.println(t[0] + "\n" + test.getArmFotosAps() + test.getArmOcupado() + test.getSavedAps()+test.getNomesAps().length);



        LocalDate teste = LocalDate.of(2022,3,22);
        LocalDate aux = teste;
        teste = teste.withDayOfMonth(30);

        System.out.println(teste.toString());
        System.out.println(aux.toString());

        int[] fds = new int[] {1,2,3,4};
        byte[] byteArray = { -1, -128, 1, 127 };

        System.out.println(Arrays.toString(byteArray));




        FootballGame teste = new FootballGame();
        teste.startGame();
        teste.endGame();
        String fds = "teste";
        System.out.println(fds);
        */

        LinhaEncomenda fds = new LinhaEncomenda("aa","bb",3,10,0,0);
        LinhaEncomenda fds1 = new LinhaEncomenda("ab","bb",3,10,0,0);
        LinhaEncomenda fds2 = new LinhaEncomenda("abc","bb",3,10,0,0);

        Encomenda teste = new Encomenda("aa","aa",123,123,LocalDate.now(),20);

        teste.adicionaLinha(fds);
        teste.adicionaLinha(fds);
        teste.adicionaLinha(fds);
        teste.adicionaLinha(fds);
        teste.adicionaLinha(fds1);
        teste.removeProduto("aa");

        System.out.println(teste.toString() + teste.existeProdutoEncomenda("abc") + teste.calculaValorTotal());

    }
}
