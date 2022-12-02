package day_two;


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

    private int score;

    public RockPaperScissors() {
    }

    public int getScore() {
        return score;
    }
}
