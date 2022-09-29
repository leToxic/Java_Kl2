package geometricObject;

abstract class Figure implements GeometricObject {
    private double zpX;
    private double zpY;

    public Figure(double zpX, double zpY) {
        if (zpX == Double.NaN || zpY == Double.NaN) {
            throw new IllegalArgumentException();
        } else {
            this.zpX = zpX;
            this.zpY = zpY;
        }
    }

    public Figure() {
        this.zpX = 0;
        this.zpY = 0;
    }

    @Override
    public void translate(double x, double y) {
        if (x == Double.NaN || y == Double.NaN || !(Double.isFinite(x) || !(Double.isFinite(y)))) {
            throw new IllegalArgumentException();
        } else {
            this.zpX += x;
            this.zpY += y;
        }
    }

    public double getZpX() {
        return zpX;
    }

    public double getZpY() {
        return zpY;
    }
}
