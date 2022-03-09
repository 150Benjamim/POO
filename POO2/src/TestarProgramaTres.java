import java.time.LocalDate;

public class TestarProgramaTres {


    public static void main(String[] args){


        ExcTres test = new ExcTres(10);

        LocalDate dataUm = LocalDate.of(2030,10,10);
        LocalDate dataDois = LocalDate.of(2050,10,10);
        LocalDate dataTres = LocalDate.of(2001,10,10);

        test.insere(dataUm);
        test.insere(dataDois);
        test.insere(dataTres);

        LocalDate testing = LocalDate.of(2002,10,10);

        LocalDate r = test.dataMaisProxima(testing);

        System.out.println(test);
    }


}