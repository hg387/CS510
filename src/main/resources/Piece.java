package main.resources;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    Integer data;
    ArrayList<List<Integer>> position;

    public Piece(Integer data, ArrayList<List<Integer>> position){
        this.data = data;
        this.position = position;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public ArrayList<List<Integer>> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<List<Integer>> position) {
        this.position = position;
    }
}
