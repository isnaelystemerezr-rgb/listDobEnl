public class DLinkedList<E> implements IList<E> {

    // Atributos
    protected DNode<E> first;
    protected int size;

    // Constructor
    public DLinkedList() {
        this.first = null;
        this.size = 0;
    }

    // ----- MÉTODOS BÁSICOS DE LA INTERFAZ -----

    @Override
    public void add(E e) {
        DNode<E> node = new DNode<>(e);
        if (isEmpty()) {
            first = node;
        } else {
            DNode<E> cursor = first;
            while (cursor.getNext() != null) {
                cursor = (DNode<E>) cursor.getNext();
            }
            cursor.setNext(node);
            node.setPrev(cursor);
        }
        size++;
    }

    @Override
    public void add(E e, int index) {
        if (index >= 0 && index <= size) {
            DNode<E> node = new DNode<>(e);
            if (index == 0) {
                node.setNext(first);
                if (first != null) {
                    first.setPrev(node);
                }
                first = node;
            } else {
                DNode<E> cursor = first;
                DNode<E> prev = null;
                for (int i = 0; i < index; i++) {
                    prev = cursor;
                    cursor = (DNode<E>) cursor.getNext();
                }
                node.setPrev(prev);
                node.setNext(cursor);
                prev.setNext(node);
                if (cursor != null) {
                    cursor.setPrev(node);
                }
            }
            size++;
        } else {
            throw new UnsupportedOperationException("index out of range");
        }
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            DNode<E> aux;
            if (index == 0) {
                aux = first;
                first = (DNode<E>) first.getNext();
                if (first != null) {
                    first.setPrev(null);
                }
            } else {
                DNode<E> cursor = first;
                DNode<E> prev = null;
                int i = 0;
                while (i < index) {
                    prev = cursor;
                    cursor = (DNode<E>) cursor.getNext();
                    i++;
                }
                prev.setNext(cursor.getNext());
                aux = cursor;
                DNode<E> siguiente = (DNode<E>) cursor.getNext();
                if (siguiente != null) {
                    siguiente.setPrev(prev);
                }
            }
            size--;
            return aux.getInfo();
        } else {
            throw new UnsupportedOperationException("index out of range");
        }
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            Node<E> cursor = first;
            int i = 0;
            while (i < index) {
                cursor = cursor.getNext();
                i++;
            }
            return cursor.getInfo();
        } else {
            throw new UnsupportedOperationException("index out of range");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    // ----- EJERCICIOS PROPUESTOS -----

    // 1. Eliminar elementos repetidos
    public void eliminarRepetidos() {
        DNode<E> actual = first;

        while (actual != null) {
            DNode<E> comparador = (DNode<E>) actual.getNext();
            DNode<E> anterior = actual;

            while (comparador != null) {
                if (actual.getInfo().equals(comparador.getInfo())) {
                    DNode<E> siguiente = (DNode<E>) comparador.getNext();

                    anterior.setNext(siguiente);

                    if (siguiente != null) {
                        siguiente.setPrev(anterior);
                    }

                    size--;
                    comparador = siguiente;
                } else {
                    anterior = comparador;
                    comparador = (DNode<E>) comparador.getNext();
                }
            }
            actual = (DNode<E>) actual.getNext();
        }
    }

    // 2. Rotar una posición a la derecha
    public void rotarDerecha() {
        if (first == null || first.getNext() == null) {
            return;
        }

        // Buscar el último nodo
        DNode<E> ultimo = first;
        while (ultimo.getNext() != null) {
            ultimo = (DNode<E>) ultimo.getNext();
        }

        // Penúltimo nodo
        DNode<E> penultimo = ultimo.getPrev();

        // El penúltimo ahora es el último
        penultimo.setNext(null);

        // El último pasa a ser el primero
        ultimo.setPrev(null);
        ultimo.setNext(first);

        // El antiguo primero apunta hacia atrás al nuevo primero
        first.setPrev(ultimo);

        // Actualizar la cabeza
        first = ultimo;
    }

    // 3. Concatenar dos listas
    public void concatenar(DLinkedList<E> otraLista) {
        if (this.isEmpty()) {
            this.first = otraLista.first;
            this.size = otraLista.size;
            return;
        }

        if (otraLista.isEmpty()) {
            return;
        }

        // Buscar el último nodo de esta lista
        DNode<E> ultimoActual = first;
        while (ultimoActual.getNext() != null) {
            ultimoActual = (DNode<E>) ultimoActual.getNext();
        }

        // Enlazar con el primero de la otra lista
        DNode<E> primeroOtra = otraLista.first;
        ultimoActual.setNext(primeroOtra);
        primeroOtra.setPrev(ultimoActual);

        // Actualizar tamaño
        this.size = this.size + otraLista.size;
    }
}