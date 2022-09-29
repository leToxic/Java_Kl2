package doel;

public class Baum {
    private Knoten root;

    public Baum() {
        this.root = null;
    }


    public void insertIn(int data) {
        if (this.root == null) {
            this.root = new Knoten(data);
        } else {
            this.root.insert(data);
        }
    }

    public void listBaum(int order) {
        if (this.root != null) {
            this.root.list(order);
        } else {
            System.out.println("Root is null");
        }
    }

    public int sum() {
        if (this.root != null) {
            return this.root.sum();
        } else {
            return -1;
        }
    }
}
