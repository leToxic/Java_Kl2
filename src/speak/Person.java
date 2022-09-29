package speak;

import java.util.Random;

public class Person implements Speaker {
    private String speak;
    private boolean mute;
    private String nm;

    public Person(String speak, String nm) {
        Random rnd = new Random();
        this.nm = nm;
        this.speak = speak;
        this.mute = rnd.nextInt(100) >= 95;
    }

    public Person() {
        this("Hello", "Hugo");
    }

    public String speak() throws MuteException {
        if (!mute) {
            return this.nm + " speaks " + this.speak;
        } else {
            throw new MuteException(this);
        }
    }

    public String getNm() {
        return nm;
    }
}
