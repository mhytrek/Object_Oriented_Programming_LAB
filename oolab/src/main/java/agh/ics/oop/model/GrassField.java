package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements WorldMap{
    private int grass_amount;
    private int grass_pos;
    private Vector2d lower_left;
    private Vector2d upper_right;
    Map<Vector2d, Animal> animals;
    Map<Vector2d, Grass> grass;
//    MapVisualizer mapVisualizer;

    public GrassField(int grass_amount){
        this.grass_amount=grass_amount;
        this.animals = new HashMap<>();
        this.grass = new HashMap<>();
        this.grass_pos = (int) sqrt(grass_amount*10);
        this.lower_left = new Vector2d(grass_pos,grass_pos);
        this.upper_right = new Vector2d(0,0);
        this.mapVisualizer = new  MapVisualizer(this);
//        for(int i=0; i < grass_amount; i++){
//            Vector2d p = new Vector2d(-1,-1);
//            while(p.equals(new Vector2d(-1, -1)) && !grass.containsKey(p)){
//                int x = (int) (Math.random() * this.grass_pos);
//                int y = (int) (Math.random() * this.grass_pos);
//                p = new Vector2d(x,y);
//            }
//            grass.put(p,new Grass(p));
//        }
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(this.grass_pos, this.grass_pos, this.grass_amount);
        Iterator<Vector2d> positionsIterator = randomPositionGenerator.iterator();

        while(positionsIterator.hasNext()) {
            Vector2d grassPosition =  positionsIterator.next();
            this.grass.put(grassPosition, new Grass(grassPosition));
        }
    }
//    @Override
//    public boolean canMoveTo(Vector2d position) {
//        return !(animals.containsKey(position));
//    }

//    @Override
//    public boolean place(Animal animal) {
//        if (this.canMoveTo(animal.getPosition())){
//            animals.put(animal.getPosition(), animal);
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

//    @Override
//    public void move(Animal animal, MoveDirection direction) {
//        if(animals.containsValue(animal)){
//            Vector2d p = animal.getPosition();
//            animals.remove(animal.getPosition());
//            animal.move(direction, this);
//            place(animal);
//        }
//    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (super.isOccupied(position) || grass.containsKey(position));
    }

    @Override
    Boundary getCurrentBounds() {
        Set<Vector2d> vectors = new HashSet<>(animals.keySet());
        vectors.addAll(grass.keySet());
        for(Vector2d v: vectors){
            this.upper_right = this.upper_right.upperRight(v);
            this.lower_left = this.lower_left.lowerLeft(v);
        }
        return new Boundary(this.lower_left,this.upper_right);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement element = super.objectAt(position);
        if(element != null){
            return element;
        } else if (grass.containsKey(position)){
            return grass.get(position);
        }
        return null;
    }
//    @Override
//    public String toString() {
//        return mapVisualizer.draw(this.lower_left, this.upper_right);
//    }

    @Override
    public Map<Vector2d, WorldElement> getElements(){
        Map<Vector2d, WorldElement> combined = new HashMap<>();
        combined.putAll(super.getElements());
        combined.putAll(grass);
        return combined;
    }
}
