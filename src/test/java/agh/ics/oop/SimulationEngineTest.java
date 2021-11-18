package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    private List<MoveDirection> directions1;
    private List<MoveDirection> directions2;
    private IWorldMap map1;
    private IWorldMap map2;
    private Vector2d[] positions;
    private IEngine engine1;
    private IEngine engine2;
    private List<Animal> animals1;
    private List<Animal> animals2;


    @Test
    void run(){
        engine1.run();
        assertEquals(animals1.get(0), map1.objectAt(new Vector2d(2, 3)));
        assertEquals(animals1.get(1), map1.objectAt(new Vector2d(3, 3)));

        engine2.run();
        assertEquals(animals2.get(0), map2.objectAt(new Vector2d(2, 0)));
        assertEquals(animals2.get(1), map2.objectAt(new Vector2d(3, 5)));
    }

    @BeforeEach
     void setUp() {
        positions = new Vector2d[]{new Vector2d(2,2), new Vector2d(3,4)};


        directions1 = new OptionsParser().parse(new String[] {"f", "b", "r", "l"});
        map1 = new RectangularMap(10, 5);
        engine1 = new SimulationEngine(directions1, map1, positions);
        animals1 = new ArrayList<Animal>();
        animals1.add((Animal) map1.objectAt(new Vector2d(2, 2)));
        animals1.add((Animal) map1.objectAt(new Vector2d(3, 4)));


        directions2 = new OptionsParser().parse(new String[] {"f", "b", "r", "l","f","f","r","r","f","f","f","f","f","f","f","f"});
        map2 = new RectangularMap(10, 5);
        engine2 = new SimulationEngine(directions2, map2, positions);
        animals2 = new ArrayList<Animal>();
        animals2.add((Animal) map2.objectAt(new Vector2d(2, 2)));
        animals2.add((Animal) map2.objectAt(new Vector2d(3, 4)));

    }
}