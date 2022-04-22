import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TurmaAlunos {

    Map<String,Aluno> turma;
    String nome;
    int codUC;

    public TurmaAlunos(){
        turma = new HashMap<>();
        nome = null;
        codUC = -1;
    }

    public TurmaAlunos(String nome, int codUC){
        turma = new HashMap<>();
        this.nome = nome;
        this.codUC = codUC;
    }

    public TurmaAlunos(TurmaAlunos ta){
        this.turma = ta.getTurma();
        this.nome = ta.getNome();
        this.codUC = ta.getCodUC();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null  || o.getClass() != this.getClass()) return false;
        TurmaAlunos ta = (TurmaAlunos) o;
        return (this.turma.equals(ta.getTurma())
                && this.nome.equals(ta.getNome())
                && this.codUC == ta.getCodUC());
    }

    public String toString(){
        return "Código da Unidade Curricular: " + this.codUC + '\n'
                + "Nome da turma: " + this.nome + '\n'
                + "Alunos da turma: " + this.turma.toString();
    }

    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }

    @Override
    public int compareTo(TurmaAlunos ta){
        // >0 se this > a
        // == 0 se this == a
        // <0 se this < a

        return this.nome.compareTo(ta.getNome());
        //o metodo .compareTo obedece a regra escrita em cima
        //se o java precisar de ordenar o numero, ele usa isto
    }

    public Map<String, Aluno> getTurma() {
        Map<String, Aluno> turmaCopy = new HashMap<>();
        for (Aluno a : turma.values()){
            String key = a.getNumero();
            turmaCopy.put(key,a.clone());
        }
        return turmaCopy;
    }

    public void setTurma(Map<String, Aluno> turma) {
        for (Aluno a : turma.values()){
            String key = a.getNumero();
            this.turma.put(key,a.clone());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodUC() {
        return codUC;
    }

    public void setCodUC(int codUC) {
        this.codUC = codUC;
    }











}
