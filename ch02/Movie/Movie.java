package ch02.Movie;

public class Movie {
    String title;
    String genre;
    int rating;

    void playIt() {
        System.out.println("Playing the movie");
    }

    void showMovieInfo() {
        System.out.printf("Title: " );
        System.out.println(this.title);
        System.out.printf("Genre: ");
        System.out.println(this.genre);
        System.out.printf("Rating: ");
        System.out.println(this.rating);
    }
}