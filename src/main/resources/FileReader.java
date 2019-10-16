package main.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    public static ArrayList<List<Integer>> fileReader(String fileName) throws IOException{
        ArrayList<List<Integer>> matrix = new ArrayList<>();

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))){
            String inValue;
            while ((inValue = reader.readLine()) != null){
                String[] array = inValue.split(",");
                Integer[] row = Arrays.stream(array).map(Integer::valueOf).toArray(Integer[]::new);
                matrix.add(Arrays.asList(row));
            }
        }
        catch(IOException e){
            System.out.println("Exception Thrown : "  + e);
        }

        return new ArrayList<List<Integer>>(matrix.subList(1, matrix.size()));
    }
}
