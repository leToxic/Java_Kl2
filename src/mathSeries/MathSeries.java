package mathSeries;

abstract class MathSeries {
    private int n;

    public MathSeries(int n) {
        if(n > 0) {this.n = n;}
    }

    public int getN() {
        return n;
    }

    abstract double sumOfFirst_n_Elements();
    abstract double nth_Element();

    @Override
    public String toString() {
        return "Calculation of the mathematic series with " + n + "Elements";
    }
}
