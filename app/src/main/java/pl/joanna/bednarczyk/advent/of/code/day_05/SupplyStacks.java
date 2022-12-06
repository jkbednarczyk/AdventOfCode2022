package pl.joanna.bednarczyk.advent.of.code.day_05;

import pl.joanna.bednarczyk.advent.of.code.tools.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SupplyStacks {
    private static final String INPUT_PATH = "input/day_05.txt";
    private static final int NUMBER_OF_STACKS = 9;
    private static final int INITIAL_HEIGHT_OF_STACKS = 8;
    private static final int CHARS_IN_INPUT = 35;

    private String topOfStacks;

    public SupplyStacks(){
        List<Stack<String>> initialStateOfStacks = getInitialStateOfStacks(readInput());
    }

    private static List<String> readInput(){
        FileReader reader = new FileReader(INPUT_PATH);
        return reader.getInputFromFile();
    }

    private List<Stack<String>> getInitialStateOfStacks(List<String> input){
        char[][] inputInArray = putStacksInArray(input);

        return constructStacks(inputInArray);
    }

    private static List<Stack<String>> constructStacks(char[][] inputInArray) {
        List<Stack<String>> initialStateOfStacks = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_STACKS; i++){
            Stack<String> stack = new Stack<>();
            for(int j = 0; j < INITIAL_HEIGHT_OF_STACKS; j++){
                String temp = "" + inputInArray[i][j];
                if (!temp.equals(" ")){
                    stack.push(temp);
                }
            }
            initialStateOfStacks.add(stack);
        }
        return initialStateOfStacks;
    }

    private static char[][] putStacksInArray(List<String> input) {
        char[][] inputInArray = new char[NUMBER_OF_STACKS][INITIAL_HEIGHT_OF_STACKS];
        String rawStack;

        for (int i = INITIAL_HEIGHT_OF_STACKS - 1; i >=0; i--){
            rawStack = "";
            String line = input.get(i);
            if(line.length() < CHARS_IN_INPUT){
                line = String.format("%-35s", line);
            }
            for (int j = 1; j < CHARS_IN_INPUT; j += 4){
                rawStack += line.substring(j, j +1);
            }
            char[] singleLine = rawStack.toCharArray();
            for (int k = 0; k < NUMBER_OF_STACKS; k++){
                inputInArray[k][i] = singleLine[k];
            }
        }
        return inputInArray;
    }


    public String getTopOfStacks() {
        return topOfStacks;
    }
}
