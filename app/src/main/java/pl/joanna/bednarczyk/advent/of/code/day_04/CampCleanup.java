package pl.joanna.bednarczyk.advent.of.code.day_04;

import pl.joanna.bednarczyk.advent.of.code.tools.FileReader;
import pl.joanna.bednarczyk.advent.of.code.tools.Pair;
import java.util.*;

public class CampCleanup {
    private static final String INPUT_PATH = "input/day_04.txt";
    private int numberOfFullyContained;
    private int numberOfOverlaps;

    public CampCleanup(){
        this.numberOfFullyContained = countFullyContainedRanges(getPairRanges());
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

    private int countFullyContainedRanges(List<Pair<String, String>> pairList){
        int sum = 0;
        for(Pair<String, String> pair : pairList){
            String firstRange = pair.getFirst();
            String secondRange = pair.getSecond();
            if(isRangeFullyContainedByOther(firstRange, secondRange)){
                sum++;
            }
        }

        return sum;
    }

    private boolean isRangeFullyContainedByOther(String firstRange, String secondRange){
        Pair<Integer, Integer> firstAsNumbers = transformRangeToNumericValues(firstRange);
        Pair<Integer, Integer> secondAsNumbers = transformRangeToNumericValues(secondRange);

        return (firstAsNumbers.getFirst() <= secondAsNumbers.getFirst() &&
                firstAsNumbers.getSecond() >= secondAsNumbers.getSecond()) ||
                (secondAsNumbers.getFirst() <= firstAsNumbers.getFirst() &&
                secondAsNumbers.getSecond() >= firstAsNumbers.getSecond());
    }

    private Pair<Integer, Integer> transformRangeToNumericValues(String range){
        String[] rawRange = range.split("-");
        return new Pair<>(Integer.parseInt(rawRange[0]), Integer.parseInt(rawRange[1]));
    }
    public int getNumberOfFullyContained() {
        return numberOfFullyContained;
    }

    public int getNumberOfOverlaps() {
        return numberOfOverlaps;
    }
}
