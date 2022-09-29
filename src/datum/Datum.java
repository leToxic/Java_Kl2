package datum;

/**
 * Created: 31.05.2022 at 15:12
 *
 * @author Plasek Sebastian
 */

import java.time.LocalDate;

public class Datum {

    public final static int FORMAT_SHORT = 0;
    public final static int FORMAT_NORMAL = 1;
    public final static int FORMAT_LONG = 2;
    public final static int FORMAT_US = 3;

    private int tag = 0;
    private int monat = 0;
    private int jahr = 0;

    public Datum() {
        LocalDate today = LocalDate.now();
        tag = today.getDayOfMonth();
        monat = today.getMonthValue();
        jahr = today.getYear();
    }

    public Datum(String dateString) {
        if (dateString == null || dateString.length() != 10)
            throw new IllegalArgumentException();
        String[] arr = dateString.split("\\.");
        if (arr.length != 3) {
            throw new IllegalArgumentException();
        }
        int tag = Integer.parseInt(arr[0]);
        int monat = Integer.parseInt(arr[1]);
        int jahr = Integer.parseInt(arr[2]);
        if (isValid(tag, monat, jahr)) {
            this.tag = tag;
            this.monat = monat;
            this.jahr = jahr;
        } else {
            throw new IllegalArgumentException();
        }
    }


    public Datum(int tage) {
        this.tag = 1;
        this.monat = 1;
        this.jahr = 1900;
        if (tage < 0)
            throw new IllegalArgumentException();
        addiereTage(tage);
    }

    public Datum(int tag, int monat, int jahr) {
        if (isValid(tag, monat, jahr)) {
            this.tag = tag;
            this.monat = monat;
            this.jahr = jahr;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isValid(int tag, int monat, int jahr) {
        if (tag < 1 || tag > 31)
            return false;
        if (monat < 1 || monat > 12)
            return false;
        if (jahr < 1900 || jahr > 3000)
            return false;
        return tag <= lastDayofMonth(monat, jahr);
    }


    public static int tageZwischen(Datum d1, Datum d2) {
        int count = 0;
        Datum greater = d1.compareTo(d2) < 0 ? d2 : d1;
        Datum smaller;
        if (d1.compareTo(d2) < 0) {
            smaller = d1;
        } else {
            smaller = d2;
        }
        smaller = new Datum(smaller.tag, smaller.monat, smaller.jahr);
        while (!smaller.equals(greater)) {
            smaller.addiereTage(1);
            count++;
        }
        return d1.compareTo(d2) < 0 ? count : -count;
    }


    public static boolean isSchaltjahr(int jahr) {
        return (((jahr % 4 == 0) && (jahr % 100 != 0)) || (jahr % 400 == 0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Datum datum = (Datum) o;
        return tag == datum.tag &&
                monat == datum.monat &&
                jahr == datum.jahr;
    }

    public String getMonatAsString() {
        String[] MONTHS = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
                "August", "September", "Oktober", "November", "Dezember"};
        return MONTHS[monat - 1];
    }

    public void addiereTage(int t) {
        int tag = this.tag;
        int monat = this.monat;
        int jahr = this.jahr;
        if (t < 0) {
            t = t * -1;
            for (int i = 0; i < t; i++) {
                tag--;
                if (!isValid(tag, monat, jahr)) {
                    monat--;
                    tag = lastDayofMonth(monat, jahr);
                    if (!isValid(tag, monat, jahr)) {
                        monat = 12;
                        jahr--;
                        if (!isValid(tag, monat, jahr)) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < t; i++) {
                tag++;
                if (!isValid(tag, monat, jahr)) {
                    tag = 1;
                    monat++;
                    if (!isValid(tag, monat, jahr)) {
                        monat = 1;
                        jahr++;
                        if (!isValid(tag, monat, jahr)) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        }
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    private int lastDayofMonth(int monat, int jahr) {
        switch (monat) {
            case 1:
                return 31;
            case 2:
                return isSchaltjahr(jahr) ? 29 : 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 31;
        }

    }


    public int wochentagNummer() {
        int a = this.jahr - 1;
        Datum d2 = new Datum(1, 1, this.jahr);
        int d = Math.abs(tageZwischen(this, d2));
        return (a + (a / 4) - (a / 100) + (a / 400) + d) % 7;
    }

    public String wochentag() {
        String[] DAYS = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
        return DAYS[wochentagNummer()];
    }

    public int compareTo(Datum d) {
        if (this.jahr < d.jahr) {
            return -1;
        } else if (this.jahr > d.jahr) {
            return +1;
        } else {
            if (this.monat < d.monat) {
                return -1;
            } else if (this.monat > d.monat) {
                return +1;
            } else {
                if (this.tag < d.tag) {
                    return -1;
                } else if (this.tag > d.tag) {
                    return +1;
                } else {
                    return 0;
                }
            }
        }
    }


    @Override
    public String toString() {
        String tag = String.format("%02d", this.tag);
        String monat = String.format("%02d", this.monat);
        return tag + "." + monat + "." + this.jahr;
    }


    public String toString(int format) {
        if (format == Datum.FORMAT_SHORT) {
            String tag = String.format("%02d", this.tag);
            String monat = String.format("%02d", this.monat);
            String jahr = String.valueOf(this.jahr).substring(2);
            return tag + "." + monat + "." + jahr;
        } else if (format == Datum.FORMAT_NORMAL) {
            return this.toString();
        } else if (format == Datum.FORMAT_LONG) {
            String tag = String.format("%02d", this.tag);
            return tag + "." + getMonatAsString() + " " + this.jahr + ", " + wochentag();
        } else if (format == Datum.FORMAT_US) {
            String tag = String.format("%02d", this.tag);
            String monat = String.format("%02d", this.monat);
            return this.jahr + "/" + tag + "/" + monat;
        }
        throw new IllegalArgumentException();
    }
}
