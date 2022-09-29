package person;

public class Konto {
    private double kontostand = 0.0;
    private Person inhaber;

    public Konto(String nn, String vn, double kontostand) {
        setInhaber(nn, vn);
        veraendereKontostand(kontostand);
    }

    public Konto(String nn, String vn) {
        this(nn, vn, 0);
    }

    public Konto(String nn) {
        this(nn, "!Standardwert", 0);
    }

    public Konto() {
        this("!Standardwert", "!Standardwert" + 0);
    }

    public void setInhaber(String nn, String vn) {
        this.inhaber = new Person(nn, vn);
    }

    public void veraendereKontostand(double kontostand) {
        this.kontostand += kontostand;
    }

    public double getKontostand() {
        return kontostand;
    }

    public String getInhaber() {
        return inhaber.getNn();
    }

    public static void vergleich(Konto konto1, Konto konto2) {
        if (konto1.getKontostand() > konto2.getKontostand()) {
            System.out.println(konto1.getInhaber() + " hat mehr Geld auf dem Konto als " + konto2.getInhaber());
        } else if (konto1.getKontostand() < konto2.getKontostand()) {
            System.out.println(konto2.getInhaber() + " hat mehr Geld auf dem Konto als " + konto1.getInhaber());
        } else if (konto1.getKontostand() == konto2.getKontostand()) {
            System.out.println(konto1.getInhaber() + " und " + konto2.getInhaber() + " haben gleich viel Geld auf dem Konto");
        }
    }

    public static void main(String[] args) {
        Konto konto1 = new Konto("Schmidt", "Hans", 500.0);
        Konto konto2 = new Konto("Krause", "Peter", 1500.0);
        Konto konto3 = new Konto("Bauer", "Harald", 500.0);
        Konto.vergleich(konto1, konto2);
        Konto.vergleich(konto2, konto3);
        Konto.vergleich(konto1, konto3);
    }
}

