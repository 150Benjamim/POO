import java.util.Arrays;

public class TestarProgramaCinco {

    public static void main(String[] args){

        ExcCinco test = new ExcCinco();

        String[] lista = {"seila","eque","seila","teste1","teste2","teste3","teste2","CASADASDSADCASC"};

        System.out.println(Arrays.toString(test.arrayNoRepetitions(lista)));
        System.out.println(test.maiorString(lista));
        System.out.println(Arrays.toString(test.arrayRepetitions(lista)));
        System.out.println(test.quantasRepString(lista,"eque"));

    }
}
