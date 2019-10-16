package main.resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MovesForState {
    private HashSet<Move> moves;

    public MovesForState(State s, ArrayList<Piece> pieces){
        ArrayList<List<Integer>> matrix = s.getMatrix();
        HashSet<Move> moves = new HashSet<>();

        for (Piece piece: pieces){
            Integer data = piece.getData();
            ArrayList<List<Integer>> position = piece.getPosition();
            if (data != -1) {
                try {
                    if (position.size() == 1) {
                        Move move;
                        Integer row = position.get(0).get(0);
                        Integer column = position.get(0).get(1);
                        boolean counter;
                        if (matrix.get(row - 1).get(column) == 0) {
                            move = new Move(data, 'u');
                            moves.add(move);
                        }
                        if (matrix.get(row + 1).get(column) == 0) {
                            move = new Move(data, 'd');
                            moves.add(move);
                        }
                        if (matrix.get(row).get(column - 1) == 0) {
                            move = new Move(data, 'l');
                            moves.add(move);
                        }
                        if (matrix.get(row).get(column + 1) == 0) {
                            move = new Move(data, 'r');
                            moves.add(move);
                        }
                        if (data == 2){
                            if (matrix.get(row - 1).get(column) == -1) {
                                move = new Move(data, 'u');
                                moves.add(move);
                            }
                            if (matrix.get(row + 1).get(column) == -1) {
                                move = new Move(data, 'd');
                                moves.add(move);
                            }
                            if (matrix.get(row).get(column - 1) == -1) {
                                move = new Move(data, 'l');
                                moves.add(move);
                            }
                            if (matrix.get(row).get(column + 1) == -1) {
                                move = new Move(data, 'r');
                                moves.add(move);
                            }
                        }
                    } else {
                        Move move;
                        for (List<Integer> coords : position) {
                            Integer row = coords.get(0);
                            Integer column = coords.get(1);
                            //add counter
                            if (matrix.get(row - 1).get(column) == 0) {
                                move = new Move(data, 'u');
                                moves.add(move);
                            }
                            if (data == 2){
                                if (matrix.get(row - 1).get(column) == -1) {
                                    move = new Move(data, 'u');
                                    moves.add(move);
                                }
                            }
                        }

                        for (List<Integer> coords : position) {
                            Integer row = coords.get(0);
                            Integer column = coords.get(1);
                            if (matrix.get(row + 1).get(column) == 0) {
                                move = new Move(data, 'd');
                                moves.add(move);
                            }
                            if (data == 2){
                                if (matrix.get(row + 1).get(column) == -1) {
                                    move = new Move(data, 'd');
                                    moves.add(move);
                                }
                            }
                        }

                        for (List<Integer> coords : position) {
                            Integer row = coords.get(0);
                            Integer column = coords.get(1);
                            if (matrix.get(row).get(column - 1) == 0) {
                                move = new Move(data, 'l');
                                moves.add(move);
                            }
                            if (data == 2){
                                if (matrix.get(row).get(column - 1) == -1) {
                                    move = new Move(data, 'l');
                                    moves.add(move);
                                }
                            }
                        }

                        for (List<Integer> coords : position) {
                            Integer row = coords.get(0);
                            Integer column = coords.get(1);
                            if (matrix.get(row).get(column + 1) == 0) {
                                move = new Move(data, 'r');
                                moves.add(move);
                            }
                            if (data == 2){
                                if (matrix.get(row).get(column + 1) == -1) {
                                    move = new Move(data, 'r');
                                    moves.add(move);
                                }
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Exception thrown at data: " + data + " and position: " + position);
                }
            }
        }

        this.moves = moves;
    }

    public HashSet<Move> getMoves() {
        return moves;
    }

    public void setMoves(HashSet<Move> moves) {
        this.moves = moves;
    }
}
