package dualLinkedList;


import java.util.Objects;

/**
 * Created: 29.03.2022 at 15:23
 * Author: Sebastian Plasek
 */

/**
 * Eine einfach verkettete Liste.
 */
public class DualLinkedList {

    private DualListNode first;
    private DualListNode last;
    private int length;        // darf auch verwendet werden

    /**
     * Ermittelt die Anzahl an Elementen in der Liste.
     *
     * @return Anzahl Elemente
     */
    public int size() {
        return this.length;
    }

    /**
     * Liefert den ersten gespeicherten Datensatz.
     *
     * @return erster Datensatz
     */
    public Object getFirst() {
        return this.first.getData();
    }

    /**
     * Liefert den letzten gespeicherten Datensatz.
     *
     * @return letzter Datensatz
     */
    public Object getLast() {
        return this.last.getData();
    }

    /**
     * Fügt einen neuen Datensatz ans Ende der Liste hinzu.
     *
     * @param data anzuhängende Daten
     */
    public void add(Object data) {
        DualListNode node = new DualListNode(data);
        if (this.first == null && this.last == null) {
            this.first = node;
        } else {
            DualListNode testnode = first;
            while (testnode.getNext() != null) {
                testnode = testnode.getNext();
            }

            testnode.setNext(node);
            node.setPrevious(testnode);

        }
        this.last = node;
        this.length++;
    }

    /**
     * Fügt einen neuen Datensatz an einer bestimmten Stelle hinzu.
     *
     * @param data einzufügende Daten
     * @param idx  Index, 0-basiert
     */
    public void add(Object data, int idx) {
        DualListNode node = new DualListNode(data);
        if (idx < 0 || idx > this.length) {
            throw new IndexOutOfBoundsException(idx);
        } else if (idx == 0) {
            node.setNext(this.first);
            if (this.first != null) {
                this.first.setPrevious(node);
            }
            this.first = node;
            this.length++;
            if (this.first.getNext() == null) {
                this.last = this.first;
            }
        } else {
            DualListNode testnode = this.first;

            for (int i = 0; i < idx - 1 && testnode.getNext() != null; i++) {
                testnode = testnode.getNext();
            }

            DualListNode nextNode = testnode.getNext();
            nextNode.setPrevious(node);
            node.setPrevious(testnode);
            testnode.setNext(node);
            node.setNext(nextNode);
            this.length++;
        }

    }

    /**
     * Liefert einen gespeicherten Datensatz (ohne ihn zu löschen).
     *
     * @param idx von diesem Index wird der Datensatz geliefert
     * @return gespeicherter Datensatz am Index {@code idx}
     */
    public Object get(int idx) {
        if (idx < 0 || idx >= this.length) {
            throw new IndexOutOfBoundsException(idx);
        }
        DualListNode ret = this.first;
        for (int i = 0; i != idx; i++) {
            ret = ret.getNext();
        }
        return ret.getData();
    }

    /**
     * Setzt neue Daten auf der angegebenen Indexnummer.
     *
     * @param idx Indexnummer
     * @return ursprünglicher - alter Datenwert
     * @throws IndexOutOfBoundsException bei ungültiger Indexnummer
     */
    public Object set(Object data, int idx) {
        if (idx < 0 || idx >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        DualListNode node = this.first;
        for (int i = 0; i != idx; i++) {
            node = node.getNext();
        }
        Object ret = node.getData();
        node.setData(data);
        return ret;
    }

    /**
     * Entfernt einen Datensatz.
     *
     * @param idx an diesem Index wird der Datensatz entfernt
     * @return gespeicherter Datensatz
     */
    public Object remove(int idx) {
        if (idx < 0 || idx >= this.length) {
            throw new IndexOutOfBoundsException(idx);
        }
        if (idx == 0) {
            DualListNode node = this.first;
            Object data = node.getData();
            this.first = node.getNext();
            if (this.first != null) {
                this.first.setPrevious(null);
            }
            if (this.first == null) {
                this.last = null;
            } else if (this.first.getNext() == null) {
                this.last = this.first;
            }
            this.length--;
            return data;
        } else if (idx == this.length - 1) {
            DualListNode node = this.first;
            Object data = this.last.getData();
            while (node.getNext() != this.last) {
                node = node.getNext();
            }
            this.length--;
            node.setNext(null);
            this.last = node;
            return data;
        } else {
            DualListNode node = this.first;
            for (int i = 0; i < idx - 1; i++) {
                node = node.getNext();
            }

            Object data = node.getNext().getData();
            node.setNext(node.getNext().getNext());
            if (node.getNext() != null) {
                node.getNext().setPrevious(node);
            }
            this.length--;
            return data;
        }
    }

    /**
     * Entfernt alle Kopien eines Datensatzes aus der Liste.
     * Jedes Element wird maximal einmal besucht ==> Laufzeit O(n).
     *
     * @param data zu entfernender Datensatz
     */
    public void removeAll(Object data) {
        DualListNode node = this.first;
        DualListNode testnode = this.first;

        while (node != null) {
            if (node.getData() == data) {
                if (node == this.first) {
                    node = node.getNext();
                    testnode = node;
                    this.first = node;

                    if (this.first != null) {
                        this.first.setPrevious(null);
                    }
                } else if (node == this.last) {
                    this.last = testnode;
                    testnode.setNext(null);
                } else {
                    testnode.setNext(node.getNext());
                    node = node.getNext();

                    if (node != null) {
                        node.setPrevious(testnode);
                    }
                }
                this.length--;
            } else {
                testnode = node;
                node = node.getNext();
            }
        }
    }

    /**
     * Löscht die gesamte Liste.
     */
    public void remove() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DualListNode node = this.first;
        if (node == null) {
            return "{ }";
        }
        sb.append("{");
        while (node != null) {
            sb.append(node.getData());
            if (node != this.last) {
                sb.append(", ");
            }
            node = node.getNext();
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DualLinkedList other = (DualLinkedList) o;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            boolean equal = Objects.equals(this.get(i), other.get(i));
            if (!equal) {
                return false;
            }
        }
        return true;
    }
}
