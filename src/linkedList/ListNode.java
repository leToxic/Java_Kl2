package linkedList;

/**
 * Kapselt die einen Knotens der Liste.
 */
class ListNode {

    private Object data;
    private ListNode next;


	/**
     * Erstellt einen neuen (leeren) Knoten.
     * 
     * keine Daten - kein Nachfolger
     */
    public ListNode() {
    }
	
    /**
     * Erstellt einen neuen Knoten.
     *
     * @param data im Konoten zu speichernde Daten
     */
    public ListNode(Object data) {
        this.data = data;
    }

    /**
     * Liefert die Daten dieses Knotens.
     *
     * @return die Daten 
     */
    public Object getData() {
        return data;
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
    public ListNode getNext() {
        return next;
    }
	
	/**
     * Setzt einen neuen Nachfolger für diesen Knoten.
     *
     * @param next neuer Nachfolger
     */
    public void setNext(ListNode next) {
        this.next = next;
    }

}
