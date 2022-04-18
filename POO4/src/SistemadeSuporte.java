import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SistemadeSuporte {

    List<PedidodeSuporte> pedidos;

    public SistemadeSuporte(){
        pedidos = new ArrayList<>();
    }

    public SistemadeSuporte(List<PedidodeSuporte> pedidos){
        this.pedidos = new ArrayList<>();
        for (PedidodeSuporte pedido : pedidos){
            this.pedidos.add(pedido.clone());
        }
    }

    public SistemadeSuporte(SistemadeSuporte sistema){
        this.pedidos = new ArrayList<>();
        for (PedidodeSuporte pedido : sistema.getPedidos()){
            this.pedidos.add(pedido.clone());
        }
    }

    public SistemadeSuporte clone(){
        return new SistemadeSuporte(this);
    }

    public List<PedidodeSuporte> getPedidos(){
        List<PedidodeSuporte> pedidoAux = new ArrayList<>();
        for (PedidodeSuporte pedido : this.pedidos){
            pedidoAux.add(pedido.clone());
        }
        return pedidoAux;
    }

    public void setPedidos(SistemadeSuporte sistema){
        this.pedidos = new ArrayList<>();
        for (PedidodeSuporte pedido : sistema.getPedidos()){
            this.pedidos.add(pedido.clone());
        }
    }


    public void inserePedido (PedidodeSuporte pedido){
        this.pedidos.add(pedido.clone());
    }

    public PedidodeSuporte procuraPedido (String user, LocalDateTime data){
        for (PedidodeSuporte pedido : this.pedidos){
            if (pedido.getCliente().equals(user) && pedido.getSubmissaoFeita().isEqual(data)) return pedido.clone();
        }
        return null;
    }

    public void resolvePedido (PedidodeSuporte pedido, String tecnico, String info) {

        for (PedidodeSuporte request : this.pedidos){
            if (pedido.getCliente().equals(request.getCliente()) && pedido.getAssunto().equals(request.getAssunto())){
                request.setEmpregado(tecnico);
                request.setRespostaPedido(info);
                request.setSubmissaoConcluida(LocalDateTime.now());
                break;
            }
        }
    }

    public List<PedidodeSuporte> resolvidos(){
        return this.pedidos.stream().filter(p-> p.getSubmissaoConcluida() != null).map(PedidodeSuporte::clone).collect(Collectors.toList());
    }

    public String colaboradorTop(){

        return resolvidos().stream().map(PedidodeSuporte::getEmpregado)
                                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                                    .entrySet()
                                    .stream()
                                    .max(Map.Entry.comparingByValue())
                                    .map(Map.Entry::getKey).orElse(null);
    }

    public List<PedidodeSuporte> resolvidos (LocalDateTime inicio, LocalDateTime fim){

        return resolvidos().stream().filter(p -> p.getSubmissaoFeita().isAfter(inicio) && p.getSubmissaoFeita().isBefore(fim)).
                                     map(PedidodeSuporte::clone).
                                     collect(Collectors.toList());
    }

    public double tempoMedioResolucao(){

        double tempoTotal = resolvidos().stream()
                                        .mapToDouble(p -> ChronoUnit.MINUTES.between(p.getSubmissaoFeita(),p.getSubmissaoFeita()))
                                        .sum();
        return tempoTotal/resolvidos().size();
    }

    public double tempoMedioResolucao (LocalDateTime inicio, LocalDateTime fim){

        double tempoTotal = resolvidos(inicio,fim).stream()
                                                  .mapToDouble(p -> ChronoUnit.MINUTES.between(p.getSubmissaoFeita(),p.getSubmissaoFeita()))
                                                  .sum();
        return tempoTotal/resolvidos().size();
    }

    public PedidodeSuporte pedidoMaisLongo(){

        Optional<PedidodeSuporte> pedidomaisLongo;

        pedidomaisLongo = resolvidos().stream()
                                      .max(Comparator.comparingLong(p -> ChronoUnit.MINUTES.between(p.getSubmissaoFeita(), p.getSubmissaoFeita())));

        if (pedidomaisLongo.isPresent()){
            return pedidomaisLongo.get().clone();
        }
        return null;
    }

    PedidodeSuporte pedidoMaisLongo (LocalDateTime inicio, LocalDateTime fim){

        Optional<PedidodeSuporte> pedidomaisLongo;

        pedidomaisLongo = resolvidos(inicio,fim).stream()
                          .max(Comparator.comparingLong(p -> ChronoUnit.MINUTES.between(p.getSubmissaoFeita(), p.getSubmissaoFeita())));

        if (pedidomaisLongo.isPresent()){
            return pedidomaisLongo.get().clone();
        }
        return null;
    }

    public PedidodeSuporte pedidoMaisCurto(){

        Optional<PedidodeSuporte> pedidomaisLongo;

        pedidomaisLongo = resolvidos().stream()
                .min(Comparator.comparingLong(p -> ChronoUnit.MINUTES.between(p.getSubmissaoFeita(), p.getSubmissaoFeita())));

        if (pedidomaisLongo.isPresent()){
            return pedidomaisLongo.get().clone();
        }
        return null;
    }

    public PedidodeSuporte pedidoMaisCurto (LocalDateTime inicio, LocalDateTime fim){

        Optional<PedidodeSuporte> pedidomaisLongo;

        pedidomaisLongo = resolvidos(inicio,fim).stream()
                .min(Comparator.comparingLong(p -> ChronoUnit.MINUTES.between(p.getSubmissaoFeita(), p.getSubmissaoFeita())));

        if (pedidomaisLongo.isPresent()){
            return pedidomaisLongo.get().clone();
        }
        return null;
    }


}