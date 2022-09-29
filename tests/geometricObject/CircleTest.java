package geometricObject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    public static final double DELTA = 1E-2;

    @Test
    void scale() {
        Circle rec = new Circle(3, 2, 4);
        rec.scale(2);
        assertEquals(6, rec.getRadius());
    }

    @Test
    void calcArea() {
        Circle rec = new Circle(3, 2, 4);
        assertEquals(28.274, rec.calcArea(), DELTA);
    }

    @Test
    void calcPerimeter() {
        Circle rec = new Circle(3, 2, 4);
        assertEquals(18.85, rec.calcPerimeter(), DELTA);
    }

    @Test
    void trans() {
        Circle rec = new Circle(3, 2, 4);
        rec.translate(3, -2);
        assertEquals(5, rec.getZpX());
        assertEquals(2, rec.getZpY());
    }
}