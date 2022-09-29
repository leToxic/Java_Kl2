package linkedList;

import java.util.Objects;

/**
 * Eine einfach verkettete Liste.
 */
public class LinkedList {

    private ListNode first;
    private ListNode last;
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
        ListNode node = new ListNode(data);
        if (this.first == null && this.last == null) {
            this.first = node;
        } else {
            ListNode testnode = this.first;
            while (testnode.getNext() != null) {
                testnode = testnode.getNext();
            }

            testnode.setNext(node);

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
        ListNode node = new ListNode(data);
        if (idx < 0 || idx > this.length) {
            throw new IndexOutOfBoundsException(idx);
        } else if (idx == 0) {
            node.setNext(this.first);
            this.first = node;
            this.length++;
            if (this.first.getNext() == null) {
                this.last = this.first;
            }
        } else {
            ListNode testnode = this.first;

            for (int i = 0; i < idx - 1 && testnode.getNext() != null; i++) {
                testnode = testnode.getNext();
            }

            node.setNext(testnode.getNext());
            testnode.setNext(node);
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
        ListNode node = this.first;
        for (int i = 0; i != idx; i++) {
            node = node.getNext();
        }
        return node.getData();
    }

    /**
     * Setzt neue Daten auf der angegebenen Indexnummer.
     *
     * @param index Indexnummer
     * @return ursprünglicher - alter Datenwert
     * @throws IndexOutOfBoundsException bei ungültiger Indexnummer
     */
    public Object set(Object data, int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        ListNode node = this.first;
        int i = 0;
        while (i != index) {
            node = node.getNext();
            i++;
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
            ListNode node = this.first;
            Object data = node.getData();
            this.first = node.getNext();
            if (this.first == null) {
                this.last = null;
            } else if (this.first.getNext() == null) {
                this.last = this.first;
            }
            this.length--;
            return data;
        } else if (idx == this.length - 1) {
            ListNode node = this.first;
            Object data = this.last.getData();
            while (node.getNext() != this.last) {
                node = node.getNext();
            }
            this.length--;
            node.setNext(null);
            this.last = node;
            return data;
        } else {
            ListNode node = this.first;
            for (int i = 0; i != idx - 1; i++) {
                node = node.getNext();
            }
            Object data = node.getNext().getData();
            node.setNext(node.getNext().getNext());
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
        ListNode node = this.first;
        ListNode testnode = this.first;
        while (node != null) {
            if (node.getData() == data) {
                if (node == this.first) {
                    node = node.getNext();
                    testnode = node;
                    this.first = node;
                } else if (node == this.last) {
                    testnode.setNext(null);
                    this.last = testnode;
                } else {
                    testnode.setNext(node.getNext());
                    node = node.getNext();
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
        ListNode node = this.first;
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
        LinkedList other = (LinkedList) o;
        if (this == null && other == null) {
            return true;
        }
        if (this == null || other == null) {
            return false;
        }
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
