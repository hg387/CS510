package main.resources;

import java.util.ArrayList;
import java.util.List;

public class State {
    private ArrayList<List<Integer>> matrix;

    public State(ArrayList<List<Integer>> matrix){
        this.matrix = matrix;
    }

    public ArrayList<List<Integer>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<List<Integer>> matrix) {
        this.matrix = matrix;
    }

    public boolean evaluate(){
        ArrayList<List<Integer>> matrix = this.matrix;
        boolean counter = true;

        Integer rows = matrix.size();
        Integer columns = matrix.get(0).size();
        for (Integer row=0; row < rows; row++){
            for (Integer column =0; column < columns; column++){
                if (matrix.get(row).get(column) == -1){
                    counter = false;
                }
            }
        }

        return counter;
    }
}
