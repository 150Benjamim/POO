public class tester {

    public static void main(String[] args) {


        CasaInteligente teste = new CasaInteligente();

        Lampada l = new Lampada();


        teste.addLampada(l.clone());
        teste.addLampada(l.clone());
        teste.addLampada(l.clone());

        teste.ligaLampadaNormal(2);
        teste.ligaLampadaEco(0);
        teste.ligaLampadaEco(1);

        System.out.printf("\n" + teste.qtEmEco());
        System.out.printf("\n" + teste.maisGastadora().toString() + '\n');
        System.out.printf("\n" + teste.getLampadas().get(1).toString());
        System.out.printf("\n" + teste.getLampadas().get(2).toString());
    }





}
