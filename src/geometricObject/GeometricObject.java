package geometricObject;

public interface GeometricObject {
    void translate(double x, double y);
    void scale(double s);
    double calcArea();
    double calcPerimeter();
}
