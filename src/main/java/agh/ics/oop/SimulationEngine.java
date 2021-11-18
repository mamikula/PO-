package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


public class SimulationEngine implements IEngine {

    private final List<MoveDirection> moves;
    private final IWorldMap map;
    private final Vector2d[] positions;

    public SimulationEngine(List<MoveDirection> moves, IWorldMap map, Vector2d[] positions) {
        this.moves = moves;
        this.map = map;
        this.positions = positions;

        for(Vector2d position : positions){
            map.place(new Animal(map, position));
        }
    }

    @Override
    public void run() {
        System.out.print(map);
        int i = 0;
        List<Animal> animals = new ArrayList<>();
        for (Vector2d positon : positions){
            if (map.objectAt(positon) != null){
                animals.add((Animal) map.objectAt(positon));
            }
        }
        int animalNum = animals.size();
        for (MoveDirection move : moves){
            animals.get(i % animalNum).move(move);
            System.out.print(map);
            i++;
        }
    }
}
