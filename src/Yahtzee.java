import java.util.ArrayList;
import java.util.List;

public class Yahtzee {
    private static final List<Integer> heldDice = new ArrayList<>();
    private static final List<Integer> playerScores = new ArrayList<>();

    public static void addHeldDice(int dice) {
        heldDice.add(dice);
    }

    public static void removeHeldDice(int index) {
        heldDice.remove(index);
    }

    public static List<Integer> getHeldDice() {
        return heldDice;
    }

    public static void clearHeldDice() {
        heldDice.clear();
    }

    public static List<Integer> rollDice(int numDice) {
        List<Integer> dice = new ArrayList<>();
        for (int i = 0; i < numDice; i++) {
            dice.add((int) (Math.random() * 6) + 1);
        }
        return dice;
    }

    // order of rolls: 1s, 2s, 3s, 4s, 5s, 6s, 3 of a kind, 4 of a kind, full house, small straight, large straight, yahtzee, chance
    // prepopulate playerScores with 0s
    public static void resetScore() {
        for (int i = 0; i < 13; i++) {
            playerScores.add(0);
        }
    }

    //evaluate scores for player. return list<string> of possible scores.
    //do not add scores already claimed to list
    public static List<String> options(List<Integer> rolls) {
        List<String> options = new ArrayList<>();
        int[] counts = new int[6];
        for (Integer roll : rolls) {
            counts[roll - 1]++;
        }
        for (int count : counts) {
            if (count == 3) {
                options.add("3 of a kind");
            }
            if (count == 4) {
                options.add("4 of a kind");
            }
            if (count == 5) {
                options.add("yahtzee");
            }
        }
        if (counts[0] > 0 && counts[1] > 0 && counts[2] > 0 && counts[3] > 0) {
            options.add("small straight");
        }
        if (counts[1] > 0 && counts[2] > 0 && counts[3] > 0 && counts[4] > 0) {
            options.add("small straight");
        }
        if (counts[2] > 0 && counts[3] > 0 && counts[4] > 0 && counts[5] > 0) {
            options.add("small straight");
        }
        if (counts[0] > 0 && counts[1] > 0 && counts[2] > 0 && counts[3] > 0 && counts[4] > 0) {
            options.add("large straight");
        }
        if (counts[1] > 0 && counts[2] > 0 && counts[3] > 0 && counts[4] > 0 && counts[5] > 0) {
            options.add("large straight");
        }
        if (counts[0] > 0 && counts[1] > 0 && counts[2] > 0 && counts[3] > 0 && counts[4] > 0 && counts[5] > 0) {
            options.add("full house");
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                options.add((i + 1) + "s");
            }
        }
        options.add("chance");
        return options;
    }

    public static void addScore(String option, List<Integer> heldDice) {
        String[] options = {"1s", "2s", "3s", "4s", "5s", "6s", "3 of a kind", "4 of a kind", "full house", "small straight", "large straight", "yahtzee", "chance"};

    }
}
