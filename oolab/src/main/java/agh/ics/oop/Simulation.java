package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public List<Animal> animals;
    public WorldMap map;
    List<MoveDirection> moves;
    public Simulation(List<MoveDirection> moves, List<Vector2d> start_positions, WorldMap map){
        this.moves = moves;
        this.map = map;
        List<Animal> animals = new ArrayList<>();
        for(Vector2d start_position: start_positions) {
            animals.add(new Animal(start_position));
//            if(map.place(animals.get(animals.size()-1))){
//                System.out.println("dodano");
//            }
//            else{
//                animals.remove(animals.get(animals.size()-1));
//            }
            try {
                map.place(animals.get(animals.size() - 1));
            } catch(PositionAlreadyOccupiedException e){
                System.out.println(e.getMessage());
            }
        }
        this.animals = animals;
    }

    public void run(){
        for(Animal animal:animals){
            int index = animals.indexOf(animal);
            for(int j = index; j < moves.size(); j += animals.size()){
                map.move(animal, moves.get(j));
//                System.out.println(map.toString());
            }
        }
    }
}
