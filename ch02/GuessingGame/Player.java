package ch02.GuessingGame;

import java.util.Random;

public class Player {
    public int guess() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
