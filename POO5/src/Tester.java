import java.util.HashMap;
import java.util.Map;

public class Tester {


    public static void main(String[] args) {
        Map<String, Aluno> fds = new HashMap<>();
        Aluno bro = new Aluno(20,"a","b","c");

        Aluno bro1 = new Aluno(21,"a","b","c");

        Aluno bro2 = new Aluno(20,"a","c","c");

        Aluno bro3 = new Aluno(20,"a","d","c");

        fds.put("a",bro);
        fds.put("b",bro1);
        fds.put("c",bro2);
        fds.put("d",bro3);

        TurmaAlunos turma = new TurmaAlunos("turma",30);

        turma.setTurma(fds);


        System.out.println(turma);



    }

}
