package agh.ics.oop;
import java.util.Scanner;

public class World {

    private static int cnt;

    public static void main(String[] args){

        Scanner word = new Scanner(System.in);
        String str = word.nextLine();


        System.out.println("start");
        Direction[] dir = string_to_enum(str);
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
    static Direction[] string_to_enum(String args){
        int len = args.length();
        char[] res = new char[len];
        args.getChars(0, len,res, 0);

        int cnt = 0;
        for(int i = 0; i < len; i++){
            if (res[i] == 'f' || res[i] == 'r' || res[i] == 'l' || res[i] == 'b'){
                cnt++;
            }
        }
        Direction[] dir = new Direction[cnt];
        cnt--;
        for(int i = 0; i < len; i++){
            switch (res[i]){
                case 'f':
                    dir[cnt] = Direction.FORWARD;
                    cnt--;
                    break;
                case 'b':
                    dir[cnt] = Direction.BACKWARD;
                    cnt--;
                    break;
                case 'r':
                    dir[cnt] = Direction.RIGHT;
                    cnt--;
                    break;
                case 'l':
                    dir[cnt] = Direction.LEFT;
                    cnt--;
                    break;
                default:
                    break;
            }
        }
        return dir;
    }

}
