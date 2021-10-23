package agh.ics.oop;


public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static void main(String[] args) {
        MapDirection polnoc = NORTH;
        System.out.println(polnoc.toString());
        System.out.println(polnoc.next());
        System.out.println(polnoc.previous());
        System.out.println(polnoc.toUnitVector());
    }

    public String toString(){
        return switch (this){
            case NORTH -> "Północ";
            case EAST -> "Wschód";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
        };
    }
    public MapDirection next(){
        return switch (this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public MapDirection previous(){
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

    public Vector2d toUnitVector(){
        return switch (this) {
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
        };
    }
}
