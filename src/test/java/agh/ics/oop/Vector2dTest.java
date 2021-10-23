package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    Vector2d x = new Vector2d(2, 1);
    Vector2d y = new Vector2d(1, 2);

    Vector2d a = new Vector2d(2, 2);
    Vector2d b = new Vector2d(2, 2);

    @Test
    void testToString() {
        assertEquals(x.toString(), "(2,1)" );
        assertEquals(y.toString(), "(1,2)" );
    }

    @Test
    void precedes() {
        assertFalse(x.precedes(y));
    }

    @Test
    void follows() {
        assertFalse(x.follows(y));
    }

    @Test
    void upperRight() {
        assertEquals(x.upperRight(y), new Vector2d(2, 2));
    }

    @Test
    void lowerLeft() {
        assertEquals(x.lowerLeft(y), new Vector2d(1, 1));
    }

    @Test
    void add() {
        assertEquals(x.add(y), new Vector2d(3, 3));
    }

    @Test
    void subtract() {
        assertEquals(x.subtract(y), new Vector2d(1, -1));
    }

    @Test
    void opposite() {
        assertEquals(x.opposite(), new Vector2d(-2, -1));
        assertEquals(y.opposite(), new Vector2d(-1, -2));
    }

    @Test
    void testHashCode() {
        if(a.equals(b)){
            assertEquals(a.hashCode(), b.hashCode());
        }
    }

    @Test
    void testEquals() {
        assertFalse(x.equals(y));
        assertNotEquals(x, null);
        assertNotEquals(x, "asd");
        assertNotEquals(true, null);
        assertTrue(a.equals(b));
    }
}