package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    String tr1;
    String tr2;
    Animal test1;
    Animal test2;
    Animal test3;
    Animal test4;
    Animal test5;
    Animal test6;
    RectangularMap map = new RectangularMap(4,4);


//    @Test
//    void move() {
//    }

    @Test
    void orientationTest(){

        test4.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, test4.getOrientation());
        test4.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.EAST, test4.getOrientation());
        test4.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, test4.getOrientation());
        test4.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.NORTH, test4.getOrientation());
        test4.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, test4.getOrientation());
        test4.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.WEST, test4.getOrientation());
        test4.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, test4.getOrientation());
        test4.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.NORTH, test4.getOrientation());
        test4.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, test4.getOrientation());
        test4.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.EAST, test4.getOrientation());
        test4.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, test4.getOrientation());
        test4.move(MoveDirection.BACKWARD);
        assertEquals(MapDirection.NORTH, test4.getOrientation());
    }

    @Test
    void positionTest(){
        test3.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 1), test3.getPosition());

        test3.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 0), test3.getPosition() );

        test3.move(MoveDirection.RIGHT);
        assertEquals(new Vector2d(2, 0), test3.getPosition());

        test3.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 0), test3.getPosition());

        test3.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 0), test3.getPosition());

        test3.move(MoveDirection.LEFT);
        assertEquals(new Vector2d( 4, 0), test3.getPosition());

        test3.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 1), test3.getPosition());
    }

    @Test
    void frontierTest(){
        test5.move(MoveDirection.FORWARD);
        test5.move(MoveDirection.FORWARD);
        test5.move(MoveDirection.FORWARD);
        test5.move(MoveDirection.FORWARD);
        test5.move(MoveDirection.FORWARD);
        assertEquals(test5.getPosition(), new Vector2d(2, 4));

        test5.move(MoveDirection.RIGHT);
        test5.move(MoveDirection.FORWARD);
        test5.move(MoveDirection.FORWARD);
        test5.move(MoveDirection.FORWARD);
        assertEquals(test5.getPosition(), new Vector2d(4, 4));

        test5.move(MoveDirection.LEFT);
        test5.move(MoveDirection.BACKWARD);
        test5.move(MoveDirection.BACKWARD);
        test5.move(MoveDirection.BACKWARD);
        test5.move(MoveDirection.BACKWARD);
        test5.move(MoveDirection.BACKWARD);
        assertEquals(test5.getPosition(), new Vector2d(4, 0));

        test6.move(MoveDirection.LEFT);
        test6.move(MoveDirection.FORWARD);
        test6.move(MoveDirection.FORWARD);
        test6.move(MoveDirection.FORWARD);
        assertEquals(test6.getPosition(), new Vector2d(0, 2));

    }

    @Test
    void testToString() {
        assertEquals(tr1, test1.toString());
        assertEquals(tr2, test2.toString());
    }

    @BeforeEach
    void setUp() {
        test1 = new Animal(map);
        test2 = new Animal(map);
        test3 = new Animal(map);
        test4 = new Animal(map);
        test5 = new Animal(map);
        test6 = new Animal(map);

        test2.move(MoveDirection.FORWARD);
        test2.move(MoveDirection.LEFT);

        tr1 = "Animal{orientation=Polnoc, position=(2,2)}";
        tr2 = "Animal{orientation=Zachod, position=(2,3)}";


    }
}