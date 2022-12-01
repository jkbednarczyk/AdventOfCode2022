import day_one.TheMostCaloriesSeeker;

public class App {
    public static void main(String[] args) {
        System.out.println("Advent of Code 2022!");

        System.out.println("Day One:");

        TheMostCaloriesSeeker seeker = new TheMostCaloriesSeeker();
        System.out.println("Part 1: " + seeker.getTheMostCalories());
        System.out.println("Part 2: " + seeker.getTotalOfTopThree());


    }
}
