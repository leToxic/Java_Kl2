package doel;

public class BaumMain {

    public static void main(String[] args) {
        Baum b = new Baum();
        b.insertIn(5);
        b.insertIn(2);
        b.insertIn(1);
        b.insertIn(3);
        b.insertIn(6);
        b.insertIn(8);
        b.insertIn(4);
        b.listBaum(3);
        b.insertIn(-13);
        b.listBaum(3);
    }
}
