package speak;

public class Cat implements Speaker {
    private String speak;

    public Cat(String speak) {
        this.speak = speak;
    }

    public Cat() {
        this("Meow");
    }

    public String speak() {
        return "Cat speaks " + this.speak;
    }
}
