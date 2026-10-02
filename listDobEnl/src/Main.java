public class Main {
    public static void main(String[] args) {

        System.out.println("=== PRUEBA 1: ELIMINAR REPETIDOS ===");
        DLinkedList<String> lista1 = new DLinkedList<>();
        lista1.add("A");
        lista1.add("B");
        lista1.add("A");
        lista1.add("C");
        lista1.add("B");

        System.out.print("Lista original: ");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.print(lista1.get(i) + " ");
        }
        System.out.println();

        lista1.eliminarRepetidos();

        System.out.print("Lista sin repetidos: ");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.print(lista1.get(i) + " ");
        }
        System.out.println("\n");

        System.out.println("=== PRUEBA 2: ROTAR A LA DERECHA ===");
        DLinkedList<String> lista2 = new DLinkedList<>();
        lista2.add("A");
        lista2.add("B");
        lista2.add("C");
        lista2.add("D");

        System.out.print("Lista original: ");
        for (int i = 0; i < lista2.size(); i++) {
            System.out.print(lista2.get(i) + " ");
        }
        System.out.println();

        lista2.rotarDerecha();

        System.out.print("Lista rotada: ");
        for (int i = 0; i < lista2.size(); i++) {
            System.out.print(lista2.get(i) + " ");
        }
        System.out.println("\n");

        System.out.println("=== PRUEBA 3: CONCATENAR ===");
        DLinkedList<String> lista3 = new DLinkedList<>();
        lista3.add("E");
        lista3.add("F");
        lista3.add("G");
        lista3.add("H");

        System.out.print("Lista 2: ");
        for (int i = 0; i < lista2.size(); i++) {
            System.out.print(lista2.get(i) + " ");
        }
        System.out.println();

        System.out.print("Lista 3: ");
        for (int i = 0; i < lista3.size(); i++) {
            System.out.print(lista3.get(i) + " ");
        }
        System.out.println();

        lista2.concatenar(lista3);

        System.out.print("Lista concatenada: ");
        for (int i = 0; i < lista2.size(); i++) {
            System.out.print(lista2.get(i) + " ");
        }
        System.out.println();
    }
}