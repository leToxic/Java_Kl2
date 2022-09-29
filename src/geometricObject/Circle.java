package geometricObject;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius, double zpX, double zpY) {
        super(zpX, zpY);
        setRadius(radius);
    }

    public Circle(double radius) {
        super();
        setRadius(radius);
    }

    public void setRadius(double radius) {
        if (radius < 0 || !(Double.isFinite(radius))) {
            throw new IllegalArgumentException();
        } else {
            this.radius = radius;
        }
    }

    @Override
    public void scale(double s) {
        if (s < 0 || !(Double.isFinite(s))) {
            throw new IllegalArgumentException();
        } else {
            this.radius *= s;
        }
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calcPerimeter() {
        return 2 * radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }
}
