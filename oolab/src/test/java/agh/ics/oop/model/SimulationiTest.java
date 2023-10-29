package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationiTest {
    @Test
    public void simulation_integrity_test(){
        String[] args1 = {"f", "f", "b", "l", "r", "ww", "r", "r", "r", "f", "f", "f"};
        List<MoveDirection> directions1 = OptionsParser.change_string_enum(args1);
        List<Vector2d> positions1 = List.of(new Vector2d(0,0));
        Simulation simulation1 = new Simulation(directions1, positions1);
        simulation1.run();

        Animal animal1 = simulation1.animals.get(0);
        assertEquals( "Pozycja: (0, 1) Orientacja: Zachód",animal1.toString());

        String[] args2 = {"b", "f", "r", "l", "o"};
        List<MoveDirection> directions2 = OptionsParser.change_string_enum(args2);
        List<Vector2d> positions2 = List.of(new Vector2d(0,0), new Vector2d(1,4));
        Simulation simulation2 = new Simulation(directions2, positions2);
        simulation2.run();

        Animal animal2 = simulation2.animals.get(0);
        Animal animal3 = simulation2.animals.get(1);
        assertEquals( "Pozycja: (0, 0) Orientacja: Wschód",animal2.toString());
        assertEquals( "Pozycja: (1, 4) Orientacja: Zachód",animal3.toString());

    }
}

