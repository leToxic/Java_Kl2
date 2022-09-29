package stack;

/**
 * Created: 22.03.2022 at 15:46
 * Author: Sebastian Plasek
 */
public class LinkedQue {
    private Node top;
    private Node tail;
    private int size = 0;
    private boolean isEmpty = true;

    public LinkedQue(Node top) {
        this.top = top;
        this.tail = top;
        this.size = 1;
        this.isEmpty = false;
    }

    public void add(Object o) {
        Node newNode = new Node(o);
        if (this.top == this.tail) {
            this.tail = newNode;
            this.tail.setPrev(this.top);
        } else {
            if (this.tail.getNext() == null) {
                this.tail.setNext(newNode);
                newNode.setPrev(this.tail);
                this.tail = this.tail.getNext();
            }
        }
        size++;
    }

    public Object get() {
        Object ret = this.top.getElem();
        if (this.top == this.tail) {
            this.top = this.tail = null;
            this.isEmpty = true;
        } else {
            this.top = this.top.getNext();
            this.top.setPrev(null);
            this.size--;
        }
        return ret;
    }

    public Object element() {
        return this.top.getElem();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node help = this.top;
        for (int i = 1; i < this.size; i++) {
            if (help != null) {
                sb.append(i + ": " + help.getElem());
                help = help.getNext();
            }
        }
        return sb.toString();
    }
}
