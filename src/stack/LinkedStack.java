package stack;

/**
 * Created: 22.03.2022 at 15:19
 * Author: Sebastian Plasek
 */
public class LinkedStack {
    private Node tos;
    private int size = 0;
    private boolean isEmpty = true;

    public LinkedStack(Node tos) {
        this.tos = tos;
        this.size = 1;
        isEmpty = false;
    }

    public void push(Object c) {
        Node newNode = new Node(c);
        newNode.setNext(this.tos);
        this.tos = newNode;
        this.size++;
    }

    public Object pop() {
        Object ret = this.tos.getElem();
        this.tos = this.tos.getNext();
        this.size--;
        return ret;
    }

    public int size() {
        return this.size;
    }

    public Object elemnt() {
        return this.tos.getElem();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node help = this.tos;
        for (int i = 1; i < size; i++) {
            sb.append(i + ": " + help.getElem());
            help = help.getNext();
        }
        return sb.toString();
    }
}
