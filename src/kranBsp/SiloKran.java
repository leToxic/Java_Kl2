package kranBsp;

/**
 * Created: 18.01.2022 at 15:14
 * Author: Sebastian Plasek
 */
public class SiloKran {
    private int[] silos;
    private int maximum;
    private int position;

    public SiloKran(int siloanzahl, int maximum) {
        if (siloanzahl > 0) {
            this.silos = new int[siloanzahl];
        } else if (siloanzahl <= 0) {
            this.silos = new int[10];
        }
        if (maximum > 0) {
            this.maximum = maximum;
        } else if (maximum <= 0) {
            this.maximum = 10;
        }
        this.position = 0;
    }

    public SiloKran(int siloanzahl) {
        this(siloanzahl, 0);
    }

    public SiloKran() {
        this(0, 0);
    }

    public void nachRechts(int i) {
        int test = this.silos.length;
        this.position += i;
        if (this.position < 0) {
            this.position = 0;
        } else if (this.position > this.silos.length) {
            this.position = test;
        }
    }

    public void nachLinks(int i) {
        nachRechts(-i);
    }

    public void fuell(int x) {
            this.silos[this.position] += x;
        if (this.maximum < this.silos[this.position]) {
            this.silos[this.position] = this.maximum;
        }
        if (this.silos[this.position] < 0) {
            this.silos[this.position] = 0;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public int getFuell() {
        return this.silos[this.position];
    }

    public int gibAlles() {
        int testall = this.silos[this.position];
        this.silos[this.position] = 0;
        return testall;
    }
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        int test = 1;
        for (int i = 0; i < this.silos.length; i++) {
            sb.append("Silo " + test + ":" + this.silos[i]);
            if (i == this.position) {
                sb.append(" (Kranposition)");
            }
            sb.append("\n");
            test++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SiloKran kran = new SiloKran(5, 10);
        kran.fuell(4);
        kran.fuell(1);
        kran.nachRechts(2);
        kran.fuell(20);
        kran.nachRechts(2);
        kran.fuell(1);
        kran.nachLinks(42);
        int inhalt = kran.gibAlles();
        kran.nachRechts(1);
        kran.fuell(inhalt);
        System.out.println(kran);
    }
}
