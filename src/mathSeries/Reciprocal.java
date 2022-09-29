package mathSeries;

public class Reciprocal extends MathSeries {

    public Reciprocal(int n) {
        super(n);
    }

    public double sumOfFirst_n_Elements() {
        double ret = 0;
        for (double i = 0; i < this.getN() * 2; i++) {
            if (i % 2 != 0) {
                ret += 1 / i;
            }
        }
        return ret;
    }

    public double nth_Element() {
        double ret = 0;
        for (double i = 0; i < this.getN() * 2; i++) {
            if (i % 2 != 0) {
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Reciprocal rec = new Reciprocal(3);
        double erg = rec.nth_Element();
        System.out.println(erg);
        double erg2 = rec.sumOfFirst_n_Elements();
        System.out.println(erg2);
    }
}



