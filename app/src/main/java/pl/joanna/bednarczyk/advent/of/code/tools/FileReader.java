package pl.joanna.bednarczyk.advent.of.code.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
public class FileReader {
    private final String inputPath;
    private final List<String> inputFromFile;

    public FileReader(String inputPath) {
        this.inputPath = inputPath;
        this.inputFromFile = readData(inputPath);
    }

    private List<String> readData(String inputPath){
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new java.io.FileReader(inputPath))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                dataFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataFromFile;
    }

    public List<String> getInputFromFile() {
        return inputFromFile;
    }
}
