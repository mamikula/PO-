package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {
    @Test void next(){
        assertEquals(MapDirection.NORTH , MapDirection.WEST.next());
        assertEquals(MapDirection.SOUTH , MapDirection.EAST.next());
        assertEquals(MapDirection.WEST , MapDirection.SOUTH.next());
        assertEquals(MapDirection.EAST , MapDirection.NORTH.next());
    }
    @Test void previous(){
        assertEquals(MapDirection.WEST , MapDirection.NORTH.previous());
        assertEquals(MapDirection.SOUTH , MapDirection.WEST.previous());
        assertEquals(MapDirection.EAST , MapDirection.SOUTH.previous());
        assertEquals(MapDirection.NORTH , MapDirection.EAST.previous());
    }

}
