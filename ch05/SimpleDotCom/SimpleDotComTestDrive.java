package ch05.SimpleDotCom;

import java.util.Scanner;

public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        /*
         * Extreme Programming
         * SimpleDotCom dot = new SimpleDotCom();
         * int [] locations = {2, 3, 4};
         * dot.setLocationCells(locations);
         * String userGuess = "2";
         * String result = dot.checkYourself(userGuess);
         */

        SimpleDotCom simpleDotCom = new SimpleDotCom();
        int num = (int) Math.random() * 5;
        int [] locationCells = {num, num + 1, num + 2};
        simpleDotCom.setLocationCells(locationCells);

        int times = 0;
        String result;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Enter a number: ");
                String userGuess = scanner.nextLine();
                result = simpleDotCom.checkYourself(userGuess);
                System.out.print("Guess:" + userGuess);
                System.out.println(", Result:" + result);
                times = times + 1;
            } while(!result.equals("Kill"));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("You took " + times + " guesses");
    }
}
