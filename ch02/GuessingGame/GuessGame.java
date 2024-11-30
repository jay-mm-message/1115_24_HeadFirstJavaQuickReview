package ch02.GuessingGame;

import java.util.Random;

public class GuessGame {
   public void startGame() {
        Random random = new Random();
        Boolean guessStart = true;
        int guessNum = random.nextInt(9);
        String winner = new String("Guess number: " + guessNum + ", Winner is: ");

        while(guessStart) {
            Player p1 = new Player();
            Player p2 = new Player();
            Player p3 = new Player();

            if (guessNum == p1.guess()) {
                guessStart = false;
                winner += "P1";
            } else if (guessNum == p2.guess()) {
                guessStart = false;
                winner += "P2";
            } else if (guessNum == p3.guess()) {
                guessStart = false;
                winner += "P3";
            }

            System.out.println("Again guess.");
        }
        System.out.println("Game over, " + winner);
   } 
}
