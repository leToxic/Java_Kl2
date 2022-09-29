package vehicle;


import java.util.Arrays;
import java.util.Random;

public abstract class Vehicle {
    public static final String[] CAR_BRANDS = {"BMW", "Honda", "Suzuki",
            "VW", "Ferrari", "Alfa Romeo", "Mercedes", "Maserati", "Tesla"};
    public static final String[] MOTORCYCLE_BRANDS = {"BMW", "Honda", "Suzuki",
            "Ducati", "Moto Guzzi", "Kawasaki"};
    public static final String[] BICYCLE_BRANDS = {"Bianchi", "Giant", "Trek", "Scott", "Fuji"};
    private static final Random RANDOM = new Random(5);
    private String brand;
    private int wheels;

    public Vehicle(String brand, int wheels) {
        setBrand(brand);
        setWheels(wheels);
    }

    public Vehicle(String brand) {
        setBrand(brand);
    }

    public static int countMotorized(Vehicle[] vehicles) {
        int anz = 0;
        for (Vehicle i : vehicles) {
            if (i instanceof Motorized) {
                anz += 1;
            }
        }
        return anz;
    }

    public static Vehicle[] getStartedCars(Vehicle[] vehicles) {
        Vehicle[] ret = new Vehicle[vehicles.length];
        int app = 0;
        for (Vehicle i : vehicles) {
            if (i instanceof Car) {
                if (((Car) i).isStarted()) {
                    ret[app] = i;
                    app += 1;
                }
            }
        }
        ret = Arrays.copyOf(ret, app);
        return ret;
    }

    public static Vehicle[] getNRandom(int n) {
        Vehicle[] ret = new Vehicle[n];
        for (int i = 0; i < n; i++) {
            int rand = RANDOM.nextInt();
            if (rand % 2 == 0) {
                Car app = new Car(CAR_BRANDS[rand + 4], rand * 30, false);
                ret[i] = app;
            } else if (rand % 2 == 1) {
                Motorcycle app = new Motorcycle(MOTORCYCLE_BRANDS[rand + 1], rand * 15);
                ret[i] = app;
            } else {
                Bicycle app = new Bicycle(BICYCLE_BRANDS[rand - 3]);
                ret[i] = app;
            }
        }
        return ret;
    }

    public void setWheels(int wheels) {
        if (wheels <= 0) {
            throw new IllegalArgumentException("0 Reifen");
        }
        this.wheels = wheels;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public int getWheels() {
        return wheels;
    }
}