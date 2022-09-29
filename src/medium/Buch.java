package medium;

public class Buch extends Medium {
    private int seiten;

    public Buch(String bezeichnung, double preis, int seiten) {
        super(bezeichnung, preis);
        if (seiten > 0) {
            this.seiten = seiten;
        }
    }

    public void info() {
        System.out.println(this.getBezeichnung() + "(Buch), Preis: " + this.getPreis() + ", Seitenanzahl: " + this.seiten);
    }

}
