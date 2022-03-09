import java.util.HashSet;
import java.util.Set;

public class ExcUm {

    public int minArray(int[] lista){

        int min = lista[0];

        for (int i = 1; i<lista.length; i++){
            if (lista[i] < min) min = lista[i];
        }

        return min;
    }


    public int[] newArray(int[] lista, int indI, int indF){

        int size = indF - indI + 1;
        int[] r = new int [size];
        int aux = 0;

        for (int i = indI; i<=indF; i++){
            r[aux] = lista[i];
            aux ++;
        }

        return r;
    }


    public int[] commonArray(int[] listaUm, int[] listaDois){

        int size;
        if (listaUm.length >= listaDois.length) size = listaUm.length;
        else size = listaDois.length;

        int[] r = new int[size];
        Set<Integer> firstSet = new HashSet<Integer>();
        int aux = 0;

        for (int i = 0; i<listaUm.length; i++){
            firstSet.add(listaUm[i]);
        }

        for (int i = 0; i<listaDois.length; i++){
            if (firstSet.contains(listaDois[i])){
                r[aux] = listaDois[i];
                aux++;
            }
        }

        return r;
    }


}