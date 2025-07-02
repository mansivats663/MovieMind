import java.util.List;
import java.util.Scanner;

public class Main {
    private final MovieDatabase movieDatabase;
    private final UserDatabase userDatabase;
    private final Recommender recommender;
    private final Scanner scanner;

    public Main() {
        movieDatabase = new MovieDatabase();
        userDatabase = new UserDatabase();
        recommender = new Recommender(movieDatabase, userDatabase);
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the Moviemind!");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // newline consume krne ke liye

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        user user = userDatabase.authenticateUser(username, password);
        if (user != null) {
            System.out.println("Login successful!");
            userMenu(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        user user = new user(userDatabase.users.size() + 1, username, password);
        userDatabase.addUser(user);
        System.out.println("Registration successful!");
    }

    private void userMenu(user user) {
        while (true) {
            System.out.println("1. View movies");
            System.out.println("2. Rate a movie");
            System.out.println("3. Get recommendations");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); //  newline consume krne ke liye

            switch (option) {
                case 1:
                    viewMovies();
                    break;
                case 2:
                    rateMovie(user);
                    break;
                case 3:
                    getRecommendations(user);
                    break;
                case 4:
                    System.out.println("Logout successful!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void viewMovies() {
        List<Movie> movies = movieDatabase.getMovies();
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
    }

    private void rateMovie(user user) {
        System.out.print("Enter movie ID: ");
        int movieId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter rating (1-5): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        Rating movieRating = new Rating(user.id(), movieId, rating);
        userDatabase.addRating(movieRating);
        System.out.println("Rating added successfully!");
    }

    private void getRecommendations(user user) {
        List<Movie> recommendedMovies;
        recommendedMovies = recommender.recommendMovies(user.id());
        for (Movie movie : recommendedMovies) {
            System.out.println(movie.getTitle());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}

