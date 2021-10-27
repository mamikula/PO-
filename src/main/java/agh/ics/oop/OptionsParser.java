package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OptionsParser {

    public List<MoveDirection> parse(String[] directions){
        List<MoveDirection> moveDirections= new LinkedList<>();

        for(String direction: directions){
            switch(direction){
                case "f", "forward" -> moveDirections.add(MoveDirection.FORWARD);
                case "b", "backward" -> moveDirections.add(MoveDirection.BACKWARD);
                case "r", "right" -> moveDirections.add(MoveDirection.RIGHT);
                case "l", "left" -> moveDirections.add(MoveDirection.LEFT);
            }
        }
        return moveDirections;
    }

//    public MoveDirection[] parse(String[] args){
//        int ln = 0;
//        for(String i : args){
//            if (i.equals("f") || i.equals("forward") || i.equals("b") || i.equals("backward")
//                    || i.equals("l") || i.equals("left") || i.equals("r") || i.equals("right")) ln++;
//        }
//        MoveDirection[] moveDirections = new MoveDirection[ln];
//
//        int i = 0;
//        for (String direction: args){
//            switch(direction){
//                case "f", "forward" -> {moveDirections[i] = agh.ics.oop.MoveDirection.FORWARD; i++;}
//                case "r", "right" -> {moveDirections[i] = agh.ics.oop.MoveDirection.RIGHT; i++;}
//                case "b", "backward" -> {moveDirections[i] = agh.ics.oop.MoveDirection.BACKWARD; i++;}
//                case "l", "left" -> {moveDirections[i] = agh.ics.oop.MoveDirection.LEFT; i++;}
//            }
//        }
//        return moveDirections;
//    }

}
