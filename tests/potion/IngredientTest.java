package potion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created: 25.01.2022 at 16:36
 * Author: Sebastian Plasek
 */
class IngredientTest {
    private Ingredient ing1;
    public static final double DELTA = 1E-6;

    @BeforeEach
    void setUp() {
        ing1 = new Ingredient("Olive");
    }

    @Test
    void setZutat() {
        assertEquals("Olive", ing1.getZutat());
        ing1.setZutat("Ulive");
        assertNotEquals("Olive", ing1.getZutat());
        assertEquals("Ulive", ing1.getZutat());
    }

    @Test
    void power() {
        assertEquals(5, ing1.power());
        ing1.setZutat("Halo");
        assertNotEquals(5, ing1.power());
        assertEquals(4, ing1.power());
    }
}