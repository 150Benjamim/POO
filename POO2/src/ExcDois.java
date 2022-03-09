import java.util.Arrays;

public class ExcDois {


    public int somaUC (int[][] pauta, int uc){

        int r = 0;
        for (int i = 0; i<5; i++){
            r += pauta[i][uc];
        }

        return r;
    }

    public float mediaAluno(int[][] pauta, int aluno){

        int r = 0;
        for (int i = 0; i<5; i++){
            r += pauta[aluno][i];
        }

        return (r/5);
    }

    public float mediaUC(int[][] pauta, int uc){

        return (somaUC(pauta,uc)/5);
    }

    public int[] maxNota(int[][] pauta){

        int[] r = new int[5];
        Arrays.fill(r,Integer.MIN_VALUE);
        int aux = 0;

        for (int i = 0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if (pauta[i][j] > r[aux]) r[aux] = pauta[i][j];
            }
            aux++;
        }

        return r;
    }

    public int[] minNota(int[][] pauta){

        int[] r = new int[5];
        Arrays.fill(r,Integer.MAX_VALUE);
        int aux = 0;

        for (int i = 0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if (pauta[i][j] < r[aux]) r[aux] = pauta[i][j];
            }
            aux++;
        }

        return r;
    }

    public int[] notasAcima(int[][] pauta, int min){

        int[] r = new int[25];
        int aux = 0, contador = 0;

        for (int i = 0; i<5; i++)
            for (int j = 0; j<5; j++) {
                if (pauta[i][j] > min) {
                    r[aux] = pauta[i][j];
                    contador++;
                    aux++;
                }
            }

        int[] res = new int[contador];

        System.arraycopy(r,0,res,0,contador);

        return res;
    }

    public String todosAlunos(int[][] pauta){

        String[] r = new String[25];

        int aux = 0;

        for (int i = 0; i<5; i++)
            for (int j = 0; j<5; j++) {
                r[aux] = String.valueOf(pauta[i][j]);
                aux++;
            }

        return (Arrays.toString(r));
    }


    public int maiorMediaUC (int[][] pauta){

        float mediamax = mediaUC(pauta, 0);
        int r = 0;

        for (int i = 1; i<5; i++){
            if (mediamax < mediaUC(pauta, i)){
                mediamax = mediaUC(pauta, i);
                r = i;
            }
        }

        return r;
    }

}