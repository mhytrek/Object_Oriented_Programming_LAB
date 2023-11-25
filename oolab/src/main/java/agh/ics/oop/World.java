package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
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

        try{
            OptionsParser.change_string_enum(args);
        } catch(IllegalArgumentException ignored){
            System.out.println(ignored.getMessage());
            System.exit(0);
        }

//        GrassField map1 = new GrassField(10);
//        List<MoveDirection> directions = OptionsParser.change_string_enum(args);
//        List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(3,3), new Vector2d(4,1));
//        Simulation simulation1 = new Simulation(directions, positions, map1);
//        MapChangeListener observer = new ConsoleMapDisplay();
//        map1.addObserver(observer);
//
//        RectangularMap map2 = new RectangularMap(5,5);
//        List<Vector2d> positions2 = List.of(new Vector2d(1,3), new Vector2d(0,0));
//        Simulation simulation2 = new Simulation(directions, positions2, map2);
//        MapChangeListener observer2 = new ConsoleMapDisplay();
//        map2.addObserver(observer2);
//
//        SimulationEngine engine = new SimulationEngine(List.of(simulation1,simulation2));
//        engine.runAsync();
//        engine.awaitSimulationsEnd();

        List<Simulation> simulations = new ArrayList<>();
        List<MoveDirection> directions = OptionsParser.change_string_enum(args);
        List<AbstractWorldMap> maps = new ArrayList<>();
        List<MapChangeListener> listeners = new ArrayList<>();
        for(int i =0; i < 100; i++){
            maps.add(new GrassField(10));
            List<Vector2d> positions = List.of(new Vector2d(0,0), new Vector2d(4,4));
            simulations.add(new Simulation(directions, positions, maps.get(i)));
            listeners.add(new ConsoleMapDisplay());
            maps.get(i).addObserver(listeners.get(i));
        }
        SimulationEngine engine = new SimulationEngine(simulations);
        engine.runAsync();
        System.out.println("System zakończył działania");
    }
}