package agh.ics.oop;

import java.util.*;
import java.lang.Math;


public class GrassField extends AbstractWorldMap {
    private int fields;
    private Map<Vector2d, Grass> grasses;
    protected Vector2d uppRight;
    protected Vector2d lowLeft;
    private MapBoundary mapBoundary;

    public GrassField(int fields){
        this.fields = fields;
        this.grasses = new LinkedHashMap<>();
        this.uppRight = new Vector2d(0, 0);
        this.lowLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.mapBoundary = new MapBoundary();
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

    @Override
    public boolean place(Animal animal) {
        if(super.place(animal)){
            animal.addObserver(mapBoundary);
            mapBoundary.addElement(animal.getPosition());
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition() +" is occupied position");
    }

    protected boolean placeGrass(Grass grass) {
        Vector2d pos = grass.getPosition();
        if ((isOccupied(pos)) || (pos.precedes(new Vector2d(-1, -1)))) return false;//throw new IllegalArgumentException(pos +" is occupied position");
        grasses.put(grass.getPosition(), grass);
        mapBoundary.addElement(grass.getPosition());
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

        return new MapVisualizer(this).draw(mapBoundary.lowLeft(), mapBoundary.uppRight());
    }
}
