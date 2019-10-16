package main.resources;

public class Move {
    private Integer data;
    private Character move;

    public Move(Integer data, Character move){
        this.data = data;
        this.move = move;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Character getMove() {
        return move;
    }

    public void setMove(Character move) {
        this.move = move;
    }
}
