package pl.joanna.bednarczyk.advent.of.code.day_one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TheMostCaloriesSeeker {
    public static final String INPUT_PATH = "input/dayOneFirstTask.txt";
    public static final List<Integer> carriedCalories = carriedCalories();

    private int theMostCalories;
    private int totalOfTopThree;

    public TheMostCaloriesSeeker(){
        this.theMostCalories = findMaxCalories(carriedCalories);
        this.totalOfTopThree = calculateTotalOfTopThree(carriedCalories);
    }

    private static List<Integer> carriedCalories(){
        List<Integer> carriedCalories = new ArrayList<>();

        try(BufferedReader fileReader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String line;
            int tempSum = 0;
            while((line = fileReader.readLine()) != null){
                if(!line.equals("")){
                   tempSum += Integer.parseInt(line);
                }else {
                    carriedCalories.add(tempSum);
                    tempSum = 0;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return carriedCalories;
    }

    private int findMaxCalories(List<Integer> carriedCalories){
        int max = 0;
        for (int value : carriedCalories) {
            if(value > max){
                max = value;
            }
        }

        return max;
    }

    private int calculateTotalOfTopThree(List<Integer> carriedCalories){
        int sumOfTopThree = 0;
        Collections.sort(carriedCalories, Collections.reverseOrder());

        sumOfTopThree = carriedCalories.get(0) + carriedCalories.get(1) + carriedCalories.get(2);

        return sumOfTopThree;
    }

    public int getTheMostCalories() {
        return theMostCalories;
    }

    public int getTotalOfTopThree() {
        return totalOfTopThree;
    }
}
