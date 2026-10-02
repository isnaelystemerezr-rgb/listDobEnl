public class DNode<E> extends Node<E> {
    private DNode<E> prev;

    public DNode(E info) {
        super(info);
        this.prev = null;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }
}
