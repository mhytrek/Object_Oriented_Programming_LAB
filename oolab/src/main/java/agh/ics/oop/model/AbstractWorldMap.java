package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, WorldElement> animals = new HashMap<>();
    protected Vector2d lower_left;
    protected Vector2d upper_right;
    protected UUID id;
    protected List<MapChangeListener> listeners = new ArrayList<>();
    MapVisualizer mapVisualizer;

    public abstract Boundary getCurrentBounds();



    public void addObserver(MapChangeListener observer) {
        listeners.add(observer);
    }

    // Add a method to unregister observers
    public void removeObserver(MapChangeListener observer) {
        listeners.remove(observer);
    }

    // Add a method to notify observers about animal placement or movement
    public void mapChanged(String message) {
        for (MapChangeListener listener : listeners) {
            listener.mapChanged(this, message);

        }
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public String toString() {
        Boundary b = this.getCurrentBounds();
        this.lower_left = b.lower_left();
        this.upper_right = b.upper_right();
        return mapVisualizer.draw(this.lower_left, this.upper_right);
    }

    public synchronized void move(Animal animal, MoveDirection direction){
        if(animals.containsValue(animal)){
            Vector2d p = animal.getPosition();
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            try {
                place(animal);
                this.mapChanged("Zwierzę na " + animal.getPosition().toString());
            } catch (PositionAlreadyOccupiedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    

    public boolean place(Animal animal) throws PositionAlreadyOccupiedException {
        if (this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }

        else{
            throw new PositionAlreadyOccupiedException(animal.getPosition());
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
