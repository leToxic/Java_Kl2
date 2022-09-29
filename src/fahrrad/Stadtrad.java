package fahrrad;

public class Stadtrad extends Fahrrad {
    private boolean licht;

    public Stadtrad(String name, String farbe, int richtung, boolean licht) {
        super(name, farbe, richtung);
        this.licht = licht;
    }

    public Stadtrad(String name, String farbe, boolean licht) {
        super(name, farbe);
        this.licht = licht;
    }

    public Stadtrad(String name, String farbe) {
        super(name, farbe);
        this.licht = false;
    }

    public Stadtrad(String name) {
        super(name);
        this.licht = false;
    }

    public Stadtrad() {
        this.licht = false;
    }

    public boolean isLichtAn() {
        return this.licht;
    }

    public void lichtAn() {
        this.licht = true;
    }

    public void lichtAus() {
        this.licht = false;
    }

    public void umschaltLicht() {
        this.licht = !this.licht;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(", " + (this.licht ? "Licht an" : "Licht aus"));
        return sb.toString();

    }

    public static void main(String[] args) {
        Stadtrad sr = new Stadtrad("Flitzer", "schwarz", false);
        sr.lenke(10);
        sr.beschleunige(.3, 9.8);
        sr.lichtAn();
        System.out.println(sr);
    }
}
