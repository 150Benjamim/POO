import java.time.LocalDateTime;

public class PedidodeSuporte {

    private String cliente, empregado, assunto, descricaoPedido, respostaPedido;
    private LocalDateTime submissaoFeita, submissaoConcluida;

    public PedidodeSuporte(){
        cliente = null;
        empregado = null;
        assunto = null;
        descricaoPedido = null;
        respostaPedido = null;
        submissaoFeita = LocalDateTime.now();
        submissaoConcluida = null;
    }

    public PedidodeSuporte(String cliente, String assunto, String descricaoPedido){
        this.cliente = cliente;
        empregado = null;
        this.assunto = assunto;
        this.descricaoPedido = descricaoPedido;
        respostaPedido = null;
        submissaoFeita = LocalDateTime.now();
        submissaoConcluida = null;
    }

    public PedidodeSuporte(PedidodeSuporte pedido){
        this.cliente = pedido.getCliente();
        this.empregado = pedido.getEmpregado();
        this.assunto = pedido.getAssunto();
        this.descricaoPedido = pedido.getDescricaoPedido();
        this.respostaPedido = pedido.getRespostaPedido();
        this.submissaoFeita = pedido.getSubmissaoFeita();
        this.submissaoConcluida = pedido.getSubmissaoConcluida();
    }

    public PedidodeSuporte clone(){
        return new PedidodeSuporte(this);
    }

    public String getCliente() {
        return cliente;
    }

    public String getEmpregado() {
        return empregado;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public String getRespostaPedido() {
        return respostaPedido;
    }

    public LocalDateTime getSubmissaoFeita() {
        return submissaoFeita;
    }

    public LocalDateTime getSubmissaoConcluida() {
        return submissaoConcluida;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setEmpregado(String empregado) {
        this.empregado = empregado;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public void setRespostaPedido(String respostaPedido) {
        this.respostaPedido = respostaPedido;
    }

    public void setSubmissaoFeita(LocalDateTime submissaoFeita) {
        this.submissaoFeita = submissaoFeita;
    }

    public void setSubmissaoConcluida(LocalDateTime submissaoConcluida) {
        this.submissaoConcluida = submissaoConcluida;
    }
}
