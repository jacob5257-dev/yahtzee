import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Yahtzee game
        Method calls:
        rollDice(int numDice): Rolls the specified number of dice.
        addHeldDice(int dice): Adds the specified dice to the list of held dice.
        removeHeldDice(int index): Removes the specified dice from the list of held dice.
        getHeldDice(): Returns the list of held dice.
        clearHeldDice(): Clears the list of held dice.

         */


        Scanner scanner = new Scanner(System.in);
        Yahtzee.resetScore();
        for (int run = 0; run < 13; run++) {
            int dice = 5;
            Yahtzee.clearHeldDice();
            for (int roll = 0; roll < 3; roll++) {
                List<Integer> rolledDice = Yahtzee.rollDice(dice);
                System.out.println("You rolled: " + rolledDice);

                System.out.print("Which dice would you like to hold? (Enter the index of the dice you want to hold): ");
                String input = scanner.nextLine();
                for (int i = 0; i < input.length(); i++) {
                    char number = input.charAt(i);
                    int index = 0;
                    try {
                        index = Character.getNumericValue(number) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                        System.exit(0);
                    }
                    try {
                        Yahtzee.addHeldDice(rolledDice.get(index));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid input.");
                        System.exit(0);
                    }
                    dice--;
                }

                System.out.println("You held: " + Yahtzee.getHeldDice());

                if (roll == 2) {
                    for (int i = 0; i < dice; i++) {
                        Yahtzee.addHeldDice(rolledDice.get(i));
                    }
                    System.out.println("Select one of the following options: " + Yahtzee.options(Yahtzee.getHeldDice()));
                    System.out.print("Enter the option you want to choose: ");
                    String option = scanner.nextLine();
                    int selection = 0;
                    try {
                        selection = Integer.parseInt(option);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                        System.exit(0);
                    }
                    Yahtzee.addScore(Yahtzee.options(Yahtzee.getHeldDice()).get(selection - 1), Yahtzee.getHeldDice());
                }
            }
        }
    }
}