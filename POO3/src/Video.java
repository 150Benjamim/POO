import java.time.LocalDate;
import java.util.Arrays;
import java.time.temporal.ChronoUnit;


public class Video {

    private String name;
    private byte[] content;
    private LocalDate uploadDate;
    private String resolution;
    private int duration;
    private String[] comments;
    private int commentsNumber;
    private int likes,dislikes;

    public Video(){
        this.name = "N/A";
        this.content = null;
        this.uploadDate = null;
        this.resolution = "0";
        this.duration = 0;
        this.comments = new String[10];
        this.commentsNumber = 0;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Video(String name, byte[] content, LocalDate uploadDate, int resolutionX, int resolutionY, int duration, String[] comments, int commentsNumber, int likes, int dislikes) {
        this.name = new String(name);
        this.content = content;
        this.uploadDate = uploadDate;
        this.resolution = new String(resolution);
        this.duration = duration;
        this.comments = comments.clone();
        this.commentsNumber = commentsNumber;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Video (Video v){
        this.name = v.getName();
        this.content = v.getContent();
        this.uploadDate = v.getUploadDate();
        this.resolution = v.getResolution();
        this.duration = v.getDuration();
        this.comments = v.getComments().clone();
        this.commentsNumber = v.getCommentsNumber();
        this.likes = v.getLikes();
        this.dislikes = v.getDislikes();
    }

    public String getName() {
        return name;
    }
    public byte[] getContent() {
        return content;
    }
    public LocalDate getUploadDate() {
        return uploadDate;
    }
    public String getResolution() {
        return resolution;
    }
    public int getDuration() {
        return duration;
    }
    public String[] getComments() {
        return comments.clone();
    }
    public int getCommentsNumber(){
        return commentsNumber;
    }
    public int getLikes() {
        return likes;
    }
    public int getDislikes() {
        return dislikes;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setContent(byte[] content) {
        this.content = content;
    }
    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setComments(String[] comments) {
        this.comments = comments.clone();
    }
    public void setCommentsNumber(int commentsNumber){
        this.commentsNumber = commentsNumber;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o==null) || (this.getClass()!=o.getClass())) return false;
        Video v = (Video) o;
        return  (this.name.equals(v.getName())) && (this.content.equals(v.getContent())) &&
                (this.uploadDate.equals(v.getUploadDate())) && (this.resolution.equals(v.getResolution())) &&
                (this.duration==v.getDuration()) && (this.comments.equals(v.getComments())) && (this.commentsNumber==v.getCommentsNumber()) &&
                (this.likes==v.getLikes()) && (this.dislikes==v.getDislikes());
    }

    public String toString(){
        return  "Name: " +this.name + '\n' +
                "Content: " +Arrays.toString(this.content)+ '\n' +
                "Upload Date: " +this.uploadDate.toString() + '\n' +
                "Resolution: " +this.resolution + '\n' +
                "Duration in seconds: " +this.duration + '\n' +
                "Comments: " + Arrays.toString(this.comments) + '\n' +
                "Number of comments. " +this.commentsNumber + '\n' +
                "Likes: " + this.likes + " & Dislikes: " +this.dislikes
                ;
    }

    public Video clone(){
        return new Video(this);
    }


    public void insertComment(String comment){

        if (this.commentsNumber == comments.length) {
            String[] aux = new String[commentsNumber * 2];
            System.arraycopy(this.comments, 0, aux, 0, commentsNumber);
            this.comments = aux;
        }

        this.comments[commentsNumber] = comment;
        commentsNumber++;
    }


    public long howManyDaysLater() {

        return (ChronoUnit.DAYS.between(this.uploadDate,LocalDate.now()));
    }

    public void thumbsUp(){
        this.likes++;
    }
    public void thumbsDown(){
        this.dislikes++;
    }

    public String process(){
        return Arrays.toString(this.content);
    }

}