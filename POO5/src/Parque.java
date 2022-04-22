import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parque {

    String nome;
    Map<String,Lugar> lugares;

    public Parque(){
        nome = null;
        lugares = new HashMap<>();
    }

    public Parque(String nome, Map<String,Lugar> lugares) {
        this.nome = nome;
        this.lugares = new HashMap<>();
        this.setLugares(lugares);
    }

    public Parque(Parque p){
        this.nome = p.getNome();
        this.setLugares(p.getLugares());
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Map<String,Lugar> getLugares(){
        Map<String,Lugar> lugaresAux = new HashMap<>();
        for (Lugar lugar : this.lugares.values()){
            String key = lugar.getMatricula();
            lugaresAux.put(key,lugar.clone());
        }
        return lugaresAux;
    }

    public void setLugares(Map<String,Lugar> lugares) {

        this.lugares = new HashMap<>();

        for (Lugar lugar : lugares.values()){
            String key = lugar.getMatricula();
            this.lugares.put(key,lugar.clone());
        }
    }


    public List<String> matriculas(){

        return new ArrayList<>(this.lugares.keySet());
    }

    public void ocuparLugar(Lugar l){
        this.lugares.put(l.getMatricula(),l.clone());
    }

    public void removeLugar(String matricula){
        this.lugares.remove(matricula);
    }

    public void alteraTempoLugar(String matricula, int tempo){

        Lugar l = this.lugares.get(matricula);
        if (l!=null){
            l.setMinutos(tempo);
            this.lugares.put(matricula,l);
        }
    }

    public int tempoTotalAtribuido(){
        return this.lugares.values().stream().mapToInt(Lugar::getMinutos).sum();
    }

    public boolean existeLugarAtribuido(String matricula){
        return this.lugares.containsKey(matricula);
    }

    public List<String> matriculasLugarPermanente(){
        return this.lugares.values().stream()
                                    .filter(l -> l.isPermanente() && l.getMinutos()>0)
                                    .map(Lugar::getMatricula)
                                    .collect(Collectors.toList());
    }

    public List<Lugar> copiaLugares(){
        return new ArrayList<>(this.getLugares().values());
    }

    public Lugar lugarMatricula(String matricula){
        return this.lugares.get(matricula).clone();
    }


}