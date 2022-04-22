public class Aluno implements Comparable<Aluno>{

    private int nota;
    private String nome, numero, curso;

    public Aluno(){
        nota = -1;
        numero = null;
        nome = null;
        curso = null;
    }

    public Aluno(int nota, String nome, String numero, String curso){
        this.nota = nota;
        this.nome = nome;
        this.numero = numero;
        this.curso = curso;
    }

    public Aluno(Aluno aluno) {
        this.nota = aluno.getNota();
        this.nome = aluno.getNome();
        this.numero = aluno.getNumero();
        this.curso = aluno.getNome();
    }

    public String toString() {
        return "Aluno{" +
                "nota=" + nota +
                ", nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    public Aluno clone() {
        return new Aluno(this);
    }

    @Override
    public int compareTo(Aluno a) {
        // >0 se this > a
        // == 0 se this == a
        // <0 se this < a

        return this.nome.compareTo(a.getNome());
        //o metodo .compareTo obedece a regra escrita em cima
        //se o java precisar de ordenar o numero, ele usa isto
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


}