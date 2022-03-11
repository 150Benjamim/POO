import java.util.Arrays;
import java.lang.String;

public class ExcCinco {


    public boolean repetition (String x, String[] lista, int pos){

        for (int i = 0; i<pos; i++){
            if (x.equals(lista[i])) return true;
        }

        return false;
    }


    public String[] arrayNoRepetitions (String[] lista){

        String[] aux = new String[lista.length];
        int pos = 0;

        for (int i = 0; i<lista.length; i++){
            if (!repetition(lista[i],aux,pos)){
                aux[pos] = lista[i];
                pos++;
            }
        }

        String[] r = new String[pos];
        System.arraycopy(aux,0,r,0,pos);

        return r;
    }


    public String maiorString (String[] lista){

        String max = lista[0];
        for (int i = 0; i< lista.length; i++){
            if (lista[i].length()>max.length()) max = lista[i];
        }

        return max;
    }


    public String[] arrayRepetitions (String[] lista){

        String[] aux = new String[lista.length];
        int pos = 0;

        for (int i = 0; i<lista.length; i++){
            int contador = 0;
            for (int j = 0; j<lista.length; j++){
                if (lista[i].equals(lista[j])) contador++;
            }
            if (contador>=2 && !repetition(lista[i],aux,pos)){
                aux[pos] = lista[i];
                pos++;
            }
        }

        String[] r = new String[pos];
        System.arraycopy(aux,0,r,0,pos);

        return r;
    }


    public int quantasRepString (String[] lista, String str){

        int contador = 0;

        for (int i = 0; i<lista.length; i++){
            if (lista[i].equals(str)) contador++;
        }

        return contador;
    }

}