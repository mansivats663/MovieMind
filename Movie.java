public class Movie {
    private final int id;
    private final String title;
    private final String genre;

    public Movie(int id, String title, String genre, double ignoredAverageRating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
}