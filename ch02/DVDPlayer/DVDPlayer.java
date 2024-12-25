package ch02.DVDPlayer;

public class DVDPlayer {

    /**
     * Constructor and initialization a record state on DVD player
     * @param canRecord canRecord is a record state
     */
    boolean canRecord = false;

    /**
     * The method will show that DVD state
     * @return It will show that DVD is playing
     */
    void playDVD() {
        System.out.println("DVD playing");
    }

    /**
     * The method will show that DVD state
     * @return It will show that DVD is recording
     */
    void recordDVD() {
        System.out.println("DVD recording");
    }
}
