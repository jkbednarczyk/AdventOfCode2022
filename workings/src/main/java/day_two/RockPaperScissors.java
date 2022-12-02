package day_two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import tools.Pair;

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
    private int score;

    public RockPaperScissors() {
    }

    private List<Pair<String, String>> getInput(){
        List<Pair<String, String>> playStrategy = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String line;
            while((line = fileReader.readLine()) != null){
                String[] movesFromFile = line.split(" ");
                Pair<String, String> moves = new Pair<>(movesFromFile[0], movesFromFile[1]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return playStrategy;
    }

    public int getScore() {
        return score;
    }
}
