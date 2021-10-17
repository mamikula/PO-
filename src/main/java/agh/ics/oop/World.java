package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("start");
        Direction[] dir = string_to_enum(new String[]{"f", "b", "s"});
        run(dir);
        System.out.println("stop");
    }
    static void run(Direction[] args){
        for(Direction arg : args){
            switch (arg) {
                case FORWARD -> System.out.println("zwierzak idzie do przodu");
                case BACKWARD -> System.out.println(" zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("zwierzak skręca w prawo");
                case LEFT -> System.out.println("zwierzak skręca w lewo");
            }

        }
    }
    static Direction[] string_to_enum(String[] args){
        int size = args.length;
        Direction[] dir = new Direction[size];
        for(int i = 0; i < size; i++){
            String arg = args[i];
            switch (arg){
                case "f" -> dir[i] = Direction.FORWARD;
                case "b" -> dir[i] = Direction.BACKWARD;
                case "r" -> dir[i] = Direction.RIGHT;
                case "l" -> dir[i] = Direction.LEFT;
                default -> dir[i] = Direction.UNKNOWN;
            }
        }
        return dir;
    }


}
