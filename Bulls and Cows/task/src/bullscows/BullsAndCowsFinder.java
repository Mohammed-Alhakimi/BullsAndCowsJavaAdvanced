package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BullsAndCowsFinder {
    private Scanner scanner = new Scanner(System.in);
    private int counterForTurns = 1;
    private int cows = 0;
    private int bulls = 0;
    private String random;
    private String[] arrayPassed;
    private final ArrayList<String> arrayListOfRandom = new ArrayList<>();

    public BullsAndCowsFinder(String random) {
            this.random = random;
            this.arrayPassed = random.split("");
            Collections.addAll(this.arrayListOfRandom, this.arrayPassed);
            startGame();
    }
    private void startGame() {
        System.out.println("Okay, let's start a game!");
        boolean hasWon = false;
        while (!hasWon) {
            cows = 0;
            bulls = 0;
            System.out.println("Turn :" + counterForTurns);
            String guess = scanner.next();
            String[] arrayOfGuess = guess.split("");
            ArrayList<String> arrayListOfGuess = new ArrayList<>();
            Collections.addAll(arrayListOfGuess, arrayOfGuess);
            for (int i = 0; i < arrayListOfGuess.size(); i++) {
                if (arrayListOfGuess.get(i).equals(arrayListOfRandom.get(i))) {
                    bulls++;
                } else if (arrayListOfRandom.contains(arrayListOfGuess.get(i))) {
                    cows++;
                }
            }
            if (cows > 0 && bulls > 0) {
                System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
            } else if (cows > 0) {
                System.out.println("Grade: " + cows + " cow(s).");
            } else if (bulls > 0) {
                System.out.println("Grade: " + bulls + " bull(s).");
            } else {
                System.out.println("Grade: None.");
            }
            counterForTurns++;
            if (bulls == arrayListOfRandom.size()) {
                hasWon = true;
                System.out.println("Congratulations! You guessed the secret code.");
            }
        }
    }
}