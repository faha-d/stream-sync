package streamsync;

public class Game {
    private String title;
    private String type;
    private String youtubeUrl;
    private String imageUrl;

    public Game(String title, String type, String youtubeUrl, String imageUrl) {
        this.title = title;
        this.type = type;
        this.youtubeUrl = youtubeUrl;
        this.imageUrl = imageUrl;
    }

    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getYoutubeUrl() { return youtubeUrl; }
    public String getImageUrl() { return imageUrl; }
}
