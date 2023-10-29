package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class World {
    public static void run(List<MoveDirection> args){
        for(MoveDirection argument : args){
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
    }

    public static void main(String[] args){
        System.out.println("System wystartował");
        //Animal Cynamon = new Animal();
        //System.out.println(Cynamon.toString());
        //run(OptionsParser.change_string_enum(args));
        List<MoveDirection> directions = OptionsParser.change_string_enum(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(directions, positions);
        simulation.run();
        System.out.println("System zakończył działania");
    }
}