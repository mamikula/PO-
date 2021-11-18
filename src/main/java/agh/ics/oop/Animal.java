package agh.ics.oop;

public class Animal {
    private MapDirection orientation;// = MapDirection.NORTH;
    private Vector2d position;// = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.map = map;
        this.orientation = MapDirection.NORTH;

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
                if (map.canMoveTo(position.add(orientation.toUnitVector()))) position = position.add(orientation.toUnitVector());

            }
            case BACKWARD -> {
                if (map.canMoveTo(position.subtract(orientation.toUnitVector()))) position = position.subtract(orientation.toUnitVector());

            }
        }
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }
}
