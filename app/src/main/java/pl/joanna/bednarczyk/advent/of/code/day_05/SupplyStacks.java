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

    private final String topOfStacksMover9000;
    private final String topOfStacksMover9001;

    public SupplyStacks(){
        List<String> fromFile = readInput();
        this.topOfStacksMover9000 = readStackTops(executeInstructionsMover9000(fromFile));
        this.topOfStacksMover9001 = readStackTops(executeInstructionsMover9001(fromFile));
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
        for(int i = NUMBER_OF_STACKS - 1; i >= 0; i--){
            Stack<String> stack = new Stack<>();
            for(int j = INITIAL_HEIGHT_OF_STACKS - 1; j >= 0; j--){
                String temp = "" + inputInArray[i][j];

                if (!temp.equals(" ")){
                    stack.push(temp);
                }
            }
            initialStateOfStacks.add(stack);
        }
        return reverseListOfStacks(initialStateOfStacks);
    }

    private static List<Stack<String>> reverseListOfStacks(List<Stack<String>> list){
        List<Stack<String>> output = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--){
            output.add(list.get(i));
        }

        return output;
    }

    private static char[][] putStacksInArray(List<String> input) {
        char[][] inputInArray = new char[NUMBER_OF_STACKS][INITIAL_HEIGHT_OF_STACKS];
        StringBuilder rawStack;

        for (int i = INITIAL_HEIGHT_OF_STACKS - 1; i >=0; i--){
            rawStack = new StringBuilder();
            String line = input.get(i);
            if(line.length() < CHARS_IN_INPUT){
                line = String.format("%-35s", line);
            }
            for (int j = 1; j < CHARS_IN_INPUT; j += 4){
                rawStack.append(line.charAt(j));
            }
            char[] singleLine = rawStack.toString().toCharArray();
            for (int k = 0; k < NUMBER_OF_STACKS; k++){
                inputInArray[k][i] = singleLine[k];
            }
        }
        return inputInArray;
    }

    private List<MoveInstruction> getInstructions(List<String> input){
        List<MoveInstruction> instructions = new ArrayList<>();
        for(int i = 10; i < input.size(); i++){
            String[] line = input.get(i).split(" ");
            instructions.add(new MoveInstruction(Integer.parseInt(line[1]), Integer.parseInt(line[3]), Integer.parseInt(line[5])));
        }

        return instructions;
    }

    private List<Stack<String>> executeInstructionsMover9000(List<String> inputFromFile){
        List<Stack<String>> initialStateOfStacks = getInitialStateOfStacks(inputFromFile);
        List<MoveInstruction> instructions = getInstructions(inputFromFile);

        for(MoveInstruction move : instructions){
            Stack<String> from = initialStateOfStacks.get(move.getFrom() - 1);
            Stack<String> to = initialStateOfStacks.get(move.getTo() - 1);

            for(int i = 0; i < move.getHowMany(); i++){
                String item = from.pop();
                to.push(item);
            }
            initialStateOfStacks.set(move.getFrom() - 1, from);
            initialStateOfStacks.set(move.getTo() - 1, to);

        }


        return initialStateOfStacks;
    }

    private List<Stack<String>> executeInstructionsMover9001(List<String> inputFromFile) {
        List<Stack<String>> initialStateOfStacks = getInitialStateOfStacks(inputFromFile);
        List<MoveInstruction> instructions = getInstructions(inputFromFile);

        for(MoveInstruction move : instructions){
            Stack<String> from = initialStateOfStacks.get(move.getFrom() - 1);
            Stack<String> to = initialStateOfStacks.get(move.getTo() - 1);

            String[] items = new String[move.getHowMany()];
            for(int i = 0; i < move.getHowMany(); i++){
                items[i] = from.pop();

            }
            for (int i = move.getHowMany() - 1; i >= 0; i--){
                to.push(items[i]);
            }

            initialStateOfStacks.set(move.getFrom() - 1, from);
            initialStateOfStacks.set(move.getTo() - 1, to);

        }


        return initialStateOfStacks;
    }

    private String readStackTops(List<Stack<String>> afterRearrangement){
        String output = "";
        for(Stack<String> stack : afterRearrangement){
            output += stack.peek();
        }

        return output;
    }

    public String getTopOfStacksMover9000() {
        return topOfStacksMover9000;
    }

    public String getTopOfStacksMover9001() {
        return topOfStacksMover9001;
    }
}
