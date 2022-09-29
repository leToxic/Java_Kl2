package potion;

/**
 * Created: 25.01.2022 at 15:23
 * Author: Sebastian Plasek
 */
public class Ingredient {
    private String zutat;
    private int staerke;

    public Ingredient(String zutat) {
        setZutat(zutat);
        setStaerke(zutat);
    }

    public Ingredient() {
        this("Zutat");
    }

    public void setZutat(String zutat) {
        if (zutat.length() > 0) {
            this.zutat = zutat;
        }
    }

    private void setStaerke(String zutat) {
        this.staerke = zutat.length();
    }

    public int power() {
        return this.zutat.length();
    }

    public String getZutat() {
        StringBuilder sb = new StringBuilder("");
        sb.append(this.zutat);
        return sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Zutatname: " + this.zutat);
        return sb.toString();
    }
}
