package ch05.SimpleDotCom2;

import java.util.Scanner;

public class SimpleDotComTestDrive {
    public static void prompt(String s) {
        System.out.print(s);
    }

    public static void main(String[] args) {

        /*
         * Extreme Programming
         * SimpleDotCom dot = new SimpleDotCom();
         * int [] locations = {2, 3, 4};
         * dot.setLocationCells(locations);
         * String userGuess = "2";
         * String result = dot.checkYourself(userGuess);
         */

        /*
         *  Declare int [] locationCells = new locationCells[3];
         * 
         *  randomly draw three numbers from 0 to 5 and
         *  put them into locationCells.
         *  for(int i = 0 ; i < locationCells.length ; ++i) {
         *      locationCells[i] = (int) Math.random() * 5;
         *  }
         *  Declare:  SimpleDotCom dot = new SimpleDotCom();
         *      set:    dot.setLocationCells(locationCells);
         *  
         *  String shipAlive;
         *  try (Scanner sc = new Scanner(System.in)) {
         *      do {
         *          prompt("user guess:");
         *          shipAlive = dot.checkYourself(sc.nextLine());
         *      } while (ship is killed);
         *  } catch(Exception e) {
         *      prompt(e);
         *  }
         *
         */

        SimpleDotCom simpleDotCom = new SimpleDotCom();
        int num = (int) Math.random() * 5;
        int [] locationCells = {num, num + 1, num + 2};
        simpleDotCom.setLocationCells(locationCells);

        int times = 0;
        String result;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                prompt("Enter a number: ");
                String userGuess = scanner.nextLine();
                result = simpleDotCom.checkYourself(userGuess);
                prompt("Guess:" + userGuess);
                prompt(", Result:" + result + "\n");
                times = times + 1;
            } while(!result.equals("Kill"));
        } catch (Exception e) {
            prompt(e.toString());
            prompt("\n");
        }
        System.out.println("You took " + times + " guesses");
    }
}
