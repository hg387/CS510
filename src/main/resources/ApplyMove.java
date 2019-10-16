package main.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplyMove {
    private State newState;
    private State previousState;

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public State getNewState() {
        return newState;
    }

    public void setNewState(State newState) {
        this.newState = newState;
    }

    public ApplyMove(State s, Move move, HashMap<Integer, ArrayList<List<Integer>>> piecesMap){
        //ArrayList<List<Integer>> matrix = s.getMatrix();
        Character action = move.getMove();
        Integer data = move.getData();

        State newState = new StateCloner(s).getDuplicateState();
        ArrayList<List<Integer>> matrix = newState.getMatrix();

        if(piecesMap.get(data) != null){
            ArrayList<List<Integer>> positions = piecesMap.get(data);
            try {
                if (action.equals('u')) {
                    for (List<Integer> position : positions) {
                        Integer row = position.get(0);
                        Integer column = position.get(1);

                        matrix.get(row - 1).set(column, data);
                        matrix.get(row).set(column, 0);
                    }
                } else if (action.equals('d')) {
                    for (List<Integer> position : positions) {
                        Integer row = position.get(0);
                        Integer column = position.get(1);

                        matrix.get(row + 1).set(column, data);
                        matrix.get(row).set(column, 0);

                    }
                } else if (action.equals('l')) {
                    for (List<Integer> position : positions) {
                        Integer row = position.get(0);
                        Integer column = position.get(1);

                        matrix.get(row).set(column - 1, data);
                        matrix.get(row).set(column, 0);
                    }
                } else if (action.equals('r')) {
                    for (List<Integer> position : positions) {
                        Integer row = position.get(0);
                        Integer column = position.get(1);

                        matrix.get(row).set(column + 1, data);
                        matrix.get(row).set(column, 0);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Exception thrown at data: " + action);
            }
        }
        this.newState = newState;
        this.previousState = s;
    }
}
