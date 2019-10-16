package main.java;

import main.resources.*;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    /*for (Node node: graph){
        ApplyMove applyMove = new ApplyMove(node.getS(), node.getMove(), piecesMap);
        if (!applyMove.getNewState().evaluate()) {
            stateToPieces = new StateToPieces(applyMove.getNewState());
            pieces = stateToPieces.getPieces();
            piecesMap = stateToPieces.getPiecesMap();

            movesForState = new MovesForState(applyMove.getNewState(), pieces);
            moves = movesForState.getMoves();
            movesList = new ArrayList<>(moves);

            List<Node> childNodes = new ArrayList<>();
            for (Move move : moves) {
                childNodes.add(new Node(applyMove.getNewState(), move));
            }

            node.addChildren(childNodes);
            graph.addAll(childNodes);
        }
    }*/
}
