package pl.joanna.bednarczyk.advent.of.code.day_04;

import pl.joanna.bednarczyk.advent.of.code.tools.FileReader;
import pl.joanna.bednarczyk.advent.of.code.tools.Pair;
import java.util.*;

public class CampCleanup {
    private static final String INPUT_PATH = "input/day_04.txt";
    private int numberOfOverlaps;

    public CampCleanup(){
        this.numberOfOverlaps = countOverlaps(getPairRanges());
    }

    private List<Pair<String, String>> getPairRanges(){
        FileReader reader = new FileReader(INPUT_PATH);
        List<String> inputFromFile = reader.getInputFromFile();
        List<Pair<String, String>> pairs = new ArrayList<>();

        for(String line : inputFromFile){
            String[] rawInput = line.split(",");
            Pair<String, String> singlePair = new Pair<>(rawInput[0], rawInput[1]);
            pairs.add(singlePair);
        }

        return pairs;
    }

    private int countOverlaps(List<Pair<String, String>> pairList){
        int sum = 0;
        for(Pair<String, String> pair : pairList){
            String firstRange = pair.getFirst();
            String secondRange = pair.getSecond();

        }

        return sum;
    }
    public int getNumberOfOverlaps() {
        return numberOfOverlaps;
    }
}
