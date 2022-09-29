package fahrrad;

public class Fahrrad {
    private String name;
    private String farbe;
    private int richtung = 0;
    private double geschwindigkeit = 0.0;

    public Fahrrad(String name, String farbe, int richtung) {
        setFarbe(farbe);
        setName(name);
        lenke(richtung);
    }

    public Fahrrad(String name, String farbe) {
        this(name, farbe, 0);
    }

    public Fahrrad(String name) {
        this(name, "Standardwert", 0);
    }

    public Fahrrad() {
        this("Standardwert", "Standardwert", 0);
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void lenke(int richtung) {
        int test = this.richtung;
        if (richtung >= -45 && richtung <= 45 && (test - richtung) >= -45 && (test - richtung) <= 45) {
            this.richtung += richtung;
        }
    }

    public void beschleunige(double a, double sec) {
        if (sec > 0.0) {
            this.geschwindigkeit += a * sec;
        }
        if (this.geschwindigkeit < 0.0) {
            this.geschwindigkeit = 0.0;
        }
    }


    public double getKmh() {
        double test = this.geschwindigkeit;
        test *= 3.6;
        return test;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + this.name + ", ");
        sb.append("Farbe: " + this.farbe + ", ");
        sb.append("Richtung: " + this.richtung + "°" + ", ");
        sb.append("km/h: " + String.format("%.2f", getKmh()));
        return sb.toString();
    }

    public static void main(String[] args) {
        Fahrrad fr = new Fahrrad("Strampler", "blau");
        fr.lenke(10);
        fr.beschleunige(.3, 9.8);
        System.out.println(fr);
    }

}
