package pl.joanna.bednarczyk.advent.of.code.day_03;

import pl.joanna.bednarczyk.advent.of.code.tools.FileReader;
import pl.joanna.bednarczyk.advent.of.code.tools.Pair;

import java.util.*;

/*
    Lowercase item types a through z have priorities 1 through 26.
    Uppercase item types A through Z have priorities 27 through 52.

    a - z in ASCII 97 - 122
    A - Z in ASCII 65 - 90
 */

public class RucksackReorganization {
    private static final String INPUT_PATH = "input/day_03.txt";
    private final int sumOfPriorities;
    private final int sumOfBadgesPriorities;

    public RucksackReorganization() {
        this.sumOfPriorities = calculatePriorities(getCompartments());
        this.sumOfBadgesPriorities = calculateBadgesPriorities(getRucksacks());
    }

    private List<Pair<String, String>> getCompartments(){
        FileReader reader = new FileReader(INPUT_PATH);
        List<String> contentOfRucksack = reader.getInputFromFile();
        List<Pair<String, String>> rucksacks = new ArrayList<>();

        for(String content : contentOfRucksack){
            int capacityOfCompartment = content.length() / 2;
            Pair<String, String> compartments = new Pair<>(content.substring(0,capacityOfCompartment),
                                                            content.substring(capacityOfCompartment));
            rucksacks.add(compartments);
        }
        return rucksacks;
    }

    private String[] getRucksacks(){
        FileReader reader = new FileReader(INPUT_PATH);
        List<String> contentOfRucksack = reader.getInputFromFile();
        String[] rucksacks = new String[contentOfRucksack.size()];

        int iterator = 0;

        for(String rucksack : contentOfRucksack){
            rucksacks[iterator] = rucksack;
            iterator++;
        }

        return rucksacks;
    }

    private int calculatePriorities(List<Pair<String, String>> rucksacks){
        int sum = 0;
        for(Pair<String, String> pair : rucksacks){
            sum += calculatePrioritiesForSingleRucksack(pair.getFirst(), pair.getSecond());
        }

        return sum;
    }

    private int calculatePrioritiesForSingleRucksack(String firstCompartment, String secondCompartment){
        int sum = 0;
        char[] firstAsArray = firstCompartment.toCharArray();
        char[] secondAsArray = secondCompartment.toCharArray();
        char repeat = findRepeat(firstAsArray, secondAsArray);
        sum += getPriority(repeat);

        return sum;
    }

    private char findRepeat(char[] firstAsArray, char[] secondAsArray) {
        char repeat = '&';
        for(int i = 0; i < firstAsArray.length; i++){
            char item = firstAsArray[i];
            for(int j = 0; j < secondAsArray.length; j++){
                if(item == secondAsArray[j]){
                    return item;
                }
            }
        }
        return repeat;
    }

    private int getPriority(char letter){
        int decValueInAscii = (int)letter;
        if(decValueInAscii <= 90){
            return decValueInAscii - 38;
        }else {
            return decValueInAscii - 96;
        }
    }

    private int calculateBadgesPriorities(String[] rucksacks){
        int sum = 0;
        for(int i = 0; i < rucksacks.length ; i = i + 3){
            sum += getPriority(findBadge(rucksacks[i], rucksacks[i + 1], rucksacks[i + 2]));
        }

        return sum;
    }

    private char findBadge(String firstRucksack, String secondRucksack,String thirdRucksack){
        char badge = '&';
        for(int i = 0; i < firstRucksack.length(); i++){
            char item = firstRucksack.charAt(i);
            for (int j = 0; j < secondRucksack.length(); j++){
                if(item == secondRucksack.charAt(j)){
                    for (int k = 0; k < thirdRucksack.length(); k++){
                        if (item == thirdRucksack.charAt(k)){
                            return item;
                        }
                    }
                }
            }
        }

        return badge;
    }

    public int getSumOfPriorities() {
        return sumOfPriorities;
    }

    public int getSumOfBadgesPriorities() {
        return sumOfBadgesPriorities;
    }
}
