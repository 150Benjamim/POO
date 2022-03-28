import java.util.Arrays;

public class LinhaEncomendaArray {

    private LinhaEncomenda[] encomendas;
    private int size;

    private static final int capacidade_default = 20;

    public LinhaEncomendaArray(){
        this.encomendas = new LinhaEncomenda[capacidade_default];
        this.size = 0;
    }

    public LinhaEncomendaArray(int capacidade){
        this.encomendas = new LinhaEncomenda[capacidade];
        this.size = 0;
    }

    public LinhaEncomendaArray(LinhaEncomendaArray lea){
        this.encomendas = lea.getEncomendas();
        this.size = lea.getSize();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<this.size; i++) {
            sb.append(this.encomendas[i].toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    public LinhaEncomendaArray clone(){
        return new LinhaEncomendaArray(this);
    }

    public LinhaEncomenda[] getEncomendas(){
        return this.encomendas.clone();
    }
    public int getSize() {
        return this.size;
    }

    public double calculaValorTotal(){
        int valorTotal = 0;
        for (int i = 0; i<this.size; i++){
            valorTotal += this.encomendas[i].calculaValorLinhaEnc();
        }
        return valorTotal;
    }

    public double calculaValorDesconto(){
        int valorDesconto = 0;
        for (int i = 0; i<this.size; i++){
            valorDesconto += this.encomendas[i].calculaValorDesconto();
        }
        return valorDesconto;
    }

    public int numeroTotalProdutos(){
        int produtosTotais = 0;
        for (int i = 0; i<this.size; i++){
            produtosTotais += this.encomendas[i].getQuantidade();
        }
        return produtosTotais;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        for (int i = 0; i<this.size; i++){
            if(this.encomendas[i].getReferencia().equals(refProduto)) return true;
        }
        return false;
    }

    public void aumentaTamanho(){
        int nova_capacidade = this.encomendas.length * 2;
        this.encomendas = Arrays.copyOf(this.encomendas,nova_capacidade);
    }

    public void adicionaLinha(LinhaEncomenda linha){
        if (this.size == this.encomendas.length) {
            this.aumentaTamanho();
        }
        this.encomendas[size] = new LinhaEncomenda(linha);
        this.size++;
    }

    public void removeProduto(String codProd){

        if (existeProdutoEncomenda(codProd)){

            for (int i = 0; i<size; i++){
                if (this.encomendas[i].getReferencia().equals(codProd)){
                    int deslocamento = this.size - i - 1;
                    System.arraycopy(this.encomendas,i+1,this.encomendas,i,deslocamento);
                    this.size--;
                    this.encomendas[size] = null;
                    break;
                }
            }

        }

    }



}