import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;


public class ExcTres {

    private LocalDate[] listaDatas;
    private int indice;


    public ExcTres(int size){
        listaDatas = new LocalDate[size];
        indice = 0;
    }

    public void insere(LocalDate data){
        if (listaDatas.length == indice){
            LocalDate[] aux = new LocalDate[listaDatas.length+10];
            System.arraycopy(listaDatas,0,aux,0,listaDatas.length);
            listaDatas = aux;
        }
        listaDatas[indice++] = data;
    }

    public LocalDate dataMaisProxima(LocalDate data){

        long diff = Math.abs(ChronoUnit.DAYS.between(listaDatas[0],data));
        LocalDate r = listaDatas[0];

        for (int i = 1; i<indice; i++){

            long comp = Math.abs(ChronoUnit.DAYS.between(listaDatas[i],data));
            if (comp < diff){
                diff = comp;
                r = listaDatas[i];
            }
        }

        return r;
    }

    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String[] r = new String[indice];

        for (int i = 0; i<indice; i++){
            r[i] = listaDatas[i].format(formatter);
        }

        return (Arrays.toString(r));
    }

}