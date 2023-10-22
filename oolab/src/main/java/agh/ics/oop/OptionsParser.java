package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] change_string_enum(String[] args){
        MoveDirection[] direction = new MoveDirection[args.length];
        for(int i=0; i < args.length; i++ ) {
            switch (args[i]) {
                case "b" -> direction[i] = MoveDirection.BACKWARD;
                case "f" -> direction[i] = MoveDirection.FORWARD;
                case "r" -> direction[i] = MoveDirection.RIGHT;
                case "l" -> direction[i] = MoveDirection.LEFT;
                default -> System.out.print("");
            };
        }
        return direction;
    }
}
