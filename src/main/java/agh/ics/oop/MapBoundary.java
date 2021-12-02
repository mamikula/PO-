package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver {
    SortedSet<Vector2d> xParametr;
    SortedSet<Vector2d> yParametr;
    public MapBoundary() {
        this.xParametr = new TreeSet<>(new Comparator<Vector2d>() {

            @Override
            public int compare(Vector2d o1, Vector2d o2) {
                if (o1.x < o2.x) return  -1;
                else if(o1.x == o2.x && o1.y < o2.y) return -1;
                else if (o1.x > o2.x) return 1;
                else if (o1.y > o2.y) return 1;
                else return 0;

        }
    });
        this.yParametr = new TreeSet<>(new Comparator<Vector2d>() {

            @Override
            public int compare(Vector2d o1, Vector2d o2) {
                if (o1.y < o2.y) return  -1;
                else if(o1.y == o2.y && o1.x < o2.x) return -1;
                else if (o1.y > o2.y) return 1;
                else if (o1.x > o2.x) return 1;
                else return 0;
            }
        });
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xParametr.remove(oldPosition);
        xParametr.add(newPosition);
        yParametr.remove(oldPosition);
        yParametr.add(newPosition);
    }

    public void addElement(Vector2d pos){
        xParametr.add(pos);
        yParametr.add(pos);
    }

    public Vector2d lowLeft(){
       return xParametr.first().lowerLeft(xParametr.first());
    }

    public Vector2d uppRight(){
        return xParametr.last().upperRight(xParametr.last());
    }

}
