public class Circulo {

    private double x, y, raio;

    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    public Circulo(int x, int y, int raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo umCirculo){
        this.x  = umCirculo.getX();
        this.y = umCirculo.getY();
        this.raio = umCirculo.getRaio();
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public void alteraCentro(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double calculaArea(){
        return Math.PI*Math.pow(this.raio,2);
    }

    public double calculaPerimetro(){
        return Math.PI*2*this.raio;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass())) return false;
        Circulo c = (Circulo) o;
        return (this.x == c.getX() && this.y == c.getY() && this.raio == c.getRaio());
    }

    public String toString(){
        return "X: " +this.x+ " Y: " +this.y+ " Raio: " +this.raio;
    }

    public Circulo clone(){
        return new Circulo(this);
    }

}