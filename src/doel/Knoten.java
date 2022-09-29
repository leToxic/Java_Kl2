package doel;

public class Knoten {
    private int data;
    private Knoten left;
    private Knoten right;

    Knoten(int data) {
        setData(data);
    }

    boolean insert(int data) {
        if (data > this.data) {
            if (this.right == null) {
                this.right = new Knoten(data);
                return true;
            } else {
                System.out.println("passed to " + this.right);
                this.right.insert(data);
            }
        } else if (data < this.data) {
            if (this.left == null) {
                this.left = new Knoten(data);
                return true;
            } else {
                System.out.println("passed to " + this.left);
                this.left.insert(data);
            }
        }
        return false;

    }

    private void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }
        System.out.println(this.getData());
        if (this.right != null) {
            this.right.inorder();
        }
    }

    private void postorder() {
        if (this.left != null) {
            this.left.postorder();
        }
        if (this.right != null) {
            this.right.postorder();
        }
        System.out.println(this.getData());
    }

    private void preorder() {
        System.out.println(this.getData());
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }

    }


    void list(int order) {
        if (order == 1) {
            this.inorder();
        } else if (order == 2) {
            this.preorder();
        } else if (order == 3) {
            this.postorder();
        } else {
            System.out.println("Order nicht verfügbar<");
        }
    }


    private void setData(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }


    int sum() {
        int ret = 0;
        if (this.left != null) {
            ret += this.left.sum();
        }
        if (this.right != null) {
            ret += this.right.sum();
        }
        ret += this.getData();
        return ret;
    }
}
