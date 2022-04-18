import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Lampada {

    private boolean ligada;
    private boolean eco;
    private LocalDateTime ligadaHoras;
    private long tempoLigadaMax, tempoLigadaEco;
    private long ultimoConsumo;


    private static long consumoPorMSMax = 15000;
    private static long consumoPorMSEco = 7500;

    public static long getConsumoPorMSMax() {
        return consumoPorMSMax;
    }

    public static void setConsumoPorMSMax(long consumo) {
        consumoPorMSMax = consumo;
    }

    public static long getConsumoPorMSEco() {
        return consumoPorMSEco;
    }

    public static void setConsumoPorMSEco(long consumo) {
        consumoPorMSEco = consumo;
    }

    public Lampada() {
        this.ligada = false;
        this.eco = false;
        this.ligadaHoras = null;
        this.tempoLigadaMax = 0;
        this.tempoLigadaEco = 0;
        this.ultimoConsumo = 0;
    }

    public Lampada(boolean ligada, boolean eco) {
        this.ligada = ligada;
        this.eco = eco;
        this.ligadaHoras = null;
        this.tempoLigadaMax = 0;
        this.tempoLigadaEco = 0;
        this.ultimoConsumo = 0;
    }

    public Lampada(Lampada l) {
        this.ligada = l.getLigada();
        this.eco = l.getEco();
        this.ligadaHoras = null;
        this.tempoLigadaMax = l.getTempoLigadaMax();
        this.tempoLigadaEco = l.getTempoLigadaEco();
        this.ultimoConsumo = l.getUltimoConsumo();
    }

    public LocalDateTime getLigadaHoras() {
        return this.ligadaHoras;
    }

    public boolean getLigada() {
        return this.ligada;
    }

    public boolean getEco() {
        return this.eco;
    }

    public long getTempoLigadaMax() {
        return this.tempoLigadaMax;
    }

    public long getTempoLigadaEco() {
        return this.tempoLigadaEco;
    }

    public long getUltimoConsumo() {
        return this.ultimoConsumo;
    }

    public void setLigada(boolean ligada) {
        this.ligada = ligada;
    }

    public void setEco(boolean eco) {
        this.eco = eco;
    }

    public void setTempoLigadaMax(long tempoLigadaMax) {
        this.tempoLigadaMax = tempoLigadaMax;
    }

    public void setTempoLigadaEco(long tempoLigadaEco) {
        this.tempoLigadaEco = tempoLigadaEco;
    }

    public void setLigadaHoras(LocalDateTime ligadaHoras) {
        this.ligadaHoras = ligadaHoras;
    }

    public void setUltimoConsumo(long ultimoConsumo){
        this.ultimoConsumo = ultimoConsumo;
    }

    public boolean isequals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Lampada l = (Lampada) o;
        return (this.ligada == l.getLigada()) && (this.eco == l.getEco()) &&
                (this.tempoLigadaMax == l.getTempoLigadaMax()) && (this.tempoLigadaEco == l.getTempoLigadaEco()) &&
                (this.ultimoConsumo == l.getUltimoConsumo()) && (this.ligadaHoras == l.getLigadaHoras());
    }

    public String toString() {
        return "A lâmpada está ligada? " + this.ligada + '\n' +
                "A lâmpada está em modo eco? " + this.eco;
    }

    public Lampada clone() {
        return new Lampada(this);
    }

    public int compareTo(Lampada l){
        if (this.totalConsumo() == l.totalConsumo()) return 0;
        if (this.totalConsumo() > l.totalConsumo()) return 1;
        return -1;
    }

    public void lampON() {
        if (this.ligada) {
            if (this.eco) {
                this.ultimoConsumo = ChronoUnit.MILLIS.between(this.ligadaHoras, LocalDateTime.now());
                this.tempoLigadaEco += this.ultimoConsumo;
                this.ligadaHoras = LocalDateTime.now();
                this.eco = false;
            }
        } else {
            this.ligadaHoras = LocalDateTime.now();
            this.ligada = true;
            this.eco = false;
        }
    }

    public void lampECO() {
        if (this.ligada) {
            if (!this.eco) {
                this.ultimoConsumo = ChronoUnit.MILLIS.between(this.ligadaHoras, LocalDateTime.now());
                this.tempoLigadaMax += this.ultimoConsumo;
                this.ligadaHoras = LocalDateTime.now();
                this.eco = true;
            }
        }
        else {
            this.ligadaHoras = LocalDateTime.now();
            this.ligada = true;
            this.eco = true;
        }
    }

    public void lampOFF() {
        if (this.ligada) {
            if (this.eco) {
                this.ultimoConsumo = ChronoUnit.MILLIS.between(this.ligadaHoras, LocalDateTime.now());
                this.tempoLigadaEco += this.ultimoConsumo;
            }
            if (!this.eco) {
                this.ultimoConsumo = ChronoUnit.MILLIS.between(this.ligadaHoras, LocalDateTime.now());
                this.tempoLigadaMax += this.ultimoConsumo;
            }
            this.ligada = false;
        }
    }

    public long totalConsumo() {
        if (this.ligada) {
            if (!this.eco) {
                this.tempoLigadaMax += ChronoUnit.MILLIS.between(this.ligadaHoras, LocalDateTime.now());
                this.ligadaHoras = LocalDateTime.now();
            }
            if (this.eco) {
                this.tempoLigadaEco += ChronoUnit.MILLIS.between(this.ligadaHoras, LocalDateTime.now());
                this.ligadaHoras = LocalDateTime.now();
            }
        }

        return (long)(this.tempoLigadaMax*Lampada.getConsumoPorMSMax() + this.tempoLigadaEco*Lampada.getConsumoPorMSEco());
    }

    public double periodoConsumo(){
        if (this.ligada) {
            this.ultimoConsumo = ChronoUnit.MILLIS.between(this.ligadaHoras, LocalDateTime.now());
            if (this.eco) return (long) (this.ultimoConsumo * Lampada.getConsumoPorMSEco());
            else return (long) (this.ultimoConsumo * getConsumoPorMSMax());
        }
        return 0;
    }


}