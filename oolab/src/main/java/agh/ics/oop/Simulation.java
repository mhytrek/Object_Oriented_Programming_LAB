package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public List<Animal> animals;
    List<MoveDirection> moves;
    public Simulation(List<MoveDirection> moves, List<Vector2d> start_positions){
        this.moves = moves;
        List<Animal> animals = new ArrayList<>();
        for(Vector2d start_position: start_positions){
            animals.add(new Animal(start_position));
        }
        this.animals = animals;
    }

    public void run(){
        for(Animal animal:animals){
            int index = animals.indexOf(animal);
            for(int j = index; j < moves.size(); j += animals.size()){
                animal.move(moves.get(j));
                System.out.printf("Zwierzę %d: %s \n", index, animal.toString().substring(8,15));
            }
        }
    }
}
