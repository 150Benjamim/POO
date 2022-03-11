import java.lang.Math;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Euromilhoes {

    private int[] numeros;
    private int[] estrelas;

    public Euromilhoes() {

        numeros = new int[5];
        for (int i = 0; i < 5; i++) {
            numeros[i] = 1 + (int) (Math.random() * 50);
            for (int j = 0; j < i; j++) {
                if (numeros[j] == numeros[i]) {
                    while (numeros[j] == numeros[i]) numeros[i] = 1 + (int) (Math.random() * 50);
                }
            }
        }
        Arrays.sort(numeros);

        estrelas = new int[2];
        for (int i = 0; i < 2; i++) {
            estrelas[i] = 1 + (int) (Math.random() * 9);
            for (int j = 0; j < i; j++) {
                if (estrelas[j] == estrelas[i]) {
                    while (estrelas[j] == estrelas[i]) estrelas[i] = 1 + (int) (Math.random() * 9);
                }
            }
        }
        Arrays.sort(estrelas);
    }

    public String printNumeros(){
        return Arrays.toString(numeros);
    }
    public String printEstrelas(){
        return Arrays.toString(estrelas);
    }


    public int[] numCoin(int[] aposta){

        int[] aux = new int[5];
        int contador = 0;

        for (int i = 0; i<5; i++){
            if (Arrays.binarySearch(numeros,aposta[i])>=0){
                aux[contador] = aposta[i];
                contador++;
            }
        }

        int r[] = new int[contador];
        System.arraycopy(aux,0,r,0,contador);

        return r;
    }

    public int[] numEstrelas(int[] aposta){

        int[] aux = new int[2];
        int contador = 0;

        for (int i = 0; i<2; i++){
            if (Arrays.binarySearch(estrelas,aposta[i])>=0){
                aux[contador] = aposta[i];
                contador++;
            }
        }

        int r[] = new int[contador];
        System.arraycopy(aux,0,r,0,contador);

        return r;
    }


}
