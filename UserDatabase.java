import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    List<user> users;
    private final List<Rating> ratings;

    public UserDatabase() {
        users = new ArrayList<>();
        ratings = new ArrayList<>();
    }

    public void addUser(user user) {
        users.add(user);
    }

    public user authenticateUser(String username, String password) {
        for (user user : users) {
            if (user.username().equals(username) && user.password().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public List<Rating> getRatingsForUser(int userId) {
        List<Rating> userRatings = new ArrayList<>();
        for (Rating rating : ratings) {
            if (rating.userId() == userId) {
                userRatings.add(rating);
            }
        }
        return userRatings;
    }
}
