package dualLinkedList;

/**
 * Created: 29.03.2022 at 15:25
 * Author: Sebastian Plasek
 */

/**
 * Kapselt die einen Knotens der Liste.
 */
public class DualListNode {

    private Object data;
    private DualListNode next;
    private DualListNode previous;


    /**
     * Erstellt einen neuen (leeren) Knoten.
     * <p>
     * keine Daten - kein Nachfolger
     */
    public DualListNode() {
    }

    /**
     * Erstellt einen neuen Knoten.
     *
     * @param data im Konoten zu speichernde Daten
     */
    public DualListNode(Object data) {
        this.data = data;
    }

    /**
     * Liefert die Daten dieses Knotens.
     *
     * @return die Daten
     */
    public Object getData() {
        return this.data;
    }

    /**
     * Setzt neue Daten für diesen Knoten.
     *
     * @param data zu speichernde Daten
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Liefert den Nachfolger dieses Knotens.
     *
     * @return den Zugriff auf den Nachfolgeknoten
     */
    public DualListNode getNext() {
        return this.next;
    }

    /**
     * Setzt einen neuen Nachfolger für diesen Knoten.
     *
     * @param next neuer Nachfolger
     */
    public void setNext(DualListNode next) {this.next = next;}

    public DualListNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(DualListNode previous) {
        this.previous = previous;
    }

}
