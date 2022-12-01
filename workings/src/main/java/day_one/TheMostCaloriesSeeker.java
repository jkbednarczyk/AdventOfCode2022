package day_one;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TheMostCaloriesSeeker {
    public static final String INPUT_PATH = "input/dayOneFirstTask.txt";

    private int theMostCalories;

    public TheMostCaloriesSeeker(){
        this.theMostCalories = findMaxCalories(carriedCalories());
    }

    private List<Integer> carriedCalories(){
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

    public int getTheMostCalories() {
        return theMostCalories;
    }
}
