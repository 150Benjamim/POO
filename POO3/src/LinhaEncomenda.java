public class LinhaEncomenda {

    private String referencia, descricao;
    private int quantidade;
    private double preco, imposto, desconto;

    LinhaEncomenda(){
        this.referencia = null;
        this.descricao = null;
        this.quantidade = 0;
        this.preco = 0;
        this.imposto = 0;
        this.desconto = 0;
    }

    LinhaEncomenda(String referencia, String descricao, int quantidade, double preco, double imposto, double desconto){
        this.referencia = referencia;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    LinhaEncomenda(LinhaEncomenda le){
        this.referencia = le.getReferencia();
        this.descricao = le.getDescricao();
        this.quantidade = le.getQuantidade();
        this.preco = le.getPreco();
        this.imposto = le.getImposto();
        this.desconto = le.getDesconto();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || this.getClass() != o.getClass()) return false;

        LinhaEncomenda le = (LinhaEncomenda) o;
        return (this.referencia.equals(le.getReferencia())) && (this.descricao.equals(le.getDescricao())) &&
                (this.quantidade == le.getQuantidade()) && (this.preco == le.getPreco()) &&
                (this.imposto == le.getImposto()) && (this.desconto == le.getDesconto())
                ;
    }

    public String toString() {
        return  "{referencia='" + referencia + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", imposto=" + imposto +
                ", desconto=" + desconto +
                '}';
    }

    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }


    public double calculaValorLinhaEnc(){
        double preco = this.quantidade * this.preco;
        preco -= this.calculaValorDesconto();
        double imposto = preco * this.imposto/100;

        return (preco + imposto);
    }

    public double calculaValorDesconto(){
        return (this.quantidade*this.preco*this.desconto/100);
    }



}