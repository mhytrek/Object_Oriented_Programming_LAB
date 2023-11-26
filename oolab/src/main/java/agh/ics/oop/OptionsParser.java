package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> change_string_enum(String[] args){
        List<MoveDirection> directionList = new ArrayList<>();
        for(String arg: args) {
            switch (arg) {
                case "b" -> directionList.add(MoveDirection.BACKWARD);
                case "f" -> directionList.add(MoveDirection.FORWARD);
                case "r" -> directionList.add(MoveDirection.RIGHT);
                case "l" -> directionList.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(arg + "is not legal move specification");
            }
        }
        return directionList;
    }
}
