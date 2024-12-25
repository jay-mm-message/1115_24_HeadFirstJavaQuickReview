package ch16.Jukebox2;

public class Song {
    private String title;
    private String artist;
    private String rating;
    private String bpm;

    public Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }
    public String toString() {
        return title;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getBpm() {
        return bpm;
    }
    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

}
