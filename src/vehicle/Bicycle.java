package vehicle;

public class Bicycle extends Vehicle {

    public Bicycle(String brand) {
        this(brand, 2);
    }

    public Bicycle(String brand, int wheels) {
        super(brand);
        setWheels(wheels);
    }

    @Override
    public void setWheels(int wheels) {
        if (wheels > 3 || wheels < 2) {
            throw new IllegalArgumentException("Falsche Reifenanzahl");
        }
        super.setWheels(wheels);
    }

}
