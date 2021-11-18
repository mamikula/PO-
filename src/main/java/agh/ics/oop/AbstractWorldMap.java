package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animals = new ArrayList<>();
    protected Vector2d uppRight;
    protected Vector2d lowLeft;


    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals){
            if(animal.getPosition().equals(position)) return animal;
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) || objectAt(position) instanceof Grass;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if (canMoveTo(pos)){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals){
            if(animal.getPosition().equals(position)) return true;
        }
        return false;
    }
    public String toString() {
        return new MapVisualizer(this).draw(lowLeft, uppRight);
    }
}
