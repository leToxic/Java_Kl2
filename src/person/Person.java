package person;


public class Person {
    private String vn;
    private String nn;

    public Person(String nn, String vn) {
        setVn(vn);
        setNn(nn);
    }

    public Person(String nn) {
        this(nn, "!Standardwert");
    }

    public Person() {
        this("!Standardwert", "!Standardwert");
    }


    public void setVn(String vn) {
        this.vn = vn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }

    public String getNn() {
        return nn;
    }

    public String getVn() {
        return vn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nn + " " + this.vn);
        return sb.toString();
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setNn("Lothar");
        p1.setVn("Friedl");
        System.out.println("Vorname: " + p1.getVn());
        System.out.println("Nachname: " + p1.getNn());
        Person p2 = new Person("Klammer", "Franz");
        System.out.println(p2);
    }
}
