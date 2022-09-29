package kranBsp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created: 18.01.2022 at 16:10
 * Author: Sebastian Plasek
 */
class SiloKranTest {
    private SiloKran kran1;
    private SiloKran kran2;
    public static final int ANZAHL = 5;
    public static final double DELTA = 1E-6;

    @BeforeEach
    void setUp() {
        kran1 = new SiloKran(10, 100);
        kran2 = new SiloKran(ANZAHL);
    }

    @Test
    void nachRechts() {
        assertEquals(kran1.getPosition(), 0);
        kran1.nachRechts(3);
        assertEquals(kran1.getPosition(), 3);
        kran1.nachLinks(4);
        assertNotEquals(kran1.getPosition(), 4);
        kran1.nachRechts(111);
        assertEquals(kran1.getPosition(), 10);
        kran1.nachLinks(100);
        assertEquals(kran1.getPosition(),0);
    }

    @Test
    void nachLinks() {
        kran1.nachRechts(3);
        kran1.nachLinks(3);
        assertEquals(kran1.getPosition(), 0);
    }

    @Test
    void fuell() {
        kran1.fuell(30);
        assertEquals(kran1.getFuell(), 30);
        kran1.fuell(0);
        assertEquals(kran1.getFuell(), 30);
        kran1.fuell(100);
        assertEquals(kran1.getFuell(), 100);
        kran1.fuell(10);
        assertEquals(kran1.getFuell(), 100);
    }

    @Test
    void getPosition() {
        kran2.nachLinks(3);
        assertEquals(kran2.getPosition(), 0);
        assertNotEquals(kran2.getPosition(), 10);
    }

    @Test
    void gibAlles() {
        kran1.fuell(30);
        kran1.gibAlles();
        assertEquals(kran1.getFuell(), 0);
        kran1.fuell(10);
        assertEquals(kran1.getFuell(), 10);
        kran1.fuell(100);
        assertEquals(kran1.getFuell(), 100);
        kran1.gibAlles();
        assertEquals(kran1.getFuell(), 0);
        kran1.fuell(10);
        assertEquals(kran1.getFuell(), 10);

    }
}