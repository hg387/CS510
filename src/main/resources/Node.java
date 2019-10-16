package main.resources;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private State s;
    private Move move;
    private Node parent = null;
    private List<Node> children = new ArrayList<>();

    public Node(State s, Move move){
        this.s = s;
        this.move = move;
    }

    public void addChildren(Node child){
        child.setParent(this);
        this.children.add(child);
    }

    public void addChildren(List<Node> children){
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public State getS() {
        return s;
    }

    public Move getMove() {
        return move;
    }

    public void setS(State s) {
        this.s = s;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
