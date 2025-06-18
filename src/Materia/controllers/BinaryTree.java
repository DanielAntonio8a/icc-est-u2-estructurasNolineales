package Materia.controllers;

import Materia.controllers.Models.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        
        if (value <= current.getValue()) {
            // Go to the left
            current.setLeft(insertRec(current.getLeft(), value));
        } else if (value > current.getValue()) {
            // Go to the right
            current.setRight(insertRec(current.getRight(), value));
        }
        
        return current;
    }

    public void imprimirArbol() {
        printpreorder();
    }

    public void printpreorder() {
        printpreorder(root);
    }

    private void printpreorder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            printpreorder(node.getLeft());
            printpreorder(node.getRight());
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + ", ");
            printInOrder(node.getRight());
        }
    }

    public void printPostOrder() {
        printInOrder(root);
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            printInOrder(node.getRight());            
            System.out.print(node.getValue() + ", ");
        }
    }
}