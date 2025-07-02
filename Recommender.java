import java.util.ArrayList;
import java.util.List;

public class Recommender {
    private final MovieDatabase movieDatabase;
    private final UserDatabase userDatabase;

    public Recommender(MovieDatabase movieDatabase, UserDatabase userDatabase) {
        this.movieDatabase = movieDatabase;
        this.userDatabase = userDatabase;
    }

    public List<Movie> recommendMovies(int userId) {
        List<Rating> userRatings = userDatabase.getRatingsForUser(userId);
        List<Movie> recommendedMovies = new ArrayList<>();

        // Simple recommendation algorithm mtlb jiski rating achi hogi vhhi movie recommend hogi
        for (Rating rating : userRatings) {
            Movie movie = movieDatabase.getMovie(rating.movieId());
            for (Movie otherMovie : movieDatabase.getMovies())
                if (otherMovie.getGenre().equals(movie.getGenre()) && !recommendedMovies.contains(otherMovie)) {
                    recommendedMovies.add(otherMovie);
                }
        }

        return recommendedMovies;
    }
}
