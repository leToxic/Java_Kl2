package speak;

public class Dog implements Speaker{
    private String speak;

    public Dog(String speak) {
        this.speak = speak;
    }

    public Dog() {
        this("Bark");
    }

    public String speak() {
        return "Dog speaks " + this.speak;
    }
}
