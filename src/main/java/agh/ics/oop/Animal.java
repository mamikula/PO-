package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    private List<IPositionChangeObserver> subscribers;



    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.map = map;
        this.orientation = MapDirection.NORTH;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return orientation.toString();
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                if (map.canMoveTo(position.add(orientation.toUnitVector()))){
                    Vector2d oldPos = position;
                    position = position.add(orientation.toUnitVector());
                    positionChanged(oldPos, oldPos.add(orientation.toUnitVector()));
                }

            }
            case BACKWARD -> {
                if (map.canMoveTo(position.subtract(orientation.toUnitVector()))){
                    Vector2d oldPos = position;
                    position = position.subtract(orientation.toUnitVector());
                    positionChanged(oldPos, oldPos.subtract(orientation.toUnitVector()));
                }
            }
        }
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void addObserver(IPositionChangeObserver observer){
        this.subscribers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.subscribers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver subscriber : subscribers){
            subscriber.positionChanged(oldPosition, newPosition);
        }
    }
}
