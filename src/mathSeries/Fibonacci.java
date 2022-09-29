package mathSeries;

public class Fibonacci extends MathSeries {

    public Fibonacci(int n) {
        super(n);
    }

    public double sumOfFirst_n_Elements() {
        if (this.getN() >= 3) {
            int wert1 = 1;
            int wert2 = 1;
            int help = 0;
            int ret = wert1 + wert2;
            for (int i = 3; i <= this.getN(); i++) {
                help = wert1 + wert2;
                wert1 = wert2;
                wert2 = help;
                ret += help;
            }
            return ret;
        }
        if (this.getN() == 1 || this.getN() == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public double nth_Element() {
        if (this.getN() >= 3) {
            int wert1 = 1;
            int wert2 = 1;
            int ret = 0;
            for (int i = 3; i <= this.getN(); i++) {
                ret = wert1 + wert2;
                wert1 = wert2;
                wert2 = ret;
            }
            return ret;
        }
        if (this.getN() == 1 || this.getN() == 2) {
            return 1;
        } else {
            return 0;
        }

    }

}
