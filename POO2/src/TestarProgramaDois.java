import java.util.Arrays;
import java.util.Scanner;

public class TestarProgramaDois {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        ExcDois test = new ExcDois();

        int[][] pauta = new int[5][5]; // ALUNOS X UNIDADES CURRICULARES

        for (int i = 0; i < 5; i++) {
            System.out.println("Notas às cadeiras de 0 a 20 do aluno " + i + ":");
            for (int j = 0; j < 5; j++) {
                pauta[i][j] = ler.nextInt();
                if (pauta[i][j] < 0 || pauta[i][j] > 20) {
                    System.out.println("Nota de 0 a 20 palhaço! ");
                    System.exit(0);
                }
            }
        }

        int n;

        System.out.println("Somas das notas à UC: ");
        n = ler.nextInt();
        System.out.println("Somas das notas à UC " + n + " é igual a " + test.somaUC(pauta, n));

        System.out.println("Média do aluno: ");
        n = ler.nextInt();
        System.out.println("Média do aluno " + n + " é igual a " + test.mediaAluno(pauta, n));

        System.out.println("Média da UC: ");
        n = ler.nextInt();
        System.out.println("Média da UC " + n + " é igual a " + test.mediaUC(pauta, n));

        System.out.println("Maiores notas a todas as UCS: " + Arrays.toString(test.maxNota(pauta)));

        System.out.println("Menores notas a todas as UCS: " + Arrays.toString(test.minNota(pauta)));

        System.out.println("Notas acima de um determinado valor: ");
        n = ler.nextInt();
        System.out.println("Notas a cima de " + n + " são " + Arrays.toString(test.notasAcima(pauta, n)));

        System.out.println("Todas as notas: " + test.todosAlunos(pauta));

        System.out.println("UC com maior média: " + test.maiorMediaUC(pauta));
    }


}