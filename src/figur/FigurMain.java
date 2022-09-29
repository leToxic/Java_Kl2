package figur;

public class FigurMain {
    public static void main(String[] args) {
        char[] art = {'k', 'q', 'q', 'q', 'k', 'q', 'k', 'k', 'q', 'q'};
        double[] len = {3.8, 3.6, 2.5, 1.2, 4.5, 3.7, 4.5, 5.2, 3.8, 1.5};

        if (art.length == len.length) {
            Figur2D[] figuren = new Figur2D[art.length];

            for (int i = 0; i < figuren.length; i++) {
                if (art[i] == 'k') {
                    figuren[i] = new Kreis(len[i]);
                } else if (art[i] == 'q') {
                    figuren[i] = new Quadrat(len[i]);
                } else {
                    System.out.println("Fehler mit Element");
                }
            }

            double sumKreisf = 0.0;
            double sumQuadratu = 0.0;

            for (Figur2D f : figuren) {
                f.info();

                if (f.getClass() == Kreis.class) {
                    sumKreisf += f.flaeche();
                }

                if (f.getClass() == Quadrat.class) {
                    sumQuadratu += f.umfang();
                }
            }

            System.out.println("Summe der Kreisflaechen: " + sumKreisf);
            System.out.println("Summe der Quadratumfaenge: " + sumQuadratu);
        }
    }
}
