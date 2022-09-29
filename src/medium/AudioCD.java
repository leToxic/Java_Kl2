package medium;

public class AudioCD extends Medium{
    private double minuten;

    public AudioCD(String bezeichnung, double preis, double minuten) {
        super(bezeichnung, preis);
        if(minuten > 0.0) {
            this.minuten = minuten;
        }
    }

    public void info() {
        System.out.println(this.getBezeichnung() + "(CD), Preis: " + this.getPreis() + ", Minuten: " + this.minuten);
    }

}
