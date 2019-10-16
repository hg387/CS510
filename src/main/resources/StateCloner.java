package main.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StateCloner {
    private State duplicateState;

    public StateCloner(State s){
        ArrayList<List<Integer>> matrix = s.getMatrix();
        ArrayList<List<Integer>> duplicateMatrix = new ArrayList<>();

        for (Integer row=0; row < matrix.size(); row++){
            duplicateMatrix.add(row, new ArrayList<>(matrix.get(row)));
            /*for (Integer column =0; column < matrix.get(0).size(); column++) {
                Integer data = matrix.get(row).get(column);

                duplicateMatrix.get(row).set(column, new Integer(data));
            }*/
        }

        this.duplicateState = new State(duplicateMatrix);

    }

    public State getDuplicateState() {
        return duplicateState;
    }

    public void setDuplicateState(State duplicateState) {
        this.duplicateState = duplicateState;
    }
}
