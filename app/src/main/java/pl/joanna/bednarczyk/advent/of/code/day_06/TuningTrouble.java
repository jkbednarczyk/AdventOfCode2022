package pl.joanna.bednarczyk.advent.of.code.day_06;

import pl.joanna.bednarczyk.advent.of.code.tools.FileReader;

import java.util.HashSet;
import java.util.Set;

public class TuningTrouble {
    private static final String INPUT_PATH = "input/day_06.txt";

    private int markersEnd;
    private int messageMarkerBeginning;

    public TuningTrouble(){
        char[] input = getInput();
        this.markersEnd = findEndOfMarker(input);
        this.messageMarkerBeginning = findBeginningOfMessageMarker(input);
    }


    private char[] getInput(){
        FileReader reader = new FileReader(INPUT_PATH);
        String input = reader.getInputFromFile().get(0);

        return input.toCharArray();
    }

    private int findEndOfMarker(char[] input){
        int endOfMarker = 0;
        for(int i = 3; i < input.length; i++){
            if(hasMarkerOccurred(input[i - 3], input[i - 2], input[i - 1], input[i])){
                return i + 1;
            }
        }

        return endOfMarker;
    }

    private int findBeginningOfMessageMarker(char[] input) {
        int beginningOfMarker = 0;
        for(int i = 13; i < input.length; i++){
            Set<Character> setOfChars = new HashSet<>();
            for(int j = i - 13; j <= i; j++){
                setOfChars.add(input[j]);
            }
            if (setOfChars.size() == 14){
                return i + 1;
            }
        }

        return beginningOfMarker;
    }

    private boolean hasMarkerOccurred(char a, char b, char c, char d){
        return a != b && a != c && a != d &&
                b != c && b != d &&
                c != d;
    }

    public int getMarkersEnd() {
        return markersEnd;
    }

    public int getMessageMarkerBeginning() {
        return messageMarkerBeginning;
    }
}
