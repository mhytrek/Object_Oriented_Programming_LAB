package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, WorldElement> animals = new HashMap<>();

    public void move(Animal animal, MoveDirection direction){
        if(animals.containsValue(animal)){
            Vector2d p = animal.getPosition();
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            place(animal);
        }
    }

    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean canMoveTo(Vector2d position) {
        return !(animals.containsKey(position));
    }

    public WorldElement objectAt(Vector2d position){
        return animals.get(position);
    }

    public boolean isOccupied(Vector2d position){
        return (animals.containsKey(position));
    }

    public Map<Vector2d, WorldElement> getElements(){
        return animals;
    }
}
