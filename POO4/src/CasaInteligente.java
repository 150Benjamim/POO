import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {

    private ArrayList<Lampada> lampadas;

    public CasaInteligente(){
        lampadas = new ArrayList<>();
    }

    public CasaInteligente(ArrayList<Lampada> lampada){
        this.lampadas = (ArrayList<Lampada>) lampada.clone();
    }

    public CasaInteligente(CasaInteligente casa){
        this.lampadas = casa.getLampadas();
    }

    public ArrayList<Lampada> getLampadas() {
        return (ArrayList<Lampada>) lampadas.clone();
    }


    public void addLampada(Lampada l){
        this.lampadas.add(l);
    }

    public void ligaLampadaNormal(int index){
        this.lampadas.get(index).lampON();
    }

    public void ligaLampadaEco(int index){
        this.lampadas.get(index).lampECO();
    }

    public int qtEmEco(){
        return (int) this.lampadas.stream().filter( l ->(l.getLigada() && l.getEco()) ).count();
    }

    public void removeLampada(int index){
        this.lampadas.remove(index);
    }

    public void ligaTodasEco(){
        this.lampadas.forEach(Lampada::lampECO);
    }

    public void ligaTodasMax(){
        this.lampadas.forEach(Lampada::lampON);
    }

    public double consumoTotal(){
        return this.lampadas.stream().mapToDouble(Lampada::totalConsumo).sum();
    }

    public Lampada maisGastadora(){

        Optional<Lampada> maisGastadora;
        maisGastadora = this.lampadas.stream().max((lampada1,lampada2)->Long.compare(lampada1.totalConsumo(),lampada2.totalConsumo()));
        //maisGastadora = this.lampadas.stream().reduce((lampada1,lampada2) -> lampada1.totalConsumo() >= lampada2.totalConsumo() ? lampada1 : lampada2);
        if (maisGastadora.isPresent()){
            return maisGastadora.get();
        }
        else return null;
    }


    public Set<Lampada> podiumEconomia(){
        return this.lampadas.stream().sorted((Comparator.comparingLong(Lampada::totalConsumo)).reversed()).limit(3).collect(Collectors.toSet());
    }

    public void reset(){
        this.lampadas.forEach(l-> l.setLigadaHoras(LocalDateTime.now()));
    }








}
