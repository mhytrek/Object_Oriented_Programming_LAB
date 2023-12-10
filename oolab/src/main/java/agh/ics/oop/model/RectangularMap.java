package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RectangularMap extends AbstractWorldMap implements WorldMap{
    private final int height;
    private final int width;
    private Vector2d lower_left;
    private Vector2d upper_right;
    Map<Vector2d, Animal> animals;
//    MapVisualizer mapVisualizer;

    public RectangularMap(int height, int width){
        this.id = UUID.randomUUID();
        this.height = height;
        this.width = width;
        this.lower_left = new Vector2d(0,0);
        this.upper_right = new Vector2d(width,height);
        this.animals = new HashMap<>();
        this.mapVisualizer = new  MapVisualizer(this);
    }

//    @Override
//    public boolean place(Animal animal){
//        if (this.canMoveTo(animal.getPosition())){
//            animals.put(animal.getPosition(), animal);
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

//    @Override
//    public void move(Animal animal, MoveDirection direction){
//        if(animals.containsValue(animal)){
//            Vector2d p = animal.getPosition();
//            animals.remove(animal.getPosition());
//            animal.move(direction, this);
//            place(animal);
//        }
//    }

//    @Override
//    public boolean isOccupied(Vector2d position){
//        return (animals.containsKey(position));
//    }

//    @Override
//    public WorldElement objectAt(Vector2d position){
//        return animals.get(position);
//    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(this.lower_left, this.upper_right);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!(super.canMoveTo(position)) | !(position.follows(lower_left) && position.precedes(upper_right))){
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return mapVisualizer.draw(lower_left, upper_right);
//    }
}
