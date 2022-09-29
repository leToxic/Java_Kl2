package geometricObject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void setWidth_Height() {
        Rectangle rec = new Rectangle(3, 2, 4, 4);
        rec.translate(3, -3);
        assertEquals(6, rec.getZpX());
        assertEquals(-1, rec.getZpY());
    }

    @Test
    void scale() {
        Rectangle rec = new Rectangle(3, 2, 4, 4);
        rec.scale(2);
        assertEquals(8, rec.getWidth());
    }

    @Test
    void calcArea() {
        Rectangle rec = new Rectangle(3, 2, 4, 4);
        assertEquals(16, rec.calcArea());
    }

    @Test
    void calcPerimeter() {
        Rectangle rec = new Rectangle(3, 2, 4, 4);
        assertEquals(16, rec.calcPerimeter());
    }

    @Test
    void trans() {
        Rectangle rec = new Rectangle(3, 2, 4, 4);
        rec.translate(3, -2);
        assertEquals(6, rec.getZpX());
        assertEquals(0, rec.getZpY());
    }
}