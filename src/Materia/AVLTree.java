package Materia;

import Materia.controllers.Models.*;
public class AVLTree {
    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert (int value){
        root=insertRec(root, value);
    }

    private Node insertRec(Node node, int value){
        if (node == null) {
        Node newNode = new Node(value);
        newNode.setHeight(1);
        System.out.println("Nodo Insetado -> "+ value +"con Balance "+getBalance(newNode));
        return newNode;
        }

        if(value <= node.getValue()){
            //ME VOY A LA IZQUIERDA
            Node newNode = insertRec(node.getLeft(), value);
            node.setLeft(newNode);
        }else if(value > node.getValue()){ 
            // Me voy a insertar a la DERECHA
        node.setRight(insertRec(node.getRight(),value));
        }else{
        return node;
        }

        System.out.println("Node actual " + node.getValue());
        // ACTUALIZAR LA ALTURA DE ESTE ANCESTRO NODE

        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        //                        Altura Nodo1 = retorna #      Nodo2 return 0 en el metodo tenemos un metodo de comparacion 

        node.setHeight(altura);
        System.out.println("\n\tAltura = " + altura);
        //return node;
        int balance = getBalance(node);

        System.out.println("\tBalance = " + balance);

        //Caso Izquierda - Izquierda
        // node.getLeft().getValue(): Valor del nodo de la izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Rotacion Simple a la Derecha");
            return righRotation(node);
        }

        // Caso Derecha - Derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Rotacion Simple a la Izquierda");
            return leftRotation(node);
        }

        //Caso Izquierda - Derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Cambio ");
            node.setLeft(leftRotation(node.getLeft()));
            System.out.println("Rotacion Izquierda - Derecha");
            return righRotation(node);
        }

        //Caso Derecha - Izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Cambio ");
            node.setRight(righRotation(node.getRight()));
            System.out.println("Rotacion Derecha - Izquierda ");
            return leftRotation(node);
        }
        return node;
    }
        //O(2^n) to O(1)
    public int height(Node node){
        if(node==null){
            return 0;
        }
        //O(1) --> getter --> altura --> del nodo
        return node.getHeight();
    }

    public int getBalance(Node node){
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }  


    private Node leftRotation(Node x){
        Node y= x.getRight();
        Node temp= y.getLeft();
        // Imprimir informacion antes de la rotacion 
        System.out.println("Pre-Rotacion Izquierda en nodo: "+x.getValue()
        +", con Balacen = "+getBalance(x));

        // Realizar la rotacion
        y.setLeft(x); 
        x.setRight(temp); //para que el hijo izquierdo de y sea el hijo derecho
        // Imprimir informacion despues de la rotacion

        //ACTUALIZAR LAS ALTURAS
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        //Printear
        System.out.println("Nueva raiz despues de la rotacion "+y.getValue());
        
        return y;
    }
    

    private Node righRotation(Node y){
        Node x=y.getLeft();
        Node temp = x.getRight();

        // Imprimir informacion antes de la rotacion
        System.out.println("Pre-Rotacion Derecha en nodo: "+y.getValue()
        +", con Balacen = "+getBalance(y));
        // Realizar la rotacion
        x.setRight(y);
        y.setLeft(temp);
        // Imprimir informacion despues de la rotacion
        System.out.println("Nueva raiz despues de la rotacion "+x.getValue());
        return x;
    }
}
