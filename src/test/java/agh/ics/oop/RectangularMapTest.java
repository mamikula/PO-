package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    Animal a1;
    Animal a2;
    IWorldMap map;


    @Test
    void canMoveTo() {
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(10, 5)));
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));

        assertFalse(map.canMoveTo(new Vector2d(2, 1)));
        assertFalse(map.canMoveTo(new Vector2d(3, 2)));
    }

    @Test
    void place() {
        assertTrue(map.place(new Animal(map, new Vector2d(0, 0))));
        assertFalse(map.place(new Animal(map, new Vector2d(0, 0))));
        assertFalse(map.place(new Animal(map, new Vector2d(10, 10))));
        assertFalse(map.place(new Animal(map, new Vector2d(-1, -1))));
    }

    @Test
    void isOccupied() {
        assertTrue(map.isOccupied(new Vector2d(2, 1)));
        assertTrue(map.isOccupied(new Vector2d(3, 2)));
        assertFalse(map.isOccupied(new Vector2d(10, 2)));
        assertFalse(map.isOccupied(new Vector2d(4, 5)));
        assertFalse(map.isOccupied(new Vector2d(0, 0)));
    }

    @Test
    void objectAt() {
        assertEquals(a1, map.objectAt(new Vector2d(2, 1)));
        assertEquals(a2, map.objectAt(a2.getPosition()));
    }

    @BeforeEach
    void setUp() {
        map = new RectangularMap(10, 5);
        a1 = new Animal(map, new Vector2d(2, 1));
        a2 = new Animal(map, new Vector2d(3, 2));
        map.place(a1);
        map.place(a2);
//        System.out.print(map);
    }
}