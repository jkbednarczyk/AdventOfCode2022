package pl.joanna.bednarczyk.advent.of.code.day_05;

public class MoveInstruction {
    private int howMany;
    private int from;
    private int to;

    public MoveInstruction(int howMany, int from, int to) {
        this.howMany = howMany;
        this.from = from;
        this.to = to;
    }

    public int getHowMany() {
        return howMany;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "howMany=" + howMany +
                ", from=" + from +
                ", to=" + to;
    }
}
