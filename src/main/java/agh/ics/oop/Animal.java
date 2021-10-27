package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);


    @Override
    public String toString() {
        return "Animal{" +
                "orientation=" + orientation +
                ", position=" + position +
                '}';
    }
    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newVector = this.position.add(this.orientation.toUnitVector());
                if (!(newVector.x > 4 || newVector.x < 0 || newVector.y > 4 || newVector.y < 0)){
                    this.position = this.position.add(this.orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                Vector2d newVector = this.position.subtract(this.orientation.toUnitVector());
                if (!(newVector.x > 4 || newVector.x < 0 || newVector.y > 4 || newVector.y < 0)) {
                    this.position = this.position.subtract(this.orientation.toUnitVector());
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
}
