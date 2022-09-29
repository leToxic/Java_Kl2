package medium;

import java.util.Random;

public class MediumMain {
    public static void main(String[] args) {
        Medium[] m = new Medium[4];
        Random rn = new Random();
        m[0] = new AudioCD("Baumwolle", 13.99, 3.02);
        m[1] = new Buch("Meine Mama", 18.99, 234);
        m[2] = new AudioCD("Dijanas Spaß", 187.69, 420.88);
        m[3] = new Buch("Davids Keller", 777.99, 897);

        for (Medium med : m) {
            med.info();
        }

    }
}
