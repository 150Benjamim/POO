import java.util.Arrays;

public class Telemovel {

    private String marca, modelo;
    private int resX, resY;
    private int armMensagens;
    private byte armFotosAps, armFotos, armAps, armOcupado;
    private String[] nomesAps, msgs;
    private int savedFotos, savedAps, savedMsgs;

    public Telemovel(){
        this.marca = "N/A";
        this.modelo = "N/A";
        this.resX = 0;
        this.resY = 0;
        this.armMensagens = 100;
        this.armFotos = 0;
        this.armAps = 0;
        this.armFotosAps = 0;
        this.armOcupado = 0;
        this.savedFotos = 0;
        this.savedAps = 0;
        this.savedMsgs = 0;
        this.nomesAps = new String[10];
        this.msgs = new String[armMensagens];
    }

    public Telemovel(String marca, String modelo, int resY, int resX, byte armMensagens, byte armFotos, byte armAps, byte armOcupado){
        this.marca = new String(marca);
        this.modelo = new String(modelo);
        this.resX = resX;
        this.resY = resY;
        this.armMensagens = armMensagens;
        this.armFotos = armFotos;
        this.armAps = armAps;
        this.armFotosAps = (byte)(armFotos + armAps);
        this.armOcupado = armOcupado;
        this.savedFotos = 0;
        this.savedAps = 0;
        this.savedMsgs = 0;
        this.nomesAps = new String[10];
        this.msgs = new String[10];
    }

    public Telemovel(Telemovel t){
        this.marca = new String(t.marca);
        this.modelo = new String(t.modelo);
        this.resX = t.resX;
        this.resY = t.resY;
        this.armMensagens = t.armMensagens;
        this.armFotos = t.armFotos;
        this.armAps = t.armAps;
        this.armFotosAps = t.armFotosAps;
        this.armOcupado = t.armOcupado;
        this.savedFotos = t.savedFotos;
        this.savedAps = t.savedAps;
        this.savedMsgs = t.savedMsgs;
        this.nomesAps = t.nomesAps.clone();
        this.msgs = t.msgs.clone();
    }

    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getResX() {
        return this.resX;
    }
    public void setResX(int resX) {
        this.resX = resX;
    }
    public int getResY() {
        return this.resY;
    }
    public void setResY(int resY) {
        this.resY = resY;
    }
    public int getArmMensagens() {
        return this.armMensagens;
    }
    public void setArmMensagens(byte armMensagens) {
        this.armMensagens = armMensagens;
    }
    public byte getArmFotosAps() {
        return this.armFotosAps;
    }
    public void setArmFotosAps(byte armFotosAps) {
        this.armFotosAps = armFotosAps;
    }
    public byte getArmFotos() {
        return this.armFotos;
    }
    public void setArmFotos(byte armFotos) {
        this.armFotos = armFotos;
    }
    public byte getArmAps() {
        return this.armAps;
    }
    public void setArmAps(byte armAps) {
        this.armAps = armAps;
    }
    public byte getArmOcupado() {
        return this.armOcupado;
    }
    public void setArmOcupado(byte armOcupado) {
        this.armOcupado = armOcupado;
    }
    public String[] getNomesAps() {
        return this.nomesAps.clone();
    }
    public String[] getMsgs() {
        return this.msgs.clone();
    }
    public int getSavedFotos() {
        return this.savedFotos;
    }
    public void setSavedFotos(int savedFotos) {
        this.savedFotos = savedFotos;
    }
    public int getSavedAps() {
        return this.savedAps;
    }
    public void setSavedAps(int savedAps) {
        this.savedAps = savedAps;
    }
    public int getSavedMsgs() {
        return this.savedMsgs;
    }
    public void setSavedMsgs(int savedMsgs) {
        this.savedMsgs = savedMsgs;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Telemovel t = (Telemovel) o;
        return  (this.marca.equals(t.getMarca())) && (this.modelo.equals(t.getModelo())) &&
                (this.resX == t.getResX()) && (this.resY == t.getResY()) &&
                (this.armMensagens == t.getArmMensagens()) && (this.armFotosAps == t.getArmFotosAps()) &&
                (this.armFotos == t.getArmFotos()) && (this.armAps == t.getArmAps()) &&
                (this.armOcupado == t.getArmOcupado()) && (this.nomesAps.equals(t.getNomesAps())) &&
                (this.msgs.equals(t.getMsgs())) && (this.savedFotos == t.getSavedFotos()) &&
                (this.savedAps == t.getSavedAps()) && (this.savedMsgs == t.getSavedMsgs());

    }

    public String toString() {
        return  "Marca: " + this.marca + '\n' +
                "Modelo: " + this.modelo + '\n' +
                "Resolução X: " + this.resX + '\n' +
                "Resolução Y: " + this.resY + '\n' +
                "Armazenamento para mensagens: " + this.armMensagens + '\n' +
                "Armazenamento para Fotos e Aps: " + this.armFotosAps + '\n' +
                "Armazenamento para Fotos: " + armFotos + '\n' +
                "Armazenamentos para Aps: " + armAps + '\n' +
                "Armazenamento ocupado: " + armOcupado + '\n' +
                "Aps instaladas: " + Arrays.toString(Arrays.copyOfRange(this.nomesAps,0,this.savedAps)) + '\n' +
                "Mensagens guardadas: " + Arrays.toString(Arrays.copyOfRange(this.msgs,0,this.savedMsgs)) + '\n' +
                "Número de fotos guardadas: " + savedFotos + '\n' +
                "Número de aps guardadas: " + savedAps + '\n' +
                "Número de mensagens guardadas: " + savedMsgs + '\n'
                ;
    }

    public Telemovel clone(){
        return new Telemovel(this);
    }



    public boolean existeEspaco(int numeroBytes){
        if (this.armOcupado + numeroBytes <= this.armFotosAps) return true;
        else return false;
    }

    public void instalaApp(String nome, int tamanho){

        if (existeEspaco(tamanho)) {
            if (this.savedAps < this.nomesAps.length) {
                this.nomesAps[this.savedAps] = nome;
                this.savedAps++;
                this.armOcupado += tamanho;
            }
            else{
                String[] aux = new String[this.savedAps*2];
                System.arraycopy(this.savedAps,0,aux,0,this.savedAps);
                aux[this.savedAps] = nome;
                this.nomesAps = aux;
                this.savedAps++;
                this.armOcupado += tamanho;
            }
        }

    }

    public void recebeMsg(String msg) {

        if (this.savedMsgs < this.armMensagens) {
            this.msgs[this.savedMsgs] = msg;
            this.savedMsgs++;
        }
        else System.out.println("Caixa de mensagens cheia. Não foi possível receber mensagem!");
    }

    public double tamMedioApps(){

        return ((double) (this.armAps / this.savedAps));
    }

    public String maiorMsg(){

        if (savedMsgs<1) return ("Não existem mensagens gravadas neste telemóvel");

        String maiorMsgI = this.msgs[0];
        for (int i = 1; i<this.savedMsgs; i++){
            if (this.msgs[i].length()>maiorMsgI.length()) maiorMsgI = msgs[i];
        }

        return maiorMsgI;
    }

    public void removeApp(String nome, int tamanho){

        for (int i = 0; i<this.savedAps; i++){

            if (nome.equals(this.nomesAps[i])){
                for (int j = i; j<this.savedAps-1; j++){
                    this.nomesAps[j] = this.nomesAps[j+1];
                }
                this.savedAps--;
                this.armOcupado = (byte)(this.armOcupado-tamanho);
                break;
            }

        }
    }


}