package pl.joanna.bednarczyk.advent.of.code.day_two;



import pl.joanna.bednarczyk.advent.of.code.tools.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
    Rock defeats Scissors,
    Scissors defeats Paper, and
    Paper defeats Rock.
    If both players choose the same shape, the round instead ends in a draw.

    A for Rock,
    B for Paper, and
    C for Scissors

    X for Rock,
    Y for Paper, and
    Z for Scissors

    (1 for Rock, 2 for Paper, and 3 for Scissors)
    plus the score for the outcome of the round
    (0 if you lost, 3 if the round was a draw, and 6 if you won)
 */
public class RockPaperScissors {
    private static final String INPUT_PATH = "input/dayTwo.txt";
    private static final String ELF_ROCK = "A";
    private static final String ELF_PAPER = "B";
    private static final String ELF_SCISSORS = "C";
    private static final String ROCK = "X";
    private static final String PAPER = "Y";
    private static final String SCISSORS = "Z";
    private final int score;

    public RockPaperScissors() {
        this.score = calculateTotalScore(getInput());
    }

    private List<Pair<String, String>> getInput() {
        List<Pair<String, String>> playStrategy = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] movesFromFile = line.split(" ");
                Pair<String, String> moves = new Pair<>(movesFromFile[0], movesFromFile[1]);
                playStrategy.add(moves);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return playStrategy;
    }

    private int pointsForYourMove(Pair<String, String> pair) {
        int points;
        String yourMove = pair.getSecond();
        if (yourMove.equals(ROCK)) {
            points = 1;
        } else if (yourMove.equals(PAPER)) {
            points = 2;
        } else {
            points = 3;
        }
        return points;
    }

    private int pointsForDuel(Pair<String, String> pair) {
        int points;
        String elfMove = pair.getFirst();
        String yourMove = pair.getSecond();

        if (isDraw(elfMove, yourMove)) {
            points = 3;
        } else if (didElfWon(elfMove, yourMove)) {
            points = 0;
        } else {
            points = 6;
        }

        return points;
    }

    private boolean isDraw(String elfMove, String yourMove){
        return elfMove.equals(ELF_ROCK) && yourMove.equals(ROCK) ||
                elfMove.equals(ELF_PAPER) && yourMove.equals(PAPER) ||
                elfMove.equals(ELF_SCISSORS) && yourMove.equals(SCISSORS);
    }

    private boolean didElfWon(String elfMove, String yourMove){
        return elfMove.equals(ELF_ROCK) && yourMove.equals(SCISSORS) ||
                elfMove.equals(ELF_SCISSORS) && yourMove.equals(PAPER) ||
                elfMove.equals(ELF_PAPER) && yourMove.equals(ROCK);
    }

    private int calculateTotalScore(List<Pair<String, String>> strategy) {
        int totalScore = 0;
        for (Pair<String, String> pair : strategy) {
            totalScore += pointsForDuel(pair);
            totalScore += pointsForYourMove(pair);
        }

        return totalScore;
    }


    public int getScore() {
        return score;
    }
}
