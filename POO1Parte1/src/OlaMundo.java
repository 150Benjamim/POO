public class OlaMundo {

    public static String geraSaudacao(String nome){
        return "Olá "+nome+"!";
    }

    public static void main(String[] args){
        String saudacao = geraSaudacao("Mundo");
        System.out.println(saudacao);
    }
}