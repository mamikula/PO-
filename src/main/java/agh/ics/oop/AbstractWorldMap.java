package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IPositionChangeObserver ,IWorldMap {

    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
//    nie powinno tu tego być, wystarczy że to jest w GrassField
//    protected Vector2d uppRight;
//    protected Vector2d lowLeft;

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        animals.put(newPosition, animals.get(oldPosition));
        animals.remove(oldPosition, animals.get(oldPosition));
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) || objectAt(position) instanceof Grass;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if (canMoveTo(pos)){
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Vector2d key: animals.keySet()){
            if(key.equals(position)) return true;
        }
        return false;
    }

    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(4, 4));
    }
}
