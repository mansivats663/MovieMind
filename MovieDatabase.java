import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private final List<Movie> movies;

    public MovieDatabase() {
        movies = new ArrayList<>();
        // Add some sample movies
        movies.add(new Movie(1, "Housefull 5", "Drama", 9.2));
        movies.add(new Movie(2, "Titnic", "Romantic", 9.2));
        movies.add(new Movie(3, "The Fall Guy", "Action", 9.0));
        movies.add(new Movie(2, "The Age of Adaline", "Romantic", 9.2));
        movies.add(new Movie(2, "Badla", "Crime", 9.2));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie getMovie(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }
}
