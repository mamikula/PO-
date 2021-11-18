package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {


    public RectangularMap(int width, int height){

        this.uppRight = new Vector2d(width, height);
        this.lowLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
         return super.canMoveTo(position) && position.follows(lowLeft) && position.precedes(uppRight);
    }


}