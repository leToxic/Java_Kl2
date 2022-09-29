package geometricObject;

public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double zpX, double zpY, double width, double height) {
        super(zpX, zpY);
        setWidth_Height(width, height);
    }

    public Rectangle(double width, double height) {
        super();
        setWidth_Height(width, height);
    }

    public void setWidth_Height(double width, double height) {
        if (width < 0 && height < 0 || !(Double.isFinite(width) || !(Double.isFinite(height)))) {
            throw new IllegalArgumentException();
        } else {
            this.height = height;
            this.width = width;
        }
    }

    @Override
    public void scale(double s) {
        if (s < 0 || !(Double.isFinite(s))) {
            throw new IllegalArgumentException();
        } else {
            this.width *= s;
            this.height *= s;
        }
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public double calcPerimeter() {
        return 2 * width + 2 * height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
