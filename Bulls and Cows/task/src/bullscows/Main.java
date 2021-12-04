package bullscows;

public class Main {
//JetBrainsAcademy
    public static void main(String[] args) {
        RandomGenerator rg = new RandomGenerator();
        rg.generateRandom();
        BullsAndCowsFinder finder = new BullsAndCowsFinder(rg.getRandomGenerated());
    }
}
