package vehicle;

public class Car extends Vehicle implements Motorized {
    private double power;
    private boolean started;

    public Car(String brand, double power, boolean started) {
        super(brand, 4);
        setPower(power);
        if (started) {
            start();
        } else {
            stop();
        }
    }

    public Car(String brand, double power) {
        this(brand, power, false);
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

    public void setPower(double power) {
        if (power <= 0.0) {
            throw new IllegalArgumentException("Negative Power");
        }
        this.power = power;
    }
}
