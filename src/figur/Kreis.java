package figur;

public class Kreis extends Figur2D {
    private double radius;

    public Kreis(double radius) {
        if (radius > 0.0) {
            this.radius = radius;
        }
    }

    public double umfang() {
        return 2 * this.radius * Math.PI;
    }

    public double flaeche() {
        return Math.PI * this.radius * this.radius;
    }

    public void info() {
        System.out.println("Kreis mit Radius " + this.radius);
    }
}
