package potion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created: 25.01.2022 at 16:20
 * Author: Sebastian Plasek
 */
class PotionTest {
    private Potion pot1;
    public static final double DELTA = 1E-6;

    @BeforeEach
    void setUp() {
        Ingredient ing1 = new Ingredient("Ecs");
        Ingredient ing2 = new Ingredient("Ta");
        Ingredient ing3 = new Ingredient("Sy");
        pot1 = new Potion(ing1, ing2, ing3);
    }

    @Test
    void stir() {
        pot1.stir();
        assertEquals(1, pot1.getStir());
        pot1.stir();
        assertNotEquals(3, pot1.getStir());
    }

    @Test
    void isFertig() {
        pot1.stir();
        pot1.stir();
        assertEquals(false, pot1.isFertig());
        pot1.stir();
        assertNotEquals(true, pot1.isFertig());
        pot1.stir();
        pot1.stir();
        assertEquals(true, pot1.isFertig());
    }

    @Test
    void power() {
        pot1.stir();
        assertEquals(7, pot1.power());
        pot1.stir();
        pot1.stir();
        assertNotEquals(14, pot1.power());
        pot1.stir();
        pot1.stir();
        assertEquals(14, pot1.power());
    }
}