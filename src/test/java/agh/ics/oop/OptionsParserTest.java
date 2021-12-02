package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    private OptionsParser parser;
    private String[] test1;
    private String[] test2;
    private String[] test3;
    private List<MoveDirection> tr1;
    private List<MoveDirection> tr2;
    private List<MoveDirection> tr3;

    @Test
    void parse(){
        assertEquals(tr1, parser.parse(test1));
        assertEquals(tr2, parser.parse(test2));
        assertEquals(tr3, parser.parse(test3));
    }

    @BeforeEach
    void setUp() {
        parser = new OptionsParser();
        test1 = new String[]{"l", "backward", "r", "forward", "r", "l", "b"};
        test2 = new String[]{"r", "r", "r", "r", "f", "left"};
        test3 = new String[]{"f", "f", "f", "f"};


        tr1 = List.of(MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.BACKWARD);
        tr2 = List.of(MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT);
        tr3 = List.of(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD);
    }
}