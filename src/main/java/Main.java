package main.java;


import main.resources.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];
        String outputFileName = args[1];
        try {
            ArrayList<List<Integer>> matrix = FileReader.fileReader(fileName);
            State initialState = new State(matrix);
            StateToPieces stateToPieces = new StateToPieces(initialState);
            ArrayList<Piece> pieces = stateToPieces.getPieces();
            HashMap<Integer, ArrayList<List<Integer>>> piecesMap = stateToPieces.getPiecesMap();

            MovesForState movesForState = new MovesForState(initialState, pieces);
            HashSet<Move> moves = movesForState.getMoves();
            List<Move> movesList = new ArrayList<>(moves);

            //ApplyMove applyMove = new ApplyMove(initialState, new Move(6,'l'), piecesMap );
            ArrayList<List<Node>> levels = new ArrayList<>();
            List<Node> graph = new ArrayList<>();
            for (Move move: moves){
                graph.add(new Node(new StateCloner(initialState).getDuplicateState(), move));
            }
            levels.add(graph);

            for (Integer i = 0; i < levels.size(); i++){
                List<Node> level = levels.get(i);
                List<Node> childNodes = new ArrayList<>();
                for (Node node: level) {
                    ApplyMove applyMove = new ApplyMove(node.getS(), node.getMove(), piecesMap);
                    if (!applyMove.getNewState().evaluate()) {
                        stateToPieces = new StateToPieces(applyMove.getNewState());
                        pieces = stateToPieces.getPieces();
                        piecesMap = stateToPieces.getPiecesMap();

                        movesForState = new MovesForState(applyMove.getNewState(), pieces);
                        moves = movesForState.getMoves();
                        movesList = new ArrayList<>(moves);

                        for (Move move : moves) {
                            childNodes.add(new Node(new StateCloner(applyMove.getNewState()).getDuplicateState(), move));
                        }

                        node.addChildren(childNodes);

                    }
                }
                levels.add(i+1, childNodes);
            }

            System.out.println(levels);
            System.out.println(stateToPieces.getPiecesMap());
            System.out.println(stateToPieces.getPieces().size());
            System.out.println(moves);
        }
        catch (IOException e){System.out.println("Exception Thrown : "  + e);}
    }
}
