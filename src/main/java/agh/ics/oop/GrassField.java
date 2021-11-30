package agh.ics.oop;

import java.util.*;
import java.lang.Math;


public class GrassField extends AbstractWorldMap {
    private int fields;
    private Map<Vector2d, Grass> grasses;
    protected Vector2d uppRight;
    protected Vector2d lowLeft;

    public GrassField(int fields){
        this.fields = fields;
        this.grasses = new LinkedHashMap<>();
        this.uppRight = new Vector2d(0, 0);
        this.lowLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private void Corners() {
        this.uppRight = new Vector2d(0, 0);
        this.lowLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Vector2d key: grasses.keySet()) {
            Vector2d pos = key;
            if (!pos.precedes(uppRight)) uppRight = pos.upperRight(uppRight);
            if (!pos.follows(lowLeft)) lowLeft = pos.lowerLeft(lowLeft);
        }

        for (Vector2d key: animals.keySet()){
            Vector2d pos = key;
            if (!pos.precedes(uppRight)) uppRight = pos.upperRight(uppRight);
            if (!pos.follows(lowLeft)) lowLeft = pos.lowerLeft(lowLeft);
        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object instanceof Animal) return object;
        return grasses.get(position);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        boolean object = super.isOccupied(position);
        if (object) return true;
        return grasses.containsKey(position);
    }


    protected boolean placeGrass(Grass grass) {
        Vector2d pos = grass.getPosition();
        if ((isOccupied(pos)) || (pos.precedes(new Vector2d(-1, -1)))) return false;
        grasses.put(grass.getPosition(), grass);
        return true;
    }

    protected void plant(){
        Random generator = new Random();
        for (int i = 0; i < fields; i++){
            int x = generator.nextInt((int) Math.sqrt(fields*10));
            int y = generator.nextInt((int) Math.sqrt(fields*10));
            Vector2d tmp = new Vector2d(x, y);
            if (!isOccupied(tmp)){
                placeGrass(new Grass(tmp));
//                System.out.println(tmp);
            }
            else i--;
        }
    }
    @Override
    public String toString(){
        Corners();
//        return super.toString();
        return new MapVisualizer(this).draw(this.lowLeft, this.uppRight);
    }
}
