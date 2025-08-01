package Materia.controllers.Models;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private int height;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }



    public int getHeight() {
        return height;
    }



    public void setHeight(int height) {
        this.height = height;
    }
}
