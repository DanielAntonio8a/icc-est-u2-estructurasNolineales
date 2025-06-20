import Materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) {
        BinaryTree ab = new BinaryTree();

        ab.insert(9);
        ab.insert(14);
        ab.insert(17);
        ab.insert(19);
        ab.insert(23);
        ab.insert(50);
        ab.insert(54);
        ab.insert(76);

        System.out.println("Nombre: Daniel Duran\n");

        // Peso y altura del árbol
        System.out.println("Peso del arbol = " + ab.getSize());
        System.out.println("Altura es = " + ab.getHeight(ab.getRoot()));

        // InOrder
        System.out.print("\nArbol InOrder\n");
        ab.printInOrder();

        // InOrder con alturas
        System.out.println("\nArbol InOrder con alturas");
        ab.printWithHeights();

        // InOrder con factores
        System.out.println("\nArbol InOrder con factor de equlibrio");
        ab.imprimirFactoresEquilibrio();

        // ¿Está equilibrado?
        System.out.println("\nArbol esta equlibrado = " + (ab.estaEquilibrado() ? "TRUE" : "FALSE"));

        // ¿Existe 15?
        System.out.println("Existe el nodo 15= " + (ab.findValue(15) ? "TRUE" : "FALSE"));

        // Agregar 15
        System.out.println("Agregamos valor = 15");
        ab.insert(15);

        // ¿Sigue equilibrado?
        System.out.println("Arbol esta equlibrado = " + (ab.estaEquilibrado() ? "TRUE" : "FALSE"));

        // Mostrar factores actualizados
        System.out.println("\nArbol InOrder con factor de equlibrio");
        ab.imprimirFactoresEquilibrio();

        // Mostrar nodos desequilibrados
        ab.imprimirNodosDesequilibrados();
    }
}
