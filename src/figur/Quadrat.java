package figur;

public class Quadrat extends Figur2D {
    public double seite;

    public Quadrat(double seite) {
        if (seite > 0.0) {
            this.seite = seite;
        }
    }

    public Quadrat() {
        this(1);
    }

    public double umfang() {
        return 4 * this.seite;
    }

    public double flaeche() {
        return Math.pow(seite, 2);
    }

    public void info() {
        System.out.println("Quadrat mit Seitelaenge " + seite);
    }
}
