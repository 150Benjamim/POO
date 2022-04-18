import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FBPost {

    private int identificador, likes;
    private String postCriador, conteudo;
    private LocalDateTime postData;
    private List<String> comentarios;

    public FBPost(){
        identificador = -1;
        likes = 0;
        postCriador = null;
        conteudo = null;
        postData = null;
        comentarios = new ArrayList<>();
    }

    public FBPost(int identificador, int likes, String postCriador, String conteudo){
        this.identificador = identificador;
        this.likes = likes;
        this.postCriador = postCriador;
        this.conteudo = conteudo;
        this.postData = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
    }

    public FBPost(FBPost fbpost){
        this.identificador = fbpost.getIdentificador();
        this.likes = fbpost.getLikes();
        this.postCriador = fbpost.getPostCriador();
        this.conteudo = fbpost.getConteudo();
        this.postData = fbpost.getPostData();
        this.comentarios = new ArrayList<>(fbpost.getComentarios());
    }

    public FBPost clone(){
        return new FBPost(this);
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getLikes() {
        return likes;
    }

    public String getPostCriador() {
        return postCriador;
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDateTime getPostData() {
        return postData;
    }

    public List<String> getComentarios() {
        return new ArrayList<>(this.comentarios);
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setPostCriador(String postCriador) {
        this.postCriador = postCriador;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setPostData(LocalDateTime postData) {
        this.postData = postData;
    }

    public void addComment(String comentario){
        this.comentarios.add(comentario);
    }

    public void addLike(){
        this.likes++;
    }

    public int numeroComentarios(){
        return this.comentarios.size();
    }






}
