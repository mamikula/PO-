package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }


    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }

    Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }


//    public boolean equals(Object other){
//        if (other == null) return false;
//        if (this == other) return true;
//        if (!(other instanceof Vector2d that)) return false;
//        return this.x == (that.x) &&
//                this.y == (that.y);
//    }

//    public boolean equals(Object other){
//        if (other == null) return false;
//        if (this == other) return true;
//        if (!(other instanceof Vector2d)) return false;
//        Vector2d that = (Vector2d) other;
//        return this.x == (that.x) &&
//                this.y == (that.y);
//    }

    Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Vector2d that = (Vector2d) other;
        return x == that.x && y == that.y;
    }
}
