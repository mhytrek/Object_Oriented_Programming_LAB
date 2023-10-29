package agh.ics.oop.model;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    public Animal(Vector2d position){
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    public Animal(){}

    public String toString(){
        return String.format("Pozycja: (%d, %d) Orientacja: %s", this.position.getX(), this.position.getY(), this.orientation);
    }

    boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        Vector2d copy_position = this.position;
        switch(direction){
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case BACKWARD -> this.position = this.position.subtract(this.orientation.toUnitVector());
            case FORWARD -> this.position = this.position.add(this.orientation.toUnitVector());
        }
        Vector2d vector_min = new Vector2d(0,0);
        Vector2d vector_max = new Vector2d(4,4);
        if(this.position.follows(vector_max) || this.position.precedes(vector_min)){
            System.out.println("wyzerowane");
            this.position = copy_position;
        }
    }



}
