package agh.ics.oop;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    private GrassField field;
    private GrassField field2;
    private int num;
    private List<Grass> grasses;

    private List<Animal> animals;
    private List<MoveDirection> directions;
    private IEngine engine;
    private Vector2d[] positions;
    Vector2d newUR;
    Vector2d newLL;

    Animal a1;
    Animal a2;
    GrassField map;

    @Test
    void Corners(){
        engine.run();
        assertEquals(field2.uppRight, newUR);
        assertEquals(field2.lowLeft, newLL);
    }

    @Test
    void objectAt() {
        assertEquals(a1, map.objectAt(new Vector2d(2, 1)));
        assertEquals(a2, map.objectAt(a2.getPosition()));
    }

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
    void isOccupied() {
        assertTrue((map.isOccupied(new Vector2d(2, 1))) && (map.objectAt(new Vector2d(2, 1)) instanceof Animal));
        assertTrue((map.isOccupied(new Vector2d(3, 2))) && (map.objectAt(new Vector2d(3, 2)) instanceof Animal));
        assertFalse((map.isOccupied(new Vector2d(10, 2))) && (map.objectAt(new Vector2d(10, 2)) instanceof Animal));
        assertFalse((map.isOccupied(new Vector2d(4, 5))) && (map.objectAt(new Vector2d(4, 5)) instanceof Animal));
        assertFalse((map.isOccupied(new Vector2d(0, 0))) && (map.objectAt(new Vector2d(0, 0)) instanceof Animal));
    }

    @Test
    void place(){
        assertFalse(map.place(new Animal(map, new Vector2d(2, 1))));
        assertTrue(map.place(new Animal(map, new Vector2d(9, 9))));
        assertTrue(map.place(new Animal(map, new Vector2d(-1, -1))));
        assertFalse(map.place(new Animal(map, new Vector2d(3, 2))));
    }

    @BeforeEach
    void setUp() {
//        num = 10;
//        field = new GrassField(num);
//        field.plant();
//        grasses = field.getGrasses();
//        System.out.print(field);

//        do zmieniania rozmiarów mapy
        field2 = new GrassField(4);
        positions = new Vector2d[]{new Vector2d(0, 3), new Vector2d(3, 0)};
        directions = new OptionsParser().parse(new String[]{"f", "r", "l", "f", "f", "b", "b"});
        newLL = new Vector2d(0, 0);
        newUR = new Vector2d(3, 4);
        engine = new SimulationEngine(directions, field2, positions);
        animals = new ArrayList<>();
        animals.add((Animal) field2.objectAt(new Vector2d(0, 3)));
        animals.add((Animal) field2.objectAt(new Vector2d(3, 0)));
//        System.out.print(field2);


        map = new GrassField(10);
        a1 = new Animal(map, new Vector2d(2, 1));
        a2 = new Animal(map, new Vector2d(3, 2));
        map.place(a1);
        map.place(a2);
        map.plant();
//        System.out.print(map);
    }

}