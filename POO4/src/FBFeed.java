import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FBFeed {

    List<FBPost> posts;

    public FBFeed(){
        posts = new ArrayList<>();
    }

    public int nrPosts(String user){

        return (int) this.posts.stream().filter(p->p.getPostCriador()==user).count();
    }

    public List<FBPost> postsOf(String user){

        return this.posts.stream().filter(p->p.getPostCriador()==user).map(FBPost::clone).collect(Collectors.toList());
    }

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){

        return this.posts.stream()
                         .filter((time -> time.getPostData().isAfter(inicio) && time.getPostData().isBefore(fim)))
                         .collect(Collectors.toList());
    }

    public FBPost getPost(int id){
        for (FBPost post : this.posts){
            if (post.getIdentificador() == id) return post.clone();
        }
        return null;
    }

    public void comment(FBPost post, String comentario){

        for (FBPost publicacao : this.posts) {
            if (post.getIdentificador() == publicacao.getIdentificador()) {
                publicacao.addComment(comentario);
                break;
            }
        }
    }

    public void comment(int postid, String comentario){

        for (FBPost publicacao : this.posts) {
            if (postid == publicacao.getIdentificador()) {
                publicacao.addComment(comentario);
                break;
            }
        }
    }

    public void like(FBPost post){

        for (FBPost publicacao : this.posts) {
            if (post.getIdentificador() == publicacao.getIdentificador()) {
                publicacao.addLike();
                break;
            }
        }
    }

    public void like(int postid){

        for (FBPost publicacao : this.posts) {
            if (postid == publicacao.getIdentificador()) {
                publicacao.addLike();
                break;
            }
        }
    }

    public List<Integer> top5Comments(){

        return this.posts.stream().sorted(Comparator.comparingLong(FBPost::numeroComentarios).reversed()).
                                   limit(5).
                                   map(FBPost::getIdentificador).
                                   collect(Collectors.toList());
    }

}