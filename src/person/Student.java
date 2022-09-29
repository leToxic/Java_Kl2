package person;

import java.util.Arrays;

public class Student extends Person {
    private int matrikln;

    public Student(String nn, String vn, int matrikln) {
        super(nn, vn);
        setMatrikln(matrikln);
    }

    public Student(String nn, String vn) {

        this(nn, vn, 00000);
    }

    public Student(String nn) {
        this(nn, "!Standardwert", 00000);
    }

    public Student() {
        this("!Standardwert");
    }

    public void setMatrikln(int matrikln) {
        if (matrikln >= 0) {
            this.matrikln = matrikln;
        }
    }

    public static Student[] filterNachname(Student[] st, String pat) {
        Student[] sf = new Student[100];
        int anz = 0;
        for (int i = 0; i < st.length; i++) {
            if (st[i].getNn().contains(pat)) {
                sf[anz] = st[i];
            }
            anz++;
            if (anz > sf.length) {
                sf = Arrays.copyOf(sf, anz * 2);
            }
        }
        for (int i = 0; i < sf.length; i++) {
            if (sf[i] == null) {
                anz = i + 1;
                sf = Arrays.copyOf(sf, anz);
            }
        }
        return sf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("; " + this.matrikln);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] vn = {"Alfred", "Bernd", "Carola", "Dieter", "Erich", "Gerda", "Hans", "Jochen", "Karin", "Maike"};
        String[] nn = {"Adler", "Baron", "Claus", "Dimov", "Eliot", "Gatti", "Heine", "Jahn", "Kozak", "Miller"};
        int[] mn = {12345, 45671, 23456, 11111, 45667, 98712, 23456, 65123, 12634, 22222};
        Student[] sf = new Student[vn.length];

        if (vn.length == nn.length && mn.length == nn.length) {
            for (int i = 0; i < sf.length; i++) {
                sf[i] = new Student(vn[i], nn[i], mn[i]);
            }
        }
        for (int i = 0; i < sf.length; i++) {
            System.out.println(sf[i]);
        }
        System.out.println("---------------");
        Student[] stest = filterNachname(sf, "us");
        for (int i = 0; i < stest.length; i++) {
            System.out.println(stest[i]);
        }
    }
}
