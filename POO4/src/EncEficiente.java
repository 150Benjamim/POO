import java.time.LocalDate;
import java.util.ArrayList;

public class EncEficiente {

    private String clienteNome, clienteMorada;
    private int clienteNumero, encomendaNumero;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> encomendaLinhas;

    public EncEficiente(){
        this.clienteNome = null;
        this.clienteMorada = null;
        this.clienteNumero = -1;
        this.encomendaNumero = -1;
        this.data = null;
        this.encomendaLinhas = new ArrayList<>();

    }

    public EncEficiente(String clienteNome, String clienteMorada, int clienteNumero, int encomendaNumero){
        this.clienteNome = clienteNome;
        this.clienteMorada = clienteMorada;
        this.clienteNumero = clienteNumero;
        this.encomendaNumero = encomendaNumero;
        this.data = LocalDate.now();
        this.encomendaLinhas = new ArrayList<>();
    }

    public EncEficiente(EncEficiente encomenda){
        this.clienteNome = encomenda.getClienteNome();
        this.clienteMorada = encomenda.getClienteMorada();
        this.clienteNumero = encomenda.getClienteNumero();
        this.encomendaNumero = encomenda.getEncomendaNumero();
        this.data = encomenda.getData();
        this.encomendaLinhas = encomenda.getEncomendaLinhas();
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public String getClienteMorada() {
        return clienteMorada;
    }

    public int getClienteNumero() {
        return clienteNumero;
    }

    public int getEncomendaNumero() {
        return encomendaNumero;
    }

    public LocalDate getData() {
        return data;
    }

    public ArrayList<LinhaEncomenda> getEncomendaLinhas() {
        return (ArrayList<LinhaEncomenda>) encomendaLinhas.clone();
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public void setClienteMorada(String clienteMorada) {
        this.clienteMorada = clienteMorada;
    }

    public void setClienteNumero(int clienteNumero) {
        this.clienteNumero = clienteNumero;
    }

    public void setEncomendaNumero(int encomendaNumero) {
        this.encomendaNumero = encomendaNumero;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public double calculaValorTotal(){
        return this.encomendaLinhas.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }

    public double calculaValorDesconto(){
        return this.encomendaLinhas.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    public int numeroTotalProdutos(){
        return this.encomendaLinhas.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
    }

    public boolean existeProdutoEncomenda(String refProduto){
        return this.encomendaLinhas.stream().map(LinhaEncomenda::getReferencia).anyMatch(referencia->referencia.equals(refProduto));
    }

    public void adicionaLinha(LinhaEncomenda linha){
        this.encomendaLinhas.add(linha);
    }

    public void removeProduto (String refPro){
        this.encomendaLinhas.removeIf(p->p.getReferencia().equals(refPro));
    }

}