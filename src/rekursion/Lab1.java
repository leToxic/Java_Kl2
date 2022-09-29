package rekursion;

/**
 * Created: 15.02.2022 at 15:26
 * Author: Sebastian Plasek
 */
public class Lab1 {
    private static double zahl1;
    private static double zahl2 = 1/1;

    // nicht rekursiver Ansatz der Aufgabe
    public static void nichtrek_kehrw(int n) {
        boolean vorz = false;
        double nenner = 1.0;
        zahl1 = 1 / nenner;

        for (int i = 1; i < n; i++) {
            nenner += 2;
            if (vorz) {
                zahl1 += 1 / nenner;
            } else {
                zahl1 -= 1 / nenner;
            }
            vorz = !vorz;
        }
    }

    // rekursiver Ansatz der Aufgabe
    public static void rek_kerhw(double nenner, int n, boolean vorz) {
        nenner += 2;
        if (n >= 0) {
            if (vorz) {
                zahl2 += 1 / nenner;
            } else {
                zahl2 -= 1 / nenner;
            }
            rek_kerhw(nenner, n-1, !vorz);
        }
    }

    public static void main(String[] args) {
        nichtrek_kehrw(6);
        rek_kerhw(1, 6, false);
        System.out.println(zahl1);
        System.out.println(zahl2);
    }
}
