package ch02.DVDPlayer;

/**
 * The DVDPlayer class represents a DVD player that can play and record DVDs.
 * It contains methods to simulate playing and recording DVDs.
 */
public class DVDPlayer {

    /**
     * Indicates whether the DVD player can record DVDs.
     * Default value is false, meaning the player cannot record.
     */
    boolean canRecord = false;

    /**
     * Simulates playing a DVD.
     * Prints a message to the console indicating that the DVD is playing.
     */
    void playDVD() {
        System.out.println("DVD playing");
    }

    /**
     * Simulates recording a DVD.
     * Prints a message to the console indicating that the DVD is being recorded.
     */
    void recordDVD() {
        System.out.println("DVD recording");
    }
}
