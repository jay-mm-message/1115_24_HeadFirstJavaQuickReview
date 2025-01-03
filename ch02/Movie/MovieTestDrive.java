package ch02.Movie;

public class MovieTestDrive {
    public static void main(String [] args) {
        Movie one = new Movie();
        one.title = "Gone with the Stock";
        one.genre = "Tragic";
        one.rating = -2;

        Movie two = new Movie();
        two.title = "Lost in Cubicle Space";
        two.genre = "Comedy";
        two.rating = 5;

        Movie three = new Movie();
        three.title = "Byte Club";
        three.genre = "Tragic but ultimately uplifting";
        three.rating = 127;

        one.playIt();
        one.showMovieInfo();
        
        two.playIt();
        two.showMovieInfo();

        three.playIt();
        three.showMovieInfo();
    }
}
