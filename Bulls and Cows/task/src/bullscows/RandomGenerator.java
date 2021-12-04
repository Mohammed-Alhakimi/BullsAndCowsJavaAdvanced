package bullscows;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//JetBrainsAcademy
public class RandomGenerator {
    private Scanner s = new Scanner(System.in);
    private Random random = new Random();
    private int lengthOfRandom;
    private String randomGenerated;
    private static final String setOfCharacters = "0123456789abcdefghijklmnopqrstuvwxyz";
    private final ArrayList<Object> arrayListUniqueDigits = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public String getRandomGenerated() {
        return randomGenerated;
    }
    public RandomGenerator() {

    }
    public void generateRandom() {
        System.out.println("Input the length of the secret code:");
        try {
            this.lengthOfRandom = s.nextInt();
            if(lengthOfRandom==0){
                System.out.println("Error : You can't create a code without a length");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            String inputString = s.next();
            System.out.println("Error: \"" + inputString + "\" isn't a valid number.");
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        int possibleSymbols = s.nextInt();
        if (possibleSymbols < 37) {
            if(possibleSymbols<lengthOfRandom){
                System.out.println("Error!! Can't generate a code with a length of "+lengthOfRandom+" because there isn't enough unique digits!");
                System.exit(0);
            }else{
                for (int i = 0; i < lengthOfRandom; i++) {
                    int randomInt = random.nextInt(((possibleSymbols)));
                    char oneRandomChar = setOfCharacters.charAt(randomInt);
                    if (arrayListUniqueDigits.contains(oneRandomChar)) {
                        i--;
                    } else {
                        arrayListUniqueDigits.add(oneRandomChar);
                    }
                }
                for (Object i : arrayListUniqueDigits
                ) {
                    sb.append(i);
                }
                randomGenerated = sb.toString();
                checkForRange(possibleSymbols);
            }

        } else {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }

    }
    private void  checkForRange(int length) {
        String totalRange;
        if (length < 11) {
            totalRange = " (0" + "-" + setOfCharacters.charAt(length - 1) + ").";
            System.out.println("The secret is prepared: " + "*".repeat(lengthOfRandom) + totalRange);
        } else if (length == 11) {
            totalRange = " (0-9, " + "a).";
            System.out.println("The secret is prepared: " + "*".repeat(lengthOfRandom) + totalRange);
        } else if (length < 37) {
            totalRange = " (0-9, " + "a-" + setOfCharacters.charAt(length - 1) + ").";
            System.out.println("The secret is prepared: " + "*".repeat(lengthOfRandom) + totalRange);
        }
    }
}