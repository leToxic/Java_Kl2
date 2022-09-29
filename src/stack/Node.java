package stack;

/**
 * Created: 22.03.2022 at 15:16
 * Author: Sebastian Plasek
 */
public class Node {
    private Object elem;
    private Node next;
    private Node prev;

    public Node(Object elem, Node next, Node prev) {
        setElem(elem);
        setNext(next);
        setPrev(prev);
    }

    public Node(Object elem, Node prev) {
        setElem(elem);
        setPrev(prev);
    }

    public Node(Object elem) {
        setElem(elem);
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public Object getElem() {
        return elem;
    }

}
