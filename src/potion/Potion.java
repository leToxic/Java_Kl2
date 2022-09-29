package potion;

/**
 * Created: 25.01.2022 at 15:32
 * Author: Sebastian Plasek
 */
public class Potion {
    private Ingredient[] zutaten;
    private boolean fertig;
    private int umgeruehrt;

    public Potion(Ingredient ing1, Ingredient ing2, Ingredient ing3) {
        this.zutaten = new Ingredient[3];
        setZutat(ing1);
        setZutat(ing2);
        setZutat(ing3);
        this.fertig = false;
        this.umgeruehrt = 0;
    }

    private void setZutat(Ingredient ing) {
        for (int i = 0; i < zutaten.length; i++) {
            if (zutaten[i] == null) {
                zutaten[i] = ing;
                return;
            }
        }
    }

    public void stir() {
        umgeruehrt++;
    }

    public int getStir() {
        return this.umgeruehrt;
    }

    public boolean isFertig() {
        if (umgeruehrt >= 5) {
            fertig = true;
        }
        return fertig;
    }

    public int power() {
        if (umgeruehrt >= 5) {
            fertig = true;
        }
        int power = 0;
        if (fertig) {
            for (int i = 0; i < zutaten.length; i++) {
                if (zutaten[i] != null) {
                    power += zutaten[i].power();
                }
            }
            return 2 * power;
        } else {
            for (int i = 0; i < zutaten.length; i++) {
                if (zutaten[i] != null) {
                    power += zutaten[i].power();
                }
            }
            return power;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < zutaten.length; i++) {
            int test = i;
            test += 1;
            sb.append("Zutat " + test + ": " + zutaten[i] +  ", ");
        }
        sb.append("| Power: " + this.power());
        sb.append(" | Fertig: ");
        if (fertig) {
            sb.append("Ja");
        } else {
            sb.append("Nein");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Ingredient ing1 = new Ingredient("Toad");
        Ingredient ing2 = new Ingredient("Lizard");
        Ingredient ing3 = new Ingredient("Spider");

        ing1.setZutat("Fly");
        Potion potion = new Potion(ing1, ing2, ing3);

        potion.stir();
        potion.stir();
        potion.stir();
        System.out.println(potion);
        potion.stir();
        potion.stir();
        System.out.println(potion);
    }
}
