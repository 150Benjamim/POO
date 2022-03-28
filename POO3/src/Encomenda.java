import java.time.LocalDate;
import java.util.Arrays;

public class Encomenda {

    private String nomeCliente, moradaCliente;
    private int numeroCliente, numeroEncomenda;
    private LocalDate dataEncomenda;
    private LinhaEncomendaArray encomendas;

    Encomenda(){
        this.nomeCliente = null;
        this.moradaCliente = null;
        this.numeroCliente = -1;
        this.numeroEncomenda = 0;
        this.dataEncomenda = null;
        this.encomendas = new LinhaEncomendaArray();
    }

    Encomenda(String nomeCliente, String moradaCliente, int numeroCliente, int numeroEncomenda, LocalDate dataEncomenda, int capacidade){
        this.nomeCliente = nomeCliente;
        this.moradaCliente = moradaCliente;
        this.numeroCliente = numeroCliente;
        this.numeroEncomenda = numeroEncomenda;
        this.dataEncomenda = dataEncomenda;
        this.encomendas = new LinhaEncomendaArray(capacidade);
    }

    Encomenda(Encomenda e){
        this.nomeCliente = e.getNomeCliente();
        this.moradaCliente = e.getMoradaCliente();
        this.numeroCliente = e.getNumeroCliente();
        this.numeroEncomenda = e.getNumeroEncomenda();
        this.dataEncomenda = e.getDataEncomenda();
        this.encomendas = e.getEncomendas();
    }

    public String toString() {
        return "Encomenda{" +
                "nomeCliente='" + this.nomeCliente + '\'' +
                ", moradaCliente='" + this.moradaCliente + '\'' +
                ", numeroCliente=" + this.numeroCliente +
                ", numeroEncomenda=" + this.numeroEncomenda +
                ", dataEncomenda=" + this.dataEncomenda + "}\n" +
                "Encomendas: " + this.encomendas.toString()
                ;
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMoradaCliente() {
        return this.moradaCliente;
    }

    public void setMoradaCliente(String moradaCliente) {
        this.moradaCliente = moradaCliente;
    }

    public int getNumeroCliente() {
        return this.numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getNumeroEncomenda() {
        return this.numeroEncomenda;
    }

    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }

    public LocalDate getDataEncomenda() {
        return this.dataEncomenda;
    }

    public void setDataEncomenda(LocalDate dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public LinhaEncomendaArray getEncomendas() {
        return this.encomendas.clone();
    }

    public void setEncomendas(LinhaEncomendaArray encomendas) {
        this.encomendas = encomendas;
    }

    public double calculaValorTotal(){
        return this.encomendas.calculaValorTotal();
    }

    public double calculaValorDesconto(){
        return this.encomendas.calculaValorDesconto();
    }

    public int numeroTotalProdutos(){
        return this.encomendas.numeroTotalProdutos();
    }

    public boolean existeProdutoEncomenda(String refProduto){
        return this.encomendas.existeProdutoEncomenda(refProduto);
    }

    public void adicionaLinha(LinhaEncomenda linha){
        this.encomendas.adicionaLinha(linha);
    }

    public void removeProduto(String codProd){
        this.encomendas.removeProduto(codProd);
    }




}
