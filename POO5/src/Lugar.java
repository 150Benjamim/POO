public class Lugar {

    private String matricula, nome;
    private int minutos;
    private boolean permanente;

    public Lugar(){
        matricula = null;
        nome = null;
        minutos = -1;
        permanente = false;
    }

    public Lugar(String matricula, String nome, int minutos, boolean permanente) {
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    public Lugar(Lugar l){
        this.matricula = l.getMatricula();
        this.nome = l.getNome();
        this.minutos = l.getMinutos();
        this.permanente = l.isPermanente();
    }

    public Lugar clone(){
        return new Lugar(this);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isPermanente() {
        return permanente;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }




}
