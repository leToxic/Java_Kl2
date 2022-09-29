package mathSeries;

public class ReciprocalAlternating extends Reciprocal {

    public ReciprocalAlternating(int n) {
        super(n);
    }

    public double sumOfFirst_n_Elements() {
        double ret = 0;
        boolean vrz = true;
        for (double i = 0; i < this.getN() * 2; i++) {
            if (i % 2 != 0) {
                if (vrz) {
                    ret += 1 / i;
                }else {
                    ret -= 1 / i;
                }
                vrz = !vrz;
            }
        }
        return ret;
    }

    public double nth_Element() {
        return super.nth_Element();
    }

    public static void main(String[] args) {
        ReciprocalAlternating rec = new ReciprocalAlternating(2);
        double erg = rec.nth_Element();
        System.out.println(erg);
        double erg2 = rec.sumOfFirst_n_Elements();
        System.out.println(erg2);
    }
}
