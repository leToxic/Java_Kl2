package medium;

public abstract class Medium {

    private String bezeichnung;
    private double preis;

    public Medium(String bezeichnung, double preis) {
        this.bezeichnung = bezeichnung;
        if (preis > 0.0) {
            this.preis = preis;
        }
    }

    public double getPreis() {
        return preis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public abstract void info();
}
