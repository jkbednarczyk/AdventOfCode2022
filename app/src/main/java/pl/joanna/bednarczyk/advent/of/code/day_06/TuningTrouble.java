package pl.joanna.bednarczyk.advent.of.code.day_06;

import pl.joanna.bednarczyk.advent.of.code.tools.FileReader;

public class TuningTrouble {
    private static final String INPUT_PATH = "input/day_06.txt";

    private int markersEnd;

    public TuningTrouble(){
        char[] input = getInput();
        this.markersEnd = findEndOfMarker(input);
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

    private boolean hasMarkerOccurred(char a, char b, char c, char d){
        return a != b && a != c && a != d &&
                b != c && b != d &&
                c != d;
    }

    public int getMarkersEnd() {
        return markersEnd;
    }
}
