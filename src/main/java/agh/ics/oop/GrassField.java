package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;


public class GrassField extends AbstractWorldMap {
    private int fields;
    private List<Grass> grasses;
    private final List<Animal> animals;


    public GrassField(int fields){
        this.fields = fields;
        this.grasses = new ArrayList<>();
        this.uppRight = new Vector2d(0, 0);
        this.lowLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.animals = super.animals;
    }

    private void Corners(Vector2d position){
        if( !position.precedes(uppRight)) uppRight = position.upperRight(uppRight);
        if( !position.follows(lowLeft)) lowLeft = position.lowerLeft(lowLeft);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object instanceof Animal) return object;
        for (Grass grass : grasses){
            if(grass.getPosition().equals(position)) return grass;
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(super.canMoveTo(position)){
            System.out.println(position);
            Corners(position);
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(super.place(animal)) {
            Corners(animal.getPosition());
            return true;
        };
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean object = super.isOccupied(position);
        if (object) return true;
        for (Grass q : grasses){
            if(q.getPosition().equals(position)) return true;
        }
        return false;
    }


    public boolean placeGrass(Grass grass) {
        Vector2d pos = grass.getPosition();
        if ((isOccupied(pos)) || (pos.precedes(new Vector2d(-1, -1)))) return false;
        grasses.add(grass);
        Corners(grass.getPosition());
        return true;
    }

    public void plant(){
        Random generator = new Random();
        for (int i = 0; i < fields; i++){
            int x = generator.nextInt((int) Math.sqrt(fields*10));
            int y = generator.nextInt((int) Math.sqrt(fields*10));
            Vector2d tmp = new Vector2d(x, y);
            if (!isOccupied(tmp)){
                placeGrass(new Grass(tmp));
//                System.out.println(tmp);
                Corners(tmp);
            }
            else i--;
        }
    }

    public List<Grass> getGrasses() {
        return grasses;
    }
}
