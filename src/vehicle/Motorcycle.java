package vehicle;

public class Motorcycle extends Bicycle implements Motorized {
    private double power;
    private boolean started;

    public Motorcycle(String brand, int wheels, double power, boolean started) {
        super(brand, wheels);
        setPower(power);
        if (started) {
            start();
        } else {
            stop();
        }

    }

    public Motorcycle(String brand, double power) {
        this(brand, 2, power, false);
    }

    public void setPower(double power) {
        if (power <= 0.0) {
            throw new IllegalArgumentException("Negative Power");
        }
        this.power = power;
    }

    @Override
    public void start() {
        this.started = true;
    }

    @Override
    public void stop() {
        this.started = false;
    }

    @Override
    public boolean isStarted() {
        return this.started;
    }

    @Override
    public double getPower() {
        return this.power;
    }
}
